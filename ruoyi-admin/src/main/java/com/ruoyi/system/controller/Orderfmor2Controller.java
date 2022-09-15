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
import com.ruoyi.system.domain.Orderfmor2;
import com.ruoyi.system.service.IOrderfmor2Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/system/orderfmor2")
public class Orderfmor2Controller extends BaseController
{
    @Autowired
    private IOrderfmor2Service orderfmor2Service;

    /**
     * 查询订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:list')")
    @GetMapping("/list")
    public TableDataInfo list(Orderfmor2 orderfmor2)
    {
        startPage();
        List<Orderfmor2> list = orderfmor2Service.selectOrderfmor2List(orderfmor2);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:export')")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Orderfmor2 orderfmor2)
    {
        List<Orderfmor2> list = orderfmor2Service.selectOrderfmor2List(orderfmor2);
        ExcelUtil<Orderfmor2> util = new ExcelUtil<Orderfmor2>(Orderfmor2.class);
        util.exportExcel(response, list, "订单信息数据");
    }

    /**
     * 获取订单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:query')")
    @GetMapping(value = "/{onum}")
    public AjaxResult getInfo(@PathVariable("onum") Long onum)
    {
        return AjaxResult.success(orderfmor2Service.selectOrderfmor2ByOnum(onum));
    }

    /**
     * 新增订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:add')")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Orderfmor2 orderfmor2)
    {
        return toAjax(orderfmor2Service.insertOrderfmor2(orderfmor2));
    }

    /**
     * 修改订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:edit')")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Orderfmor2 orderfmor2)
    {
        return toAjax(orderfmor2Service.updateOrderfmor2(orderfmor2));
    }

    /**
     * 删除订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:orderfmor2:remove')")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{onums}")
    public AjaxResult remove(@PathVariable Long[] onums)
    {
        return toAjax(orderfmor2Service.deleteOrderfmor2ByOnums(onums));
    }
}
