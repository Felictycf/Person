package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单信息对象 orderform
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Orderform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    private String onum;

    /** 人数 */
    @Excel(name = "人数")
    private Long opeople;

    /** 餐桌号 */
    @Excel(name = "餐桌号")
    private String canzuohao;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String cotel;

    /** 总金额 */
    @Excel(name = "总金额")
    private Long total;

    /** 付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payment;

    /** 入账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entry;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String dingdanstate;

    /** 订单内容 */
    @Excel(name = "订单内容")
    private String tablecontext;

    public void setOnum(String onum) 
    {
        this.onum = onum;
    }

    public String getOnum() 
    {
        return onum;
    }
    public void setOpeople(Long opeople) 
    {
        this.opeople = opeople;
    }

    public Long getOpeople() 
    {
        return opeople;
    }

    public void setCanzuohao(String canzuohao) 
    {
        this.canzuohao = canzuohao;
    }

    public String getCanzuohao()
    {
        return canzuohao;
    }

    public void setCotel(String cotel) 
    {
        this.cotel = cotel;
    }

    public String getCotel() 
    {
        return cotel;
    }
    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setPayment(Date payment) 
    {
        this.payment = payment;
    }

    public Date getPayment() 
    {
        return payment;
    }
    public void setEntry(Date entry) 
    {
        this.entry = entry;
    }

    public Date getEntry() 
    {
        return entry;
    }
    public void setDingdanstate(String dingdanstate) 
    {
        this.dingdanstate = dingdanstate;
    }

    public String getDingdanstate() 
    {
        return dingdanstate;
    }
    public void setTablecontext(String tablecontext) 
    {
        this.tablecontext = tablecontext;
    }

    public String getTablecontext() 
    {
        return tablecontext;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("onum", getOnum())
            .append("opeople", getOpeople())
            .append("canzuohao", getCanzuohao())
            .append("cotel", getCotel())
            .append("total", getTotal())
            .append("payment", getPayment())
            .append("entry", getEntry())
            .append("dingdanstate", getDingdanstate())
            .append("tablecontext", getTablecontext())
            .toString();
    }
}
