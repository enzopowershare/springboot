package com.cloudwise.service.impl;

import com.cloudwise.dao.PersoninfoDao;
import com.cloudwise.entity.Personinfo;
import com.cloudwise.service.PersoninfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * (Personinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-12-14 10:20:55
 */
@Service("personinfoService")
public class PersoninfoServiceImpl implements PersoninfoService {
    @Resource
    private PersoninfoDao personinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param personid 主键
     * @return 实例对象
     */
    @Override
    public Personinfo queryById(Integer personid) {
        return this.personinfoDao.queryById(personid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Personinfo> queryAllByLimit(int offset, int limit) {
        return this.personinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param personinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Personinfo insert(Personinfo personinfo) {
        this.personinfoDao.insert(personinfo);
        return personinfo;
    }

    /**
     * 修改数据
     *
     * @param personinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Personinfo update(Personinfo personinfo) {
        this.personinfoDao.update(personinfo);
        return this.queryById(personinfo.getPersonid());
    }

    /**
     * 通过主键删除数据
     *
     * @param personid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer personid) {
        return this.personinfoDao.deleteById(personid) > 0;
    }

    @Override
    public boolean deleteByIds(String ids) {
        if (ids != null && ids.length() > 0) {
            //将字符串转换成数组
            String[] strings = ids.split(",");
            //将数组转换成list
            List<String> idList = Arrays.asList(strings);
            int i = personinfoDao.deleteByIds(idList);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long getRowCount() {
        return personinfoDao.getRowCount();
    }
}