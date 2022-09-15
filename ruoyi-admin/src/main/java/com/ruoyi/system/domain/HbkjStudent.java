package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生情绪信息对象 hbkj_student
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public class HbkjStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生id */
    private Long id;

    /** 学生学号 */
    @Excel(name = "学生学号")
    private Long studentId;

    /** 情绪值 */
    @Excel(name = "情绪值")
    private Double emoId;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private String name;

    /** 学生说的话 */
    @Excel(name = "学生说的话")
    private String studentSay;

    /** 学生情绪状态 */
    @Excel(name = "学生情绪状态")
    private String studentStatus;

    /** 学生生活状态 */
    @Excel(name = "学生生活状态")
    private String studentLife;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setEmoId(Double emoId)
    {
        this.emoId = emoId;
    }

    public Double    getEmoId()
    {
        return emoId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStudentSay(String studentSay) 
    {
        this.studentSay = studentSay;
    }

    public String getStudentSay() 
    {
        return studentSay;
    }
    public void setStudentStatus(String studentStatus) 
    {
        this.studentStatus = studentStatus;
    }

    public String getStudentStatus() 
    {
        return studentStatus;
    }
    public void setStudentLife(String studentLife) 
    {
        this.studentLife = studentLife;
    }

    public String getStudentLife() 
    {
        return studentLife;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("emoId", getEmoId())
            .append("name", getName())
            .append("studentSay", getStudentSay())
            .append("studentStatus", getStudentStatus())
            .append("studentLife", getStudentLife())
            .toString();
    }
}
