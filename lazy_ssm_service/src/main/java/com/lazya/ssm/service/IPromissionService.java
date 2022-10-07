package com.lazya.ssm.service;

import com.lazya.ssm.domain.Permission;

import java.util.List;

/**
 * Title: IPromissionService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 03 16 27
 */
public interface IPromissionService {
    List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;
}
