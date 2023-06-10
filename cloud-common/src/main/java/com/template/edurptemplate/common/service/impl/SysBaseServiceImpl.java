package com.template.edurptemplate.common.service.impl;

import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.SysBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.service.impl
 * @ClassName: SysBaseServiceImpl
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
public abstract class SysBaseServiceImpl<T, E extends Serializable> implements SysBaseService<T, E> {
    public abstract SysBaseMapper<T, E> getMappser();

    @Override
    public int insert(T record) {
        return getMappser().insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return this.getMappser().deleteByPrimaryKey(key);
    }

    @Override
    public int delete(T record) {
        return this.getMappser().delete(record);
    }

    @Override
    public int insertSelective(T record) {
        return this.getMappser().insertSelective(record);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return this.getMappser().existsWithPrimaryKey(key);
    }

    @Override
    public List<T> selectAll() {
        return this.getMappser().selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return this.getMappser().selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        return this.getMappser().selectCount(record);
    }

    @Override
    public List<T> select(T record) {
        return this.getMappser().select(record);
    }

    @Override
    public T selectOne(T record) {
        return this.getMappser().selectOne(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return this.getMappser().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return this.getMappser().updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByCondition(Object condition) {
        return this.getMappser().deleteByCondition(condition);
    }

    @Override
    public List<T> selectByCondition(Object condition) {
        return this.getMappser().selectByCondition(condition);
    }

    @Override
    public int selectCountByCondition(Object condition) {
        return this.getMappser().selectCountByCondition(condition);
    }

    @Override
    public int updateByCondition(T record, Object condition) {
        return this.getMappser().updateByCondition(record, condition);
    }

    @Override
    public int updateByConditionSelective(T record, Object condition) {
        return this.getMappser().updateByConditionSelective(record, condition);
    }

    @Override
    public int deleteByExample(Object example) {
        return this.getMappser().deleteByExample(example);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return this.getMappser().selectByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return this.getMappser().selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return this.getMappser().selectOneByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return this.getMappser().updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example) {
        return this.getMappser().updateByExampleSelective(record, example);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.getMappser().deleteByIds(ids);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return this.getMappser().selectByIds(ids);
    }

    @Override
    public int insertList(List<T> recordList) {
        return this.getMappser().insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        return this.getMappser().insertUseGeneratedKeys(record);
    }

}
