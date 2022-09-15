package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TongjiMapper;
import com.ruoyi.system.domain.Tongji;
import com.ruoyi.system.service.ITongjiService;

/**
 * 统计信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TongjiServiceImpl implements ITongjiService 
{
    @Autowired
    private TongjiMapper tongjiMapper;

    /**
     * 查询统计信息
     * 
     * @param id 统计信息主键
     * @return 统计信息
     */
    @Override
    public Tongji selectTongjiById(Long id)
    {
        return tongjiMapper.selectTongjiById(id);
    }

    /**
     * 查询统计信息列表
     * 
     * @param tongji 统计信息
     * @return 统计信息
     */
    @Override
    public List<Tongji> selectTongjiList(Tongji tongji)
    {
        return tongjiMapper.selectTongjiList(tongji);
    }

    /**
     * 新增统计信息
     * 
     * @param tongji 统计信息
     * @return 结果
     */
    @Override
    public int insertTongji(Tongji tongji)
    {
        return tongjiMapper.insertTongji(tongji);
    }

    /**
     * 修改统计信息
     * 
     * @param tongji 统计信息
     * @return 结果
     */
    @Override
    public int updateTongji(Tongji tongji)
    {
        return tongjiMapper.updateTongji(tongji);
    }

    /**
     * 批量删除统计信息
     * 
     * @param ids 需要删除的统计信息主键
     * @return 结果
     */
    @Override
    public int deleteTongjiByIds(Long[] ids)
    {
        return tongjiMapper.deleteTongjiByIds(ids);
    }

    /**
     * 删除统计信息信息
     * 
     * @param id 统计信息主键
     * @return 结果
     */
    @Override
    public int deleteTongjiById(Long id)
    {
        return tongjiMapper.deleteTongjiById(id);
    }
}
