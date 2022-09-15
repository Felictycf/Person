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
import com.ruoyi.system.domain.Tongji;
import com.ruoyi.system.service.ITongjiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 统计信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/tongji")
public class TongjiController extends BaseController
{
    @Autowired
    private ITongjiService tongjiService;

    /**
     * 查询统计信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tongji tongji)
    {
        startPage();
        List<Tongji> list = tongjiService.selectTongjiList(tongji);
        return getDataTable(list);
    }

    /**
     * 导出统计信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:export')")
    @Log(title = "统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tongji tongji)
    {
        List<Tongji> list = tongjiService.selectTongjiList(tongji);
        ExcelUtil<Tongji> util = new ExcelUtil<Tongji>(Tongji.class);
        util.exportExcel(response, list, "统计信息数据");
    }

    /**
     * 获取统计信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tongjiService.selectTongjiById(id));
    }

    /**
     * 新增统计信息
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:add')")
    @Log(title = "统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tongji tongji)
    {
        return toAjax(tongjiService.insertTongji(tongji));
    }

    /**
     * 修改统计信息
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:edit')")
    @Log(title = "统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tongji tongji)
    {
        return toAjax(tongjiService.updateTongji(tongji));
    }

    /**
     * 删除统计信息
     */
    @PreAuthorize("@ss.hasPermi('system:tongji:remove')")
    @Log(title = "统计信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tongjiService.deleteTongjiByIds(ids));
    }
}
