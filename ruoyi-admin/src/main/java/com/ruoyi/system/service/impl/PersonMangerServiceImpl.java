package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PersonMangerMapper;
import com.ruoyi.system.domain.PersonManger;
import com.ruoyi.system.service.IPersonMangerService;

/**
 * 职工薪酬信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class PersonMangerServiceImpl implements IPersonMangerService 
{
    @Autowired
    private PersonMangerMapper personMangerMapper;

    /**
     * 查询职工薪酬信息
     * 
     * @param staffid 职工薪酬信息主键
     * @return 职工薪酬信息
     */
    @Override
    public PersonManger selectPersonMangerByStaffid(String staffid)
    {
        return personMangerMapper.selectPersonMangerByStaffid(staffid);
    }

    /**
     * 查询职工薪酬信息列表
     * 
     * @param personManger 职工薪酬信息
     * @return 职工薪酬信息
     */
    @Override
    public List<PersonManger> selectPersonMangerList(PersonManger personManger)
    {
        return personMangerMapper.selectPersonMangerList(personManger);
    }

    /**
     * 新增职工薪酬信息
     * 
     * @param personManger 职工薪酬信息
     * @return 结果
     */
    @Override
    public int insertPersonManger(PersonManger personManger)
    {
        return personMangerMapper.insertPersonManger(personManger);
    }

    /**
     * 修改职工薪酬信息
     * 
     * @param personManger 职工薪酬信息
     * @return 结果
     */
    @Override
    public int updatePersonManger(PersonManger personManger)
    {
        return personMangerMapper.updatePersonManger(personManger);
    }

    /**
     * 批量删除职工薪酬信息
     * 
     * @param staffids 需要删除的职工薪酬信息主键
     * @return 结果
     */
    @Override
    public int deletePersonMangerByStaffids(String[] staffids)
    {
        return personMangerMapper.deletePersonMangerByStaffids(staffids);
    }

    /**
     * 删除职工薪酬信息信息
     * 
     * @param staffid 职工薪酬信息主键
     * @return 结果
     */
    @Override
    public int deletePersonMangerByStaffid(String staffid)
    {
        return personMangerMapper.deletePersonMangerByStaffid(staffid);
    }
}
