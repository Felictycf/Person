package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HbkjStudentMapper;
import com.ruoyi.system.domain.HbkjStudent;
import com.ruoyi.system.service.IHbkjStudentService;

/**
 * 学生情绪信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class HbkjStudentServiceImpl implements IHbkjStudentService 
{
    @Autowired
    private HbkjStudentMapper hbkjStudentMapper;

    /**
     * 查询学生情绪信息
     * 
     * @param id 学生情绪信息主键
     * @return 学生情绪信息
     */
    @Override
    public HbkjStudent selectHbkjStudentById(Long id)
    {
        return hbkjStudentMapper.selectHbkjStudentById(id);
    }

    /**
     * 查询学生情绪信息列表
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 学生情绪信息
     */
    @Override
    public List<HbkjStudent> selectHbkjStudentList(HbkjStudent hbkjStudent)
    {
        return hbkjStudentMapper.selectHbkjStudentList(hbkjStudent);
    }

    /**
     * 新增学生情绪信息
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 结果
     */
    @Override
    public int insertHbkjStudent(HbkjStudent hbkjStudent)
    {
        return hbkjStudentMapper.insertHbkjStudent(hbkjStudent);
    }

    /**
     * 修改学生情绪信息
     * 
     * @param hbkjStudent 学生情绪信息
     * @return 结果
     */
    @Override
    public int updateHbkjStudent(HbkjStudent hbkjStudent)
    {
        return hbkjStudentMapper.updateHbkjStudent(hbkjStudent);
    }

    /**
     * 批量删除学生情绪信息
     * 
     * @param ids 需要删除的学生情绪信息主键
     * @return 结果
     */
    @Override
    public int deleteHbkjStudentByIds(Long[] ids)
    {
        return hbkjStudentMapper.deleteHbkjStudentByIds(ids);
    }

    /**
     * 删除学生情绪信息信息
     * 
     * @param id 学生情绪信息主键
     * @return 结果
     */
    @Override
    public int deleteHbkjStudentById(Long id)
    {
        return hbkjStudentMapper.deleteHbkjStudentById(id);
    }
}
