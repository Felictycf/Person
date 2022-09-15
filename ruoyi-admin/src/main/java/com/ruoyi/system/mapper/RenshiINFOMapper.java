package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RenshiINFO;

/**
 * 人事信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface RenshiINFOMapper 
{
    /**
     * 查询人事信息
     * 
     * @param staffid 人事信息主键
     * @return 人事信息
     */
    public RenshiINFO selectRenshiINFOByStaffid(Long staffid);

    /**
     * 查询人事信息列表
     * 
     * @param renshiINFO 人事信息
     * @return 人事信息集合
     */
    public List<RenshiINFO> selectRenshiINFOList(RenshiINFO renshiINFO);

    /**
     * 新增人事信息
     * 
     * @param renshiINFO 人事信息
     * @return 结果
     */
    public int insertRenshiINFO(RenshiINFO renshiINFO);

    /**
     * 修改人事信息
     * 
     * @param renshiINFO 人事信息
     * @return 结果
     */
    public int updateRenshiINFO(RenshiINFO renshiINFO);

    /**
     * 删除人事信息
     * 
     * @param staffid 人事信息主键
     * @return 结果
     */
    public int deleteRenshiINFOByStaffid(Long staffid);

    /**
     * 批量删除人事信息
     * 
     * @param staffids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRenshiINFOByStaffids(Long[] staffids);
}
