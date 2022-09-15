package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FlowerorderformMapper;
import com.ruoyi.system.domain.Flowerorderform;
import com.ruoyi.system.service.IFlowerorderformService;

/**
 * 鲜花订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@Service
public class FlowerorderformServiceImpl implements IFlowerorderformService 
{
    @Autowired
    private FlowerorderformMapper flowerorderformMapper;

    /**
     * 查询鲜花订单信息
     * 
     * @param onum 鲜花订单信息主键
     * @return 鲜花订单信息
     */
    @Override
    public Flowerorderform selectFlowerorderformByOnum(String onum)
    {
        return flowerorderformMapper.selectFlowerorderformByOnum(onum);
    }

    /**
     * 查询鲜花订单信息列表
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 鲜花订单信息
     */
    @Override
    public List<Flowerorderform> selectFlowerorderformList(Flowerorderform flowerorderform)
    {
        return flowerorderformMapper.selectFlowerorderformList(flowerorderform);
    }

    /**
     * 新增鲜花订单信息
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 结果
     */
    @Override
    public int insertFlowerorderform(Flowerorderform flowerorderform)
    {
        return flowerorderformMapper.insertFlowerorderform(flowerorderform);
    }

    /**
     * 修改鲜花订单信息
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 结果
     */
    @Override
    public int updateFlowerorderform(Flowerorderform flowerorderform)
    {
        return flowerorderformMapper.updateFlowerorderform(flowerorderform);
    }

    /**
     * 批量删除鲜花订单信息
     * 
     * @param onums 需要删除的鲜花订单信息主键
     * @return 结果
     */
    @Override
    public int deleteFlowerorderformByOnums(String[] onums)
    {
        return flowerorderformMapper.deleteFlowerorderformByOnums(onums);
    }

    /**
     * 删除鲜花订单信息信息
     * 
     * @param onum 鲜花订单信息主键
     * @return 结果
     */
    @Override
    public int deleteFlowerorderformByOnum(String onum)
    {
        return flowerorderformMapper.deleteFlowerorderformByOnum(onum);
    }
}
