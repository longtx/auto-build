package com.swalikh.auto.autobuilder.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/4/1  14:33
 * use to：系统集中管理企业数据
 * modify：
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "venus_job")
public class VenusJob extends Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.swalikh.auto.autobuilder.configuration.StringIdGenerator")
    private String id;

    @Column(name = "venus_job_name")  // venus的英文名字
    private String venus_job_name;

//    @Column(name = "params")  // 其他的参数
//    private String params;

    @Column(name = "appid")  // 应用的ID
    private String appid;

    @Column(name = "name")  // job的名称 中文名字，自定义
    private String name;

    @Column(name = "mid")   // job的归属
    private String mid;

    @Column(name = "step")  // job的步骤
    private Integer step;

    @Column(name = "total_time")  // 上次构建总共用时(分钟计算)
    private Integer total_time;



//    @Column(name = "last_image_version")  // 上次更新记录下来的镜像版本 xxx.xxx.xxx.xxx/xxx/xxx:vx.x.x
//    private String last_image_version;
//
//    @Column(name = "type")  // job的类型  1 jenkins-job  2 venus-job
//    private String type;
//
//    @Temporal(TemporalType.DATE)  // 上次任务执行时间
//    @Column(name = "last_excute_time")
//    private Date last_excute_time;
//
//    @CreatedDate
//    @Column(name = "cjsj")  //创建时间
//    private Date cjsj;
//
//    @UpdateTimestamp
//    @Column(name = "xgsj")  //修改时间
//    private Date xgsj;
//
//    @Column(name = "zt")  // 状态( 0 项目暂停  1 正常)
//    private String zt;

}
