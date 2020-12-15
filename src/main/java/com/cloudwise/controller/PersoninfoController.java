package com.cloudwise.controller;

import com.cloudwise.entity.Personinfo;
import com.cloudwise.entity.ReturnBean;
import com.cloudwise.service.PersoninfoService;
import com.cloudwise.util.EnzoTools;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Personinfo)表控制层
 *
 * @author makejava
 * @since 2020-12-14 10:20:57
 */
@RestController
@RequestMapping("personinfo")
public class PersoninfoController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private PersoninfoService personinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("queryById")
    public ReturnBean queryById(Integer personid) {
        final Personinfo personinfo = personinfoService.queryById(personid);
        if (personinfo.getPersonid() != null) {
            return returnSuccess(personinfo);
        } else {
            return returnFail(null);
        }
    }

    /**
     * @return : returnBean
     * @createBy : Enzo
     * @description : 查询所有并分页
     * @createTime : 2020/12/15 9:30
     */
    @GetMapping("selectAllByLimit")
    public ReturnBean selectAllByLimit(PageBean pageBean) {
        int offset = getOffset(pageBean);
        final List<Personinfo> personinfos = personinfoService.queryAllByLimit(offset, pageBean.getLimit());
        int count = (int) personinfoService.getRowCount();
        final ReturnBean returnBean = returnSuccess(personinfos);
        returnBean.setCount(count);
        return returnBean;
    }

    /**
     * @return : returnBean
     * @createBy : Enzo
     * @description : 插入操作
     * @createTime : 2020/12/15 9:31
     */
    @RequestMapping("insert")
    public ReturnBean insert(Personinfo personinfo) {
        try {
            final Personinfo insert = personinfoService.insert(personinfo);
            return returnSuccess(insert);
        } catch (Exception e) {
            return returnFail(null);
        }
    }

    /**
     * @return : returnBean
     * @createBy : Enzo
     * @description : 根据id删除人员
     * @createTime : 2020/12/15 9:33
     */
    @RequestMapping("deleteById")
    public ReturnBean deleteById(Integer personid) {
        final boolean delete = personinfoService.deleteById(personid);
        if (delete) {
            return returnSuccess(null);
        }
        return returnFail(null);
    }

    /**
     * @return :
     * @createBy : Enzo
     * @description : 更新
     * @createTime : 2020/12/15 9:36
     */
    @RequestMapping("update")
    public ReturnBean update(Personinfo personinfo) {
        try {
            final Personinfo update = personinfoService.update(personinfo);
            return returnSuccess(update);
        } catch (Exception e) {
            return returnFail(null);
        }
    }

    @RequestMapping("deletePersonByIds")
    public ReturnBean deletePersonByIds(String ids) {
        boolean delete = personinfoService.deleteByIds(ids);
        if (delete) {
            return returnSuccess(null);
        }
        return returnFail(null);
    }
}