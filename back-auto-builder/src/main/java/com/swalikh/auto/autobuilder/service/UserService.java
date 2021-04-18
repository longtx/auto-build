package com.swalikh.auto.autobuilder.service;

import com.swalikh.auto.autobuilder.base.BaseService;
import com.swalikh.auto.autobuilder.entity.RestResult;
import com.swalikh.auto.autobuilder.entity.User;
import com.swalikh.auto.autobuilder.repository.UserRepository;
import com.swalikh.auto.autobuilder.utils.Result;

public interface UserService extends BaseService<User,String, UserRepository> {


    RestResult login(User user);
}
