package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职工薪酬信息对象 personManger
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class PersonManger extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职工号 */
    @Excel(name = "职工号")
    private String staffid;

    /** 基础公司 */
    @Excel(name = "基础公司")
    private Long basepay;

    /** 岗位薪资 */
    @Excel(name = "岗位薪资")
    private Long postsalary;

    /** 奖金 */
    @Excel(name = "奖金")
    private Long bonus;

    public void setStaffid(String staffid) 
    {
        this.staffid = staffid;
    }

    public String getStaffid() 
    {
        return staffid;
    }
    public void setBasepay(Long basepay) 
    {
        this.basepay = basepay;
    }

    public Long getBasepay() 
    {
        return basepay;
    }
    public void setPostsalary(Long postsalary) 
    {
        this.postsalary = postsalary;
    }

    public Long getPostsalary() 
    {
        return postsalary;
    }
    public void setBonus(Long bonus) 
    {
        this.bonus = bonus;
    }

    public Long getBonus() 
    {
        return bonus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("staffid", getStaffid())
            .append("basepay", getBasepay())
            .append("postsalary", getPostsalary())
            .append("bonus", getBonus())
            .toString();
    }
}
