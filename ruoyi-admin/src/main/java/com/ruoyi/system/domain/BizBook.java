package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电话本对象 biz_book
 * 
 * @author itkey
 * @date 2022-05-20
 */
public class BizBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 电话本ID */
    private Long bookId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String bookName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String bookPhone;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookBirthday;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setBookPhone(String bookPhone) 
    {
        this.bookPhone = bookPhone;
    }

    public String getBookPhone() 
    {
        return bookPhone;
    }
    public void setBookBirthday(Date bookBirthday) 
    {
        this.bookBirthday = bookBirthday;
    }

    public Date getBookBirthday() 
    {
        return bookBirthday;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("bookPhone", getBookPhone())
            .append("bookBirthday", getBookBirthday())
            .append("createTime", getCreateTime())
            .toString();
    }
}
