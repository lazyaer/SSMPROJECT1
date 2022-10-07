package com.lazya.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lazya.ssm.dao.IProductDao;
import com.lazya.ssm.domain.Product;
import com.lazya.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title: ProductServiceImpl
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 27 13 35
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    //在业务逻辑层中，一定会有数据访问层的对象
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        //pageNum是页码值 pageSize是每页显示参数
        //在真正执行sql前使用PageHelper来完成分页
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
