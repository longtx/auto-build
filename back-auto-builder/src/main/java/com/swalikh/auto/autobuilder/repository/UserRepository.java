package com.swalikh.auto.autobuilder.repository;


import com.swalikh.auto.autobuilder.base.BaseRepository;
import com.swalikh.auto.autobuilder.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/4/1  16:35
 * use to：dao
 * modify：
 */
@Repository
public interface UserRepository extends BaseRepository<User, String> {


}