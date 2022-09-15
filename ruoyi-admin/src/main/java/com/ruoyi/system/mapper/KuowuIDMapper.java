package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.KuowuID;

/**
 * 鲜花订单地址管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
public interface KuowuIDMapper 
{
    /**
     * 查询鲜花订单地址管理
     * 
     * @param huowuId 鲜花订单地址管理主键
     * @return 鲜花订单地址管理
     */
    public KuowuID selectKuowuIDByHuowuId(Long huowuId);

    /**
     * 查询鲜花订单地址管理列表
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 鲜花订单地址管理集合
     */
    public List<KuowuID> selectKuowuIDList(KuowuID kuowuID);

    /**
     * 新增鲜花订单地址管理
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 结果
     */
    public int insertKuowuID(KuowuID kuowuID);

    /**
     * 修改鲜花订单地址管理
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 结果
     */
    public int updateKuowuID(KuowuID kuowuID);

    /**
     * 删除鲜花订单地址管理
     * 
     * @param huowuId 鲜花订单地址管理主键
     * @return 结果
     */
    public int deleteKuowuIDByHuowuId(Long huowuId);

    /**
     * 批量删除鲜花订单地址管理
     * 
     * @param huowuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKuowuIDByHuowuIds(Long[] huowuIds);
}
