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
import com.ruoyi.system.domain.PersonManger;
import com.ruoyi.system.service.IPersonMangerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职工薪酬信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/system/personManger")
public class PersonMangerController extends BaseController
{
    @Autowired
    private IPersonMangerService personMangerService;

    /**
     * 查询职工薪酬信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonManger personManger)
    {
        startPage();
        List<PersonManger> list = personMangerService.selectPersonMangerList(personManger);
        return getDataTable(list);
    }

    /**
     * 导出职工薪酬信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:export')")
    @Log(title = "职工薪酬信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonManger personManger)
    {
        List<PersonManger> list = personMangerService.selectPersonMangerList(personManger);
        ExcelUtil<PersonManger> util = new ExcelUtil<PersonManger>(PersonManger.class);
        util.exportExcel(response, list, "职工薪酬信息数据");
    }

    /**
     * 获取职工薪酬信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:query')")
    @GetMapping(value = "/{staffid}")
    public AjaxResult getInfo(@PathVariable("staffid") String staffid)
    {
        return AjaxResult.success(personMangerService.selectPersonMangerByStaffid(staffid));
    }

    /**
     * 新增职工薪酬信息
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:add')")
    @Log(title = "职工薪酬信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonManger personManger)
    {
        return toAjax(personMangerService.insertPersonManger(personManger));
    }

    /**
     * 修改职工薪酬信息
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:edit')")
    @Log(title = "职工薪酬信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonManger personManger)
    {
        return toAjax(personMangerService.updatePersonManger(personManger));
    }

    /**
     * 删除职工薪酬信息
     */
    @PreAuthorize("@ss.hasPermi('system:personManger:remove')")
    @Log(title = "职工薪酬信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{staffids}")
    public AjaxResult remove(@PathVariable String[] staffids)
    {
        return toAjax(personMangerService.deletePersonMangerByStaffids(staffids));
    }
}
