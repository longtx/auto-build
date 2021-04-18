package com.swalikh.auto.autobuilder.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/4/1  14:33
 * use to：系统集中管理用户数据
 * modify：
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.swalikh.auto.autobuilder.configuration.StringIdGenerator")
    private String id;

    @Column(name = "name")  //真实姓名
    private String name;

//    @Column(name = "sex")   //性别
//    private String sex;
//
//    @Column(name = "identity") //身份证号码
//    private String identity;

    @Column(name = "username") //用户名
    private String username;

    @Column(name = "password") //密码 Bcript
    private String password;

    @Column(name = "ipAddr") //电脑IP地址
    private String ip;
//
//    @Column(name = "phone") //手机号码
//    private String phone;
//
//    @Column(name = "qq") //qq号码
//    private String qq;
//
//    @Column(name = "wechat") //微信号码
//    private String wechat;
//
//    @Column(name = "birthday") //生日
//    private Date birthday;
//
//    @Column(name = "email") //邮箱号码
//    private String email;
//
//    @Column(name = "address") //联系地址
//    private String address;
//
//    @CreatedDate //创建时间
//    private Date cjsj;
//
//    @LastModifiedDate //修改时间
//    private Date xgsj;
//
//    @Column(name = "last_login") //上次登录时间
//    private Date lastLogin;
//
//    @Column(name = "last_reset_passwd") //上次登录时间
//    private Date lastResetPasswd;
//
//    @Column(name = "zt") //账户当前状态  0-未启用，1-启用'
//    private String zt;

    @Column(name = "token")
    private String  token;  // 所有的job数据

    @Column(name = "uuid")
    private String  uuid;  // 所有的job数据




}