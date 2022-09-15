package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Flowerorderform;

/**
 * 鲜花订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
public interface FlowerorderformMapper 
{
    /**
     * 查询鲜花订单信息
     * 
     * @param onum 鲜花订单信息主键
     * @return 鲜花订单信息
     */
    public Flowerorderform selectFlowerorderformByOnum(String onum);

    /**
     * 查询鲜花订单信息列表
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 鲜花订单信息集合
     */
    public List<Flowerorderform> selectFlowerorderformList(Flowerorderform flowerorderform);

    /**
     * 新增鲜花订单信息
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 结果
     */
    public int insertFlowerorderform(Flowerorderform flowerorderform);

    /**
     * 修改鲜花订单信息
     * 
     * @param flowerorderform 鲜花订单信息
     * @return 结果
     */
    public int updateFlowerorderform(Flowerorderform flowerorderform);

    /**
     * 删除鲜花订单信息
     * 
     * @param onum 鲜花订单信息主键
     * @return 结果
     */
    public int deleteFlowerorderformByOnum(String onum);

    /**
     * 批量删除鲜花订单信息
     * 
     * @param onums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlowerorderformByOnums(String[] onums);
}
