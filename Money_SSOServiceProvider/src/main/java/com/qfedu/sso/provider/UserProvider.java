package com.qfedu.sso.provider;

import com.alibaba.fastjson.JSON;
import com.qfedu.core.redis.JedisUtil;
import com.qfedu.core.util.ExecuteUtils;
import com.qfedu.core.util.IdGenerator;
import com.qfedu.core.vo.R;
import com.qfedu.domain.user.User;
import com.qfedu.mapper.user.UserMapper;
import com.qfedu.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class UserProvider implements UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private JedisUtil jedisUtil;


    @Override
    public R save(User user) {
        return ExecuteUtils.getR(mapper.insert(user),"新增用户");
    }

    @Override
    public List<User> query() {
        return mapper.queryPage(0,20);
    }

    @Override
    public User queryBy(String name) {
        User user = mapper.queryBy(name);
        return user;
    }

    @Override
    public R ssoLogin(String name, String password) {
        User user =mapper.queryBy(name);
        if (user!=null){
            if (Objects.equals(password,user.getPassword())){
                long tk = idGenerator.nextId();
                jedisUtil.addStr("usertoken:" +tk,JSON.toJSONString(user));
                jedisUtil.expire("usertoken:"+tk, TimeUnit.MINUTES,30);
                return new R(0,tk+"",user);
            }else {
                return R.setError("密码不正确");

            }
        }else {
            return R.setError("用户名不存在");
        }

    }

    @Override
    public R ssoCheck(String token) {
        if (jedisUtil.isKey("usertoken" + token)){
            jedisUtil.expire("usertoken:" + token,TimeUnit.MINUTES,30);
            return new R(0,"存在",JSON.parseObject(jedisUtil.getStr("usertoken:"+token ),User.class));
        }else {
            return R.setError("不存在");
        }

    }

    @Override
    public R loginOut(String token) {
        jedisUtil.delKey("usertoken:"+token);
        return R.setOK("注销成功");
    }
}
