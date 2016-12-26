package com.vinhomn.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinhomn.data.domain.Authority;
import com.vinhomn.service.AuthorityService;

@Service("authorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityService authorityService;
    
    @Override
    public Authority save(Authority entity) {
        return authorityService.save(entity);
    }

    @Override
    public Authority findOne(short id) {
        return authorityService.findOne(id);
    }

    @Override
    public Authority findOneByCode(String code) {
        return authorityService.findOneByCode(code);
    }

}
