package com.lazya.ssm.dao;

import com.lazya.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Title: ISysLogDao
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 07 14 05
 */
public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method,id) " +
            "values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method},#{id})")
    public void save(SysLog sysLog) throws Exception;


    @Select("select * from syslog")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="visitTime",property="visitTime"),
            @Result(column="ip",property="ip"),
            @Result(column="url",property="url"),
            @Result(column="executionTime",property="executionTime"),
            @Result(column="method",property="method"),
            @Result(column="username",property="username")
    })
    public List<SysLog> findAll() throws Exception;
}
