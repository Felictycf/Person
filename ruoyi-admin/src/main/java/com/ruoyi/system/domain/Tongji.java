package com.ruoyi.system.domain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
/**
 * 统计信息对象 tongji
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class Tongji extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 职位数量 */
    @Excel(name = "职位数量")
    private String sum;

    /** 总人数 */
    @Excel(name = "总人数")
    private String tongji;

    /** 空缺职位人数 */
    @Excel(name = "空缺职位人数")
    private String kongque;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSum(String sum) 
    {
        this.sum = sum;
    }

    public String getSum() 
    {
        return sum;
    }
    public void setTongji(String tongji) 
    {
        this.tongji = tongji;
    }

    public String getTongji() 
    {
        return tongji;
    }
    public void setKongque(String kongque) 
    {
        this.kongque = kongque;
    }

    public String getKongque() 
    {
        return kongque;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sum", getSum())
            .append("tongji", getTongji())
            .append("kongque", getKongque())
            .toString();
    }
}
