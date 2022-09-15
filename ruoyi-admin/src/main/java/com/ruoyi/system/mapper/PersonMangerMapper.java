package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PersonManger;

/**
 * 职工薪酬信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface PersonMangerMapper 
{
    /**
     * 查询职工薪酬信息
     * 
     * @param staffid 职工薪酬信息主键
     * @return 职工薪酬信息
     */
    public PersonManger selectPersonMangerByStaffid(String staffid);

    /**
     * 查询职工薪酬信息列表
     * 
     * @param personManger 职工薪酬信息
     * @return 职工薪酬信息集合
     */
    public List<PersonManger> selectPersonMangerList(PersonManger personManger);

    /**
     * 新增职工薪酬信息
     * 
     * @param personManger 职工薪酬信息
     * @return 结果
     */
    public int insertPersonManger(PersonManger personManger);

    /**
     * 修改职工薪酬信息
     * 
     * @param personManger 职工薪酬信息
     * @return 结果
     */
    public int updatePersonManger(PersonManger personManger);

    /**
     * 删除职工薪酬信息
     * 
     * @param staffid 职工薪酬信息主键
     * @return 结果
     */
    public int deletePersonMangerByStaffid(String staffid);

    /**
     * 批量删除职工薪酬信息
     * 
     * @param staffids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonMangerByStaffids(String[] staffids);
}
