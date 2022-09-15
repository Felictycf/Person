package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人事信息对象 renshiINFO
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class RenshiINFO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职工号 */
    private Long staffid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birth;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String birthplace;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 地址 */
    @Excel(name = "地址")
    private String homeAddr;

    /** 电话 */
    @Excel(name = "电话")
    private Long telehone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 学历 */
    @Excel(name = "学历")
    private String schoolrecord;

    /** 所在部门 */
    @Excel(name = "所在部门")
    private String departmentname;

    /** 参加工作 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "参加工作", width = 30, dateFormat = "yyyy-MM-dd")
    private Date worktime;

    /** 进本单位时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进本单位时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enterdptdate;

    /** 现任岗位 */
    @Excel(name = "现任岗位")
    private String post;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String political;

    public void setStaffid(Long staffid) 
    {
        this.staffid = staffid;
    }

    public Long getStaffid() 
    {
        return staffid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirth(Date birth) 
    {
        this.birth = birth;
    }

    public Date getBirth() 
    {
        return birth;
    }
    public void setBirthplace(String birthplace) 
    {
        this.birthplace = birthplace;
    }

    public String getBirthplace() 
    {
        return birthplace;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setHomeAddr(String homeAddr) 
    {
        this.homeAddr = homeAddr;
    }

    public String getHomeAddr() 
    {
        return homeAddr;
    }
    public void setTelehone(Long telehone) 
    {
        this.telehone = telehone;
    }

    public Long getTelehone() 
    {
        return telehone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setSchoolrecord(String schoolrecord) 
    {
        this.schoolrecord = schoolrecord;
    }

    public String getSchoolrecord() 
    {
        return schoolrecord;
    }
    public void setDepartmentname(String departmentname) 
    {
        this.departmentname = departmentname;
    }

    public String getDepartmentname() 
    {
        return departmentname;
    }
    public void setWorktime(Date worktime) 
    {
        this.worktime = worktime;
    }

    public Date getWorktime() 
    {
        return worktime;
    }
    public void setEnterdptdate(Date enterdptdate) 
    {
        this.enterdptdate = enterdptdate;
    }

    public Date getEnterdptdate() 
    {
        return enterdptdate;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setPolitical(String political) 
    {
        this.political = political;
    }

    public String getPolitical() 
    {
        return political;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("staffid", getStaffid())
            .append("name", getName())
            .append("sex", getSex())
            .append("birth", getBirth())
            .append("birthplace", getBirthplace())
            .append("nation", getNation())
            .append("homeAddr", getHomeAddr())
            .append("telehone", getTelehone())
            .append("email", getEmail())
            .append("schoolrecord", getSchoolrecord())
            .append("departmentname", getDepartmentname())
            .append("worktime", getWorktime())
            .append("enterdptdate", getEnterdptdate())
            .append("post", getPost())
            .append("political", getPolitical())
            .toString();
    }
}
