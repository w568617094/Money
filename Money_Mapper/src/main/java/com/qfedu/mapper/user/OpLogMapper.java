package com.qfedu.mapper.user;

import com.qfedu.domain.user.LoginLog;
import com.qfedu.domain.user.OpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OpLogMapper {
    @Insert("")
    int insert(OpLog record);
    @Select("select id,ip,create,uid,msg from t_loginlog where id = #{id}")
    @ResultType(LoginLog.class)
    List<OpLog> selectByType(int type);
}
