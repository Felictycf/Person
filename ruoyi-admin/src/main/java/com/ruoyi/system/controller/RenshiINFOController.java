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
import com.ruoyi.system.domain.RenshiINFO;
import com.ruoyi.system.service.IRenshiINFOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人事信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/renshiINFO")
public class RenshiINFOController extends BaseController
{
    @Autowired
    private IRenshiINFOService renshiINFOService;

    /**
     * 查询人事信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:list')")
    @GetMapping("/list")
    public TableDataInfo list(RenshiINFO renshiINFO)
    {
        startPage();
        List<RenshiINFO> list = renshiINFOService.selectRenshiINFOList(renshiINFO);
        return getDataTable(list);
    }

    /**
     * 导出人事信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:export')")
    @Log(title = "人事信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RenshiINFO renshiINFO)
    {
        List<RenshiINFO> list = renshiINFOService.selectRenshiINFOList(renshiINFO);
        ExcelUtil<RenshiINFO> util = new ExcelUtil<RenshiINFO>(RenshiINFO.class);
        util.exportExcel(response, list, "人事信息数据");
    }

    /**
     * 获取人事信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:query')")
    @GetMapping(value = "/{staffid}")
    public AjaxResult getInfo(@PathVariable("staffid") Long staffid)
    {
        return AjaxResult.success(renshiINFOService.selectRenshiINFOByStaffid(staffid));
    }

    /**
     * 新增人事信息
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:add')")
    @Log(title = "人事信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RenshiINFO renshiINFO)
    {
        return toAjax(renshiINFOService.insertRenshiINFO(renshiINFO));
    }

    /**
     * 修改人事信息
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:edit')")
    @Log(title = "人事信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RenshiINFO renshiINFO)
    {
        return toAjax(renshiINFOService.updateRenshiINFO(renshiINFO));
    }

    /**
     * 删除人事信息
     */
    @PreAuthorize("@ss.hasPermi('system:renshiINFO:remove')")
    @Log(title = "人事信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{staffids}")
    public AjaxResult remove(@PathVariable Long[] staffids)
    {
        return toAjax(renshiINFOService.deleteRenshiINFOByStaffids(staffids));
    }
}
