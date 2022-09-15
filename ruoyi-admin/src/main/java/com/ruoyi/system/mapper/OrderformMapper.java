package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Orderform;

/**
 * 订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface OrderformMapper 
{
    /**
     * 查询订单信息
     * 
     * @param onum 订单信息主键
     * @return 订单信息
     */
    public Orderform selectOrderformByOnum(String onum);

    /**
     * 查询订单信息列表
     * 
     * @param orderform 订单信息
     * @return 订单信息集合
     */
    public List<Orderform> selectOrderformList(Orderform orderform);

    /**
     * 新增订单信息
     * 
     * @param orderform 订单信息
     * @return 结果
     */
    public int insertOrderform(Orderform orderform);

    /**
     * 修改订单信息
     * 
     * @param orderform 订单信息
     * @return 结果
     */
    public int updateOrderform(Orderform orderform);

    /**
     * 删除订单信息
     * 
     * @param onum 订单信息主键
     * @return 结果
     */
    public int deleteOrderformByOnum(String onum);

    /**
     * 批量删除订单信息
     * 
     * @param onums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderformByOnums(String[] onums);
}
