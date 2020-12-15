package com.cloudwise.service;

import com.cloudwise.entity.Personinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Personinfo)表服务接口
 *
 * @author makejava
 * @since 2020-12-14 10:20:54
 */
public interface PersoninfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param personid 主键
     * @return 实例对象
     */
    Personinfo queryById(Integer personid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Personinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param personinfo 实例对象
     * @return 实例对象
     */
    Personinfo insert(Personinfo personinfo);

    /**
     * 修改数据
     *
     * @param personinfo 实例对象
     * @return 实例对象
     */
    Personinfo update(Personinfo personinfo);

    /**
     * 通过主键删除数据
     *
     * @param personid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer personid);

    boolean deleteByIds(String ids);

    long getRowCount();

}