package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrderformMapper;
import com.ruoyi.system.domain.Orderform;
import com.ruoyi.system.service.IOrderformService;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class OrderformServiceImpl implements IOrderformService 
{
    @Autowired
    private OrderformMapper orderformMapper;

    /**
     * 查询订单信息
     * 
     * @param onum 订单信息主键
     * @return 订单信息
     */
    @Override
    public Orderform selectOrderformByOnum(String onum)
    {
        return orderformMapper.selectOrderformByOnum(onum);
    }

    /**
     * 查询订单信息列表
     * 
     * @param orderform 订单信息
     * @return 订单信息
     */
    @Override
    public List<Orderform> selectOrderformList(Orderform orderform)
    {
        return orderformMapper.selectOrderformList(orderform);
    }

    /**
     * 新增订单信息
     * 
     * @param orderform 订单信息
     * @return 结果
     */
    @Override
    public int insertOrderform(Orderform orderform)
    {
        return orderformMapper.insertOrderform(orderform);
    }

    /**
     * 修改订单信息
     * 
     * @param orderform 订单信息
     * @return 结果
     */
    @Override
    public int updateOrderform(Orderform orderform)
    {
        return orderformMapper.updateOrderform(orderform);
    }

    /**
     * 批量删除订单信息
     * 
     * @param onums 需要删除的订单信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderformByOnums(String[] onums)
    {
        return orderformMapper.deleteOrderformByOnums(onums);
    }

    /**
     * 删除订单信息信息
     * 
     * @param onum 订单信息主键
     * @return 结果
     */
    @Override
    public int deleteOrderformByOnum(String onum)
    {
        return orderformMapper.deleteOrderformByOnum(onum);
    }
}
