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
import com.ruoyi.system.domain.HbkjStudent;
import com.ruoyi.system.service.IHbkjStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生情绪信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@RestController
@RequestMapping("/system/student")
public class HbkjStudentController extends BaseController
{
    @Autowired
    private IHbkjStudentService hbkjStudentService;

    /**
     * 查询学生情绪信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(HbkjStudent hbkjStudent)
    {
        startPage();
        List<HbkjStudent> list = hbkjStudentService.selectHbkjStudentList(hbkjStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生情绪信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生情绪信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HbkjStudent hbkjStudent)
    {
        List<HbkjStudent> list = hbkjStudentService.selectHbkjStudentList(hbkjStudent);
        ExcelUtil<HbkjStudent> util = new ExcelUtil<HbkjStudent>(HbkjStudent.class);
        util.exportExcel(response, list, "学生情绪信息数据");
    }

    /**
     * 获取学生情绪信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hbkjStudentService.selectHbkjStudentById(id));
    }

    /**
     * 新增学生情绪信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生情绪信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HbkjStudent hbkjStudent)
    {
        return toAjax(hbkjStudentService.insertHbkjStudent(hbkjStudent));
    }

    /**
     * 修改学生情绪信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生情绪信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HbkjStudent hbkjStudent)
    {
        return toAjax(hbkjStudentService.updateHbkjStudent(hbkjStudent));
    }

    /**
     * 删除学生情绪信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生情绪信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hbkjStudentService.deleteHbkjStudentByIds(ids));
    }
}
