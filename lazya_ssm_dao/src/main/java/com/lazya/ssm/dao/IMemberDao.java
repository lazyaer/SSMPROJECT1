package com.lazya.ssm.dao;

import com.lazya.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * Title: IMemberDao
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 16 52
 */
public interface IMemberDao {

    //根据id查询用户信息
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
