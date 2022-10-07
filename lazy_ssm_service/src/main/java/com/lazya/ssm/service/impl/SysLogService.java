package com.lazya.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lazya.ssm.dao.ISysLogDao;
import com.lazya.ssm.domain.SysLog;
import com.lazya.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title: SysLogService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 07 14 03
 */
@Service
@Transactional
public class SysLogService implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception{
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
