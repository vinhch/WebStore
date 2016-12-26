package com.vinhomn.service;

import com.vinhomn.data.domain.Authority;

public interface AuthorityService {
    public Authority save(Authority entity);
    public Authority findOne(short id);
    public Authority findOneByCode(String code);
}
