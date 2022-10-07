package com.lazya.ssm.service;

import com.lazya.ssm.domain.Orders;

import java.util.List;

/**
 * Title: IOrdersService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 13 37
 */
public interface IOrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
