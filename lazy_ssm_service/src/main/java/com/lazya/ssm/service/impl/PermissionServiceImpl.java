package com.lazya.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lazya.ssm.dao.IPermissionDao;
import com.lazya.ssm.domain.Permission;
import com.lazya.ssm.service.IPromissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: PermissionServiceImpl
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 03 16 26
 */
@Service
public class PermissionServiceImpl implements IPromissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
