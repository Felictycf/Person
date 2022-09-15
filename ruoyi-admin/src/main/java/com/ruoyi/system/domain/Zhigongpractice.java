package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职工培训对象 zhigongpractice
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class Zhigongpractice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职工号 */
    private String staffid;

    /** 培训开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "培训开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainingstart;

    /** 培训结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "培训结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainingend;

    /** 培训内容 */
    @Excel(name = "培训内容")
    private String trainingcontent;

    /** 考核官 */
    @Excel(name = "考核官")
    private String trainer;

    public void setStaffid(String staffid) 
    {
        this.staffid = staffid;
    }

    public String getStaffid() 
    {
        return staffid;
    }
    public void setTrainingstart(Date trainingstart) 
    {
        this.trainingstart = trainingstart;
    }

    public Date getTrainingstart() 
    {
        return trainingstart;
    }
    public void setTrainingend(Date trainingend) 
    {
        this.trainingend = trainingend;
    }

    public Date getTrainingend() 
    {
        return trainingend;
    }
    public void setTrainingcontent(String trainingcontent) 
    {
        this.trainingcontent = trainingcontent;
    }

    public String getTrainingcontent() 
    {
        return trainingcontent;
    }
    public void setTrainer(String trainer) 
    {
        this.trainer = trainer;
    }

    public String getTrainer() 
    {
        return trainer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("staffid", getStaffid())
            .append("trainingstart", getTrainingstart())
            .append("trainingend", getTrainingend())
            .append("trainingcontent", getTrainingcontent())
            .append("trainer", getTrainer())
            .toString();
    }
}
