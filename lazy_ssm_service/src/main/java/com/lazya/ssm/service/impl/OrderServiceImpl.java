package com.lazya.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lazya.ssm.dao.IOrdersDao;
import com.lazya.ssm.domain.Orders;
import com.lazya.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title: OrderServiceImpl
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 13 38
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //pageNum是页码值 pageSize是每页显示参数
        //在真正执行sql前使用PageHelper来完成分页
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
