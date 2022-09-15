package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HbkjStudent;

/**
 * 学生情绪信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public interface IHbkjStudentService 
{
    /**
     * 查询学生情绪信息
     * 
     * @param id 学生情绪信息主键
     * @return 学生情绪信息
     */
    public HbkjStudent selectHbkjStudentById(Long id);

    /**
     * 查询学生情绪信息列表
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 学生情绪信息集合
     */
    public List<HbkjStudent> selectHbkjStudentList(HbkjStudent hbkjStudent);

    /**
     * 新增学生情绪信息
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 结果
     */
    public int insertHbkjStudent(HbkjStudent hbkjStudent);

    /**
     * 修改学生情绪信息
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 结果
     */
    public int updateHbkjStudent(HbkjStudent hbkjStudent);

    /**
     * 批量删除学生情绪信息
     * 
     * @param ids 需要删除的学生情绪信息主键集合
     * @return 结果
     */
    public int deleteHbkjStudentByIds(Long[] ids);

    /**
     * 删除学生情绪信息信息
     * 
     * @param id 学生情绪信息主键
     * @return 结果
     */
    public int deleteHbkjStudentById(Long id);
}
