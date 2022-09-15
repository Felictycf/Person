package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RenshiINFOMapper;
import com.ruoyi.system.domain.RenshiINFO;
import com.ruoyi.system.service.IRenshiINFOService;

/**
 * 人事信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class RenshiINFOServiceImpl implements IRenshiINFOService 
{
    @Autowired
    private RenshiINFOMapper renshiINFOMapper;

    /**
     * 查询人事信息
     * 
     * @param staffid 人事信息主键
     * @return 人事信息
     */
    @Override
    public RenshiINFO selectRenshiINFOByStaffid(Long staffid)
    {
        return renshiINFOMapper.selectRenshiINFOByStaffid(staffid);
    }

    /**
     * 查询人事信息列表
     * 
     * @param renshiINFO 人事信息
     * @return 人事信息
     */
    @Override
    public List<RenshiINFO> selectRenshiINFOList(RenshiINFO renshiINFO)
    {
        return renshiINFOMapper.selectRenshiINFOList(renshiINFO);
    }

    /**
     * 新增人事信息
     * 
     * @param renshiINFO 人事信息
     * @return 结果
     */
    @Override
    public int insertRenshiINFO(RenshiINFO renshiINFO)
    {
        return renshiINFOMapper.insertRenshiINFO(renshiINFO);
    }

    /**
     * 修改人事信息
     * 
     * @param renshiINFO 人事信息
     * @return 结果
     */
    @Override
    public int updateRenshiINFO(RenshiINFO renshiINFO)
    {
        return renshiINFOMapper.updateRenshiINFO(renshiINFO);
    }

    /**
     * 批量删除人事信息
     * 
     * @param staffids 需要删除的人事信息主键
     * @return 结果
     */
    @Override
    public int deleteRenshiINFOByStaffids(Long[] staffids)
    {
        return renshiINFOMapper.deleteRenshiINFOByStaffids(staffids);
    }

    /**
     * 删除人事信息信息
     * 
     * @param staffid 人事信息主键
     * @return 结果
     */
    @Override
    public int deleteRenshiINFOByStaffid(Long staffid)
    {
        return renshiINFOMapper.deleteRenshiINFOByStaffid(staffid);
    }
}
