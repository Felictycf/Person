package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Orderfmor2;

/**
 * 订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface Orderfmor2Mapper 
{
    /**
     * 查询订单信息
     * 
     * @param onum 订单信息主键
     * @return 订单信息
     */
    public Orderfmor2 selectOrderfmor2ByOnum(Long onum);

    /**
     * 查询订单信息列表
     * 
     * @param orderfmor2 订单信息
     * @return 订单信息集合
     */
    public List<Orderfmor2> selectOrderfmor2List(Orderfmor2 orderfmor2);

    /**
     * 新增订单信息
     * 
     * @param orderfmor2 订单信息
     * @return 结果
     */
    public int insertOrderfmor2(Orderfmor2 orderfmor2);

    /**
     * 修改订单信息
     * 
     * @param orderfmor2 订单信息
     * @return 结果
     */
    public int updateOrderfmor2(Orderfmor2 orderfmor2);

    /**
     * 删除订单信息
     * 
     * @param onum 订单信息主键
     * @return 结果
     */
    public int deleteOrderfmor2ByOnum(Long onum);

    /**
     * 批量删除订单信息
     * 
     * @param onums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderfmor2ByOnums(Long[] onums);
}
