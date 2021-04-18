package com.swalikh.auto.autobuilder.configuration;

import com.swalikh.auto.autobuilder.utils.IDUtils;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/6/12  10:02
 * use to：自定义主键---主键为Long型的
 * modify：
 */
public class StringIdGenerator extends UUIDGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        String timeId = IDUtils.getTimeId();
        if (timeId != null) {
            return (Serializable) timeId;
        }
        return super.generate(session, object);
    }
}