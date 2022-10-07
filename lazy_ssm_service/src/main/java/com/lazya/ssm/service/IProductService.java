package com.lazya.ssm.service;

import com.lazya.ssm.domain.Product;

import java.util.List;

/**
 * Title: IProductService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 27 13 33
 */
public interface IProductService {

    public List<Product> findAll(int page, int size) throws Exception;

    public void save(Product product);
}
