package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Tongji;

/**
 * 统计信息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITongjiService 
{
    /**
     * 查询统计信息
     * 
     * @param id 统计信息主键
     * @return 统计信息
     */
    public Tongji selectTongjiById(Long id);

    /**
     * 查询统计信息列表
     * 
     * @param tongji 统计信息
     * @return 统计信息集合
     */
    public List<Tongji> selectTongjiList(Tongji tongji);

    /**
     * 新增统计信息
     * 
     * @param tongji 统计信息
     * @return 结果
     */
    public int insertTongji(Tongji tongji);

    /**
     * 修改统计信息
     * 
     * @param tongji 统计信息
     * @return 结果
     */
    public int updateTongji(Tongji tongji);

    /**
     * 批量删除统计信息
     * 
     * @param ids 需要删除的统计信息主键集合
     * @return 结果
     */
    public int deleteTongjiByIds(Long[] ids);

    /**
     * 删除统计信息信息
     * 
     * @param id 统计信息主键
     * @return 结果
     */
    public int deleteTongjiById(Long id);
}
