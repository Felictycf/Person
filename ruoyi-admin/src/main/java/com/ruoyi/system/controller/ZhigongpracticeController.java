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
import com.ruoyi.system.domain.Zhigongpractice;
import com.ruoyi.system.service.IZhigongpracticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职工培训Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/zhigongpractice")
public class ZhigongpracticeController extends BaseController
{
    @Autowired
    private IZhigongpracticeService zhigongpracticeService;

    /**
     * 查询职工培训列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhigongpractice zhigongpractice)
    {
        startPage();
        List<Zhigongpractice> list = zhigongpracticeService.selectZhigongpracticeList(zhigongpractice);
        return getDataTable(list);
    }

    /**
     * 导出职工培训列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:export')")
    @Log(title = "职工培训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Zhigongpractice zhigongpractice)
    {
        List<Zhigongpractice> list = zhigongpracticeService.selectZhigongpracticeList(zhigongpractice);
        ExcelUtil<Zhigongpractice> util = new ExcelUtil<Zhigongpractice>(Zhigongpractice.class);
        util.exportExcel(response, list, "职工培训数据");
    }

    /**
     * 获取职工培训详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:query')")
    @GetMapping(value = "/{staffid}")
    public AjaxResult getInfo(@PathVariable("staffid") String staffid)
    {
        return AjaxResult.success(zhigongpracticeService.selectZhigongpracticeByStaffid(staffid));
    }

    /**
     * 新增职工培训
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:add')")
    @Log(title = "职工培训", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhigongpractice zhigongpractice)
    {
        return toAjax(zhigongpracticeService.insertZhigongpractice(zhigongpractice));
    }

    /**
     * 修改职工培训
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:edit')")
    @Log(title = "职工培训", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhigongpractice zhigongpractice)
    {
        return toAjax(zhigongpracticeService.updateZhigongpractice(zhigongpractice));
    }

    /**
     * 删除职工培训
     */
    @PreAuthorize("@ss.hasPermi('system:zhigongpractice:remove')")
    @Log(title = "职工培训", businessType = BusinessType.DELETE)
	@DeleteMapping("/{staffids}")
    public AjaxResult remove(@PathVariable String[] staffids)
    {
        return toAjax(zhigongpracticeService.deleteZhigongpracticeByStaffids(staffids));
    }
}
