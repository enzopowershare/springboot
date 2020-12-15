package com.cloudwise.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Personinfo)实体类
 *
 * @author makejava
 * @since 2020-12-14 10:20:49
 */
@Data
public class Personinfo implements Serializable {
    private static final long serialVersionUID = 785095670060838737L;

    private Integer personid;

    private String personname;

    private Integer personareaid;

    private Integer personage;

    private String personaddress;

}