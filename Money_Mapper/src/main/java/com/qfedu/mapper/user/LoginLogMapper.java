package com.qfedu.mapper.user;

import com.qfedu.domain.user.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginLogMapper {
    @Insert("insert into t_loginlog (ip,createtime,uid,msg)values (#{ip},#{creatime},#{uid},#{msg})")
    int insert(LoginLog record);
    @Select("select id,ip,createtime,uid,msg from t_loginlog where id=#{id}")
    @ResultType(LoginLog.class)
    LoginLog selectById(int id);
    @Select("select id,ip,createtime,uid,msg form t_loginlog")
    @ResultType(LoginLog.class)
    List<LoginLog> selectAll();
}
