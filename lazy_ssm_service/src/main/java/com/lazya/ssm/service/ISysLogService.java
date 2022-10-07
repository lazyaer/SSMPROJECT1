package com.lazya.ssm.service;

import com.lazya.ssm.domain.SysLog;

import java.util.List;

/**
 * Title: ISysLogService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 07 14 03
 */
public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page,int size) throws Exception;
}
