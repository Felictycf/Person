package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Zhigongpractice;

/**
 * 职工培训Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface IZhigongpracticeService 
{
    /**
     * 查询职工培训
     * 
     * @param staffid 职工培训主键
     * @return 职工培训
     */
    public Zhigongpractice selectZhigongpracticeByStaffid(String staffid);

    /**
     * 查询职工培训列表
     * 
     * @param zhigongpractice 职工培训
     * @return 职工培训集合
     */
    public List<Zhigongpractice> selectZhigongpracticeList(Zhigongpractice zhigongpractice);

    /**
     * 新增职工培训
     * 
     * @param zhigongpractice 职工培训
     * @return 结果
     */
    public int insertZhigongpractice(Zhigongpractice zhigongpractice);

    /**
     * 修改职工培训
     * 
     * @param zhigongpractice 职工培训
     * @return 结果
     */
    public int updateZhigongpractice(Zhigongpractice zhigongpractice);

    /**
     * 批量删除职工培训
     * 
     * @param staffids 需要删除的职工培训主键集合
     * @return 结果
     */
    public int deleteZhigongpracticeByStaffids(String[] staffids);

    /**
     * 删除职工培训信息
     * 
     * @param staffid 职工培训主键
     * @return 结果
     */
    public int deleteZhigongpracticeByStaffid(String staffid);
}
