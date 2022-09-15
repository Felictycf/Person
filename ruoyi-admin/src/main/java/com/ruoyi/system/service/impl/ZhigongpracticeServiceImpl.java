package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ZhigongpracticeMapper;
import com.ruoyi.system.domain.Zhigongpractice;
import com.ruoyi.system.service.IZhigongpracticeService;

/**
 * 职工培训Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class ZhigongpracticeServiceImpl implements IZhigongpracticeService 
{
    @Autowired
    private ZhigongpracticeMapper zhigongpracticeMapper;

    /**
     * 查询职工培训
     * 
     * @param staffid 职工培训主键
     * @return 职工培训
     */
    @Override
    public Zhigongpractice selectZhigongpracticeByStaffid(String staffid)
    {
        return zhigongpracticeMapper.selectZhigongpracticeByStaffid(staffid);
    }

    /**
     * 查询职工培训列表
     * 
     * @param zhigongpractice 职工培训
     * @return 职工培训
     */
    @Override
    public List<Zhigongpractice> selectZhigongpracticeList(Zhigongpractice zhigongpractice)
    {
        return zhigongpracticeMapper.selectZhigongpracticeList(zhigongpractice);
    }

    /**
     * 新增职工培训
     * 
     * @param zhigongpractice 职工培训
     * @return 结果
     */
    @Override
    public int insertZhigongpractice(Zhigongpractice zhigongpractice)
    {
        return zhigongpracticeMapper.insertZhigongpractice(zhigongpractice);
    }

    /**
     * 修改职工培训
     * 
     * @param zhigongpractice 职工培训
     * @return 结果
     */
    @Override
    public int updateZhigongpractice(Zhigongpractice zhigongpractice)
    {
        return zhigongpracticeMapper.updateZhigongpractice(zhigongpractice);
    }

    /**
     * 批量删除职工培训
     * 
     * @param staffids 需要删除的职工培训主键
     * @return 结果
     */
    @Override
    public int deleteZhigongpracticeByStaffids(String[] staffids)
    {
        return zhigongpracticeMapper.deleteZhigongpracticeByStaffids(staffids);
    }

    /**
     * 删除职工培训信息
     * 
     * @param staffid 职工培训主键
     * @return 结果
     */
    @Override
    public int deleteZhigongpracticeByStaffid(String staffid)
    {
        return zhigongpracticeMapper.deleteZhigongpracticeByStaffid(staffid);
    }
}
