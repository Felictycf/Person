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
import com.ruoyi.system.domain.KuowuID;
import com.ruoyi.system.service.IKuowuIDService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 鲜花订单地址管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-12
 */
@RestController
@RequestMapping("/system/kuowuID")
public class KuowuIDController extends BaseController
{
    @Autowired
    private IKuowuIDService kuowuIDService;

    /**
     * 查询鲜花订单地址管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:list')")
    @GetMapping("/list")
    public TableDataInfo list(KuowuID kuowuID)
    {
        startPage();
        List<KuowuID> list = kuowuIDService.selectKuowuIDList(kuowuID);
        return getDataTable(list);
    }

    /**
     * 导出鲜花订单地址管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:export')")
    @Log(title = "鲜花订单地址管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, KuowuID kuowuID)
    {
        List<KuowuID> list = kuowuIDService.selectKuowuIDList(kuowuID);
        ExcelUtil<KuowuID> util = new ExcelUtil<KuowuID>(KuowuID.class);
        util.exportExcel(response, list, "鲜花订单地址管理数据");
    }

    /**
     * 获取鲜花订单地址管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:query')")
    @GetMapping(value = "/{huowuId}")
    public AjaxResult getInfo(@PathVariable("huowuId") Long huowuId)
    {
        return AjaxResult.success(kuowuIDService.selectKuowuIDByHuowuId(huowuId));
    }

    /**
     * 新增鲜花订单地址管理
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:add')")
    @Log(title = "鲜花订单地址管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KuowuID kuowuID)
    {
        return toAjax(kuowuIDService.insertKuowuID(kuowuID));
    }

    /**
     * 修改鲜花订单地址管理
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:edit')")
    @Log(title = "鲜花订单地址管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KuowuID kuowuID)
    {
        return toAjax(kuowuIDService.updateKuowuID(kuowuID));
    }

    /**
     * 删除鲜花订单地址管理
     */
    @PreAuthorize("@ss.hasPermi('system:kuowuID:remove')")
    @Log(title = "鲜花订单地址管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{huowuIds}")
    public AjaxResult remove(@PathVariable Long[] huowuIds)
    {
        return toAjax(kuowuIDService.deleteKuowuIDByHuowuIds(huowuIds));
    }
}
