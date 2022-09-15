package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.Orderfmor2Mapper;
import com.ruoyi.system.domain.Orderfmor2;
import com.ruoyi.system.service.IOrderfmor2Service;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class Orderfmor2ServiceImpl implements IOrderfmor2Service 
{
    @Autowired
    private Orderfmor2Mapper orderfmor2Mapper;

    /**
     * 查询订单信息
     * 
     * @param onum 订单信息主键
     * @return 订单信息
     */
    @Override
    public Orderfmor2 selectOrderfmor2ByOnum(Long onum)
    {
        return orderfmor2Mapper.selectOrderfmor2ByOnum(onum);
    }

    /**
     * 查询订单信息列表
     * 
     * @param orderfmor2 订单信息
     * @return 订单信息
     */
    @Override
    public List<Orderfmor2> selectOrderfmor2List(Orderfmor2 orderfmor2)
    {
        return orderfmor2Mapper.selectOrderfmor2List(orderfmor2);
    }

    /**
     * 新增订单信息
     * 
     * @param orderfmor2 订单信息
     * @return 结果
     */
    @Override
    public int insertOrderfmor2(Orderfmor2 orderfmor2)
    {
        return orderfmor2Mapper.insertOrderfmor2(orderfmor2);
    }

    /**
     * 修改订单信息
     * 
     * @param orderfmor2 订单信息
     * @return 结果
     */
    @Override
    public int updateOrderfmor2(Orderfmor2 orderfmor2)
    {
        return orderfmor2Mapper.updateOrderfmor2(orderfmor2);
    }

    /**
     * 批量删除订单信息
     * 
     * @param onums 需要删除的订单信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderfmor2ByOnums(Long[] onums)
    {
        return orderfmor2Mapper.deleteOrderfmor2ByOnums(onums);
    }

    /**
     * 删除订单信息信息
     * 
     * @param onum 订单信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderfmor2ByOnum(Long onum)
    {
        return orderfmor2Mapper.deleteOrderfmor2ByOnum(onum);
    }
}
