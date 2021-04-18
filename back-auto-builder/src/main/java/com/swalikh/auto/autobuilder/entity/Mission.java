package com.swalikh.auto.autobuilder.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/4/1  14:33
 * use to：全自动打包任务表
 * modify：
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "mission")
@Proxy(lazy = false)
public class Mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.swalikh.auto.autobuilder.configuration.StringIdGenerator")
    private String id;

    @Column(name = "name")  // 任务名称 ---物料管理系统开发环境
    private String name;

    @Column(name = "socket_name")  // 任务名称 ---物料管理系统开发环境
    private String socketName;

    @Column(name = "modules")  // 模块数目 --- 14
    private Integer modules;

    @Column(name = "creater")  // 创建人
    private String creater;

    @Column(name = "strategy")  // 版本控制策略  1 为日期时间  2 为自定义
    private String strategy;

    @Column(name = "version")  // 自定义版本号
    private String version;

//    @Column(name = "last_builder")  // 上次构建人
//    private String last_builder;

//    @Temporal(TemporalType.DATE)  // 上次构建时间
//    @Column(name = "last_build_time")
//    private Date last_build_time;

//    @Column(name = "last_build_status")  // 上次构建的状态
//    private Integer last_build_status;

    @Column(name = "total_time")  // 上次构建总共用时(分钟计算)
    private Integer total_time;

//    @CreatedDate
//    @Column(name = "cjsj")  //创建时间
//    private Date cjsj;
//
//    @UpdateTimestamp
//    @Column(name = "xgsj")  //修改时间
//    private Date xgsj;
//
    @Column(name = "zt")  // 状态( 0 项目正常  1 正在打包)
    private Integer zt;

    @Transient // 排除的字段
    private List<Job> jobs;  // 所有的job数据

}
