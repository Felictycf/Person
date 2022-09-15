package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Tongji;

/**
 * 统计信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TongjiMapper 
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
     * 删除统计信息
     * 
     * @param id 统计信息主键
     * @return 结果
     */
    public int deleteTongjiById(Long id);

    /**
     * 批量删除统计信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTongjiByIds(Long[] ids);
}
