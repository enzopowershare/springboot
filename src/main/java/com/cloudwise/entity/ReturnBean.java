package com.cloudwise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Enzo
 * @version : 1.0
 * @date : Created on 2020/12/11 16:26
 * @description :
 * @modifiedBy :
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnBean {

    private int code;
    private String msg;
    private int count;
    private Object data;
}
