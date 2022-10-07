package com.lazya.ssm.dao;

import com.lazya.ssm.domain.Member;
import com.lazya.ssm.domain.Orders;
import com.lazya.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Title: IOrdersDao
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 13 40
 */
public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "product",column = "productId",javaType = Product.class, one = @One(select = "com.lazya.ssm.dao.IProductDao.findById"))

    })
    public List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "product",column = "productId",javaType = Product.class, one = @One(select = "com.lazya.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class, one = @One(select = "com.lazya.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class, many = @Many(select = "com.lazya.ssm.dao.ITravellerDao.findByOrdersId")),

    })
    public Orders findById(String ordersId) throws Exception;
}
