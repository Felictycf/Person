package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 鲜花订单地址管理对象 kuowuID
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
public class KuowuID extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 鲜花商品ID */
    @Excel(name = "鲜花商品ID")
    private Long huowuId;

    /** 购买者姓名 */
    @Excel(name = "购买者姓名")
    private String huowuName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String huowuPhone;

    /** 购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date huowuBirthday;

    /** 货物到账状态 */
    @Excel(name = "货物到账状态")
    private String status;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String adress;

    public void setHuowuId(Long huowuId) 
    {
        this.huowuId = huowuId;
    }

    public Long getHuowuId() 
    {
        return huowuId;
    }
    public void setHuowuName(String huowuName) 
    {
        this.huowuName = huowuName;
    }

    public String getHuowuName() 
    {
        return huowuName;
    }
    public void setHuowuPhone(String huowuPhone) 
    {
        this.huowuPhone = huowuPhone;
    }

    public String getHuowuPhone() 
    {
        return huowuPhone;
    }
    public void setHuowuBirthday(Date huowuBirthday) 
    {
        this.huowuBirthday = huowuBirthday;
    }

    public Date getHuowuBirthday() 
    {
        return huowuBirthday;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public String getAdress() 
    {
        return adress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("huowuId", getHuowuId())
            .append("huowuName", getHuowuName())
            .append("huowuPhone", getHuowuPhone())
            .append("huowuBirthday", getHuowuBirthday())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("adress", getAdress())
            .toString();
    }
}
