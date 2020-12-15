package com.cloudwise.controller;

import com.cloudwise.entity.ReturnBean;
import com.cloudwise.util.ReturnStatusEnum;

/**
 * @author : Enzo
 * @version : 1.0
 * @date : Created on 2020/12/14 16:01
 * @description : base controller
 * @modifiedBy :
 */
public class BaseController {
    /**
     * @param pageBean
     * @return : offset
     * @createBy : Enzo
     * @description : 通用分页参数工具
     * @createTime : 2020/12/14 16:14
     */
    public static int getOffset(PageBean pageBean) {
        int offset = (pageBean.getPage() - 1) * pageBean.getLimit();
        return offset;
    }

    /**
     * @return : returnBean
     * @createBy : Enzo
     * @description : 返回成功的结果
     * @createTime : 2020/12/14 16:29
     */
    public static ReturnBean returnSuccess(Object data) {

        ReturnBean returnBean = new ReturnBean();
        //设置返回状态码
        returnBean.setCode(ReturnStatusEnum.SUCCESS.getCode());
        //设置返回提示信息
        returnBean.setMsg(ReturnStatusEnum.SUCCESS.getMessage());
        //设置返回数据
        returnBean.setData(data);
        return returnBean;
    }

    /**
     * @return : returnBean
     * @createBy : Enzo
     * @description : 返回失败的结果
     * @createTime : 2020/12/14 16:29
     */
    public static ReturnBean returnFail(Object data) {
        ReturnBean returnBean = new ReturnBean();
        returnBean.setCode(ReturnStatusEnum.FAIL.getCode());
        returnBean.setMsg(ReturnStatusEnum.FAIL.getMessage());
        //设置返回数据
        returnBean.setData(data);
        return returnBean;
    }
}
