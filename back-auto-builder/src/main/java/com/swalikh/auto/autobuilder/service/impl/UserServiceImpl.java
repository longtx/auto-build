package com.swalikh.auto.autobuilder.service.impl;

import com.swalikh.auto.autobuilder.base.BaseServiceImpl;
import com.swalikh.auto.autobuilder.entity.RestResult;
import com.swalikh.auto.autobuilder.entity.User;
import com.swalikh.auto.autobuilder.repository.UserRepository;
import com.swalikh.auto.autobuilder.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String, UserRepository> implements UserService {


    @Override
    public User getEntityType() {
        return new User();
    }

    @Override
    public RestResult login(User user) {
        Optional<User> result = this.getRepository().findOne(Example.of(user));
        if(result.isPresent()){
            return RestResult.ok("登录成功！",result.get());
        }
        return RestResult.err("登录失败，用户名或密码错误！");
    }
}
