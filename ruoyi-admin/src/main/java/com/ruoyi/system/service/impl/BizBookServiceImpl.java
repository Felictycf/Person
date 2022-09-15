package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizBookMapper;
import com.ruoyi.system.domain.BizBook;
import com.ruoyi.system.service.IBizBookService;

/**
 * 电话本Service业务层处理
 * 
 * @author itkey
 * @date 2022-05-20
 */
@Service
public class BizBookServiceImpl implements IBizBookService 
{
    @Autowired
    private BizBookMapper bizBookMapper;

    /**
     * 查询电话本
     * 
     * @param bookId 电话本主键
     * @return 电话本
     */
    @Override
    public BizBook selectBizBookByBookId(Long bookId)
    {
        return bizBookMapper.selectBizBookByBookId(bookId);
    }

    /**
     * 查询电话本列表
     * 
     * @param bizBook 电话本
     * @return 电话本
     */
    @Override
    public List<BizBook> selectBizBookList(BizBook bizBook)
    {
        return bizBookMapper.selectBizBookList(bizBook);
    }

    /**
     * 新增电话本
     * 
     * @param bizBook 电话本
     * @return 结果
     */
    @Override
    public int insertBizBook(BizBook bizBook)
    {
        bizBook.setCreateTime(DateUtils.getNowDate());
        return bizBookMapper.insertBizBook(bizBook);
    }

    /**
     * 修改电话本
     * 
     * @param bizBook 电话本
     * @return 结果
     */
    @Override
    public int updateBizBook(BizBook bizBook)
    {
        return bizBookMapper.updateBizBook(bizBook);
    }

    /**
     * 批量删除电话本
     * 
     * @param bookIds 需要删除的电话本主键
     * @return 结果
     */
    @Override
    public int deleteBizBookByBookIds(Long[] bookIds)
    {
        return bizBookMapper.deleteBizBookByBookIds(bookIds);
    }

    /**
     * 删除电话本信息
     * 
     * @param bookId 电话本主键
     * @return 结果
     */
    @Override
    public int deleteBizBookByBookId(Long bookId)
    {
        return bizBookMapper.deleteBizBookByBookId(bookId);
    }
}
