package com.lazya.ssm.dao;

import com.lazya.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Title: IProductDao
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 27 13 30
 */
public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

    //查询所有的产品
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);
}
