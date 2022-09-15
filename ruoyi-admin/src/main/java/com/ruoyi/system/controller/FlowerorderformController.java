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
import com.ruoyi.system.domain.Flowerorderform;
import com.ruoyi.system.service.IFlowerorderformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 鲜花订单信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@RestController
@RequestMapping("/system/flowerorderform")
public class FlowerorderformController extends BaseController
{
    @Autowired
    private IFlowerorderformService flowerorderformService;

    /**
     * 查询鲜花订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:list')")
    @GetMapping("/list")
    public TableDataInfo list(Flowerorderform flowerorderform)
    {
        startPage();
        List<Flowerorderform> list = flowerorderformService.selectFlowerorderformList(flowerorderform);
        return getDataTable(list);
    }

    /**
     * 导出鲜花订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:export')")
    @Log(title = "鲜花订单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Flowerorderform flowerorderform)
    {
        List<Flowerorderform> list = flowerorderformService.selectFlowerorderformList(flowerorderform);
        ExcelUtil<Flowerorderform> util = new ExcelUtil<Flowerorderform>(Flowerorderform.class);
        util.exportExcel(response, list, "鲜花订单信息数据");
    }

    /**
     * 获取鲜花订单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:query')")
    @GetMapping(value = "/{onum}")
    public AjaxResult getInfo(@PathVariable("onum") String onum)
    {
        return AjaxResult.success(flowerorderformService.selectFlowerorderformByOnum(onum));
    }

    /**
     * 新增鲜花订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:add')")
    @Log(title = "鲜花订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Flowerorderform flowerorderform)
    {
        return toAjax(flowerorderformService.insertFlowerorderform(flowerorderform));
    }

    /**
     * 修改鲜花订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:edit')")
    @Log(title = "鲜花订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Flowerorderform flowerorderform)
    {
        return toAjax(flowerorderformService.updateFlowerorderform(flowerorderform));
    }

    /**
     * 删除鲜花订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:flowerorderform:remove')")
    @Log(title = "鲜花订单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{onums}")
    public AjaxResult remove(@PathVariable String[] onums)
    {
        return toAjax(flowerorderformService.deleteFlowerorderformByOnums(onums));
    }
}
