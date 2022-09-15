package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Orderform;
import com.ruoyi.system.service.IOrderformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/system/orderform")
public class OrderformController extends BaseController
{
    @Autowired
    private IOrderformService orderformService;

    /**
     * 查询订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:list')")
    @GetMapping("/list")
    public TableDataInfo list(Orderform orderform)
    {
        startPage();
        List<Orderform> list = orderformService.selectOrderformList(orderform);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:export')")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Orderform orderform)
    {
        List<Orderform> list = orderformService.selectOrderformList(orderform);
        ExcelUtil<Orderform> util = new ExcelUtil<Orderform>(Orderform.class);
        util.exportExcel(response, list, "订单信息数据");
    }

    /**
     * 获取订单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:query')")
    @GetMapping(value = "/{onum}")
    public AjaxResult getInfo(@PathVariable("onum") String onum)
    {
        return AjaxResult.success(orderformService.selectOrderformByOnum(onum));
    }

    /**
     * 新增订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:add')")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Orderform orderform)
    {
        return toAjax(orderformService.insertOrderform(orderform));
    }

    /**
     * 修改订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:edit')")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Orderform orderform)
    {
        return toAjax(orderformService.updateOrderform(orderform));
    }

    /**
     * 删除订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderform:remove')")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{onums}")
    public AjaxResult remove(@PathVariable String[] onums)
    {
        return toAjax(orderformService.deleteOrderformByOnums(onums));
    }
}
