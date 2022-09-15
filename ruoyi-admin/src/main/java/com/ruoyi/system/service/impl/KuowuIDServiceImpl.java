package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KuowuIDMapper;
import com.ruoyi.system.domain.KuowuID;
import com.ruoyi.system.service.IKuowuIDService;

/**
 * 鲜花订单地址管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@Service
public class KuowuIDServiceImpl implements IKuowuIDService 
{
    @Autowired
    private KuowuIDMapper kuowuIDMapper;

    /**
     * 查询鲜花订单地址管理
     * 
     * @param huowuId 鲜花订单地址管理主键
     * @return 鲜花订单地址管理
     */
    @Override
    public KuowuID selectKuowuIDByHuowuId(Long huowuId)
    {
        return kuowuIDMapper.selectKuowuIDByHuowuId(huowuId);
    }

    /**
     * 查询鲜花订单地址管理列表
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 鲜花订单地址管理
     */
    @Override
    public List<KuowuID> selectKuowuIDList(KuowuID kuowuID)
    {
        return kuowuIDMapper.selectKuowuIDList(kuowuID);
    }

    /**
     * 新增鲜花订单地址管理
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 结果
     */
    @Override
    public int insertKuowuID(KuowuID kuowuID)
    {
        kuowuID.setCreateTime(DateUtils.getNowDate());
        return kuowuIDMapper.insertKuowuID(kuowuID);
    }

    /**
     * 修改鲜花订单地址管理
     * 
     * @param kuowuID 鲜花订单地址管理
     * @return 结果
     */
    @Override
    public int updateKuowuID(KuowuID kuowuID)
    {
        return kuowuIDMapper.updateKuowuID(kuowuID);
    }

    /**
     * 批量删除鲜花订单地址管理
     * 
     * @param huowuIds 需要删除的鲜花订单地址管理主键
     * @return 结果
     */
    @Override
    public int deleteKuowuIDByHuowuIds(Long[] huowuIds)
    {
        return kuowuIDMapper.deleteKuowuIDByHuowuIds(huowuIds);
    }

    /**
     * 删除鲜花订单地址管理信息
     * 
     * @param huowuId 鲜花订单地址管理主键
     * @return 结果
     */
    @Override
    public int deleteKuowuIDByHuowuId(Long huowuId)
    {
        return kuowuIDMapper.deleteKuowuIDByHuowuId(huowuId);
    }
}
