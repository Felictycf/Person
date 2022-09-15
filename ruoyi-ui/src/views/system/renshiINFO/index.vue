<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="birth">
        <el-date-picker clearable
          v-model="queryParams.birth"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="籍贯" prop="birthplace">
        <el-input
          v-model="queryParams.birthplace"
          placeholder="请输入籍贯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="民族" prop="nation">
        <el-input
          v-model="queryParams.nation"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="homeAddr">
        <el-input
          v-model="queryParams.homeAddr"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="telehone">
        <el-input
          v-model="queryParams.telehone"
          placeholder="请输入电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="schoolrecord">
        <el-input
          v-model="queryParams.schoolrecord"
          placeholder="请输入学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在部门" prop="departmentname">
        <el-input
          v-model="queryParams.departmentname"
          placeholder="请输入所在部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参加工作" prop="worktime">
        <el-date-picker clearable
          v-model="queryParams.worktime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择参加工作">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="进本单位时间" prop="enterdptdate">
        <el-date-picker clearable
          v-model="queryParams.enterdptdate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择进本单位时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="现任岗位" prop="post">
        <el-input
          v-model="queryParams.post"
          placeholder="请输入现任岗位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="政治面貌" prop="political">
        <el-input
          v-model="queryParams.political"
          placeholder="请输入政治面貌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:renshiINFO:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:renshiINFO:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:renshiINFO:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:renshiINFO:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="renshiINFOList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="职工号" align="center" prop="staffid" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="sex" />
      <el-table-column label="出生日期" align="center" prop="birth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="籍贯" align="center" prop="birthplace" />
      <el-table-column label="民族" align="center" prop="nation" />
      <el-table-column label="地址" align="center" prop="homeAddr" />
      <el-table-column label="电话" align="center" prop="telehone" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="学历" align="center" prop="schoolrecord" />
      <el-table-column label="所在部门" align="center" prop="departmentname" />
      <el-table-column label="参加工作" align="center" prop="worktime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.worktime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="进本单位时间" align="center" prop="enterdptdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enterdptdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="现任岗位" align="center" prop="post" />
      <el-table-column label="政治面貌" align="center" prop="political" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:renshiINFO:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:renshiINFO:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改人事信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birth">
          <el-date-picker clearable
            v-model="form.birth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="籍贯" prop="birthplace">
          <el-input v-model="form.birthplace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="民族" prop="nation">
          <el-input v-model="form.nation" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="地址" prop="homeAddr">
          <el-input v-model="form.homeAddr" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="电话" prop="telehone">
          <el-input v-model="form.telehone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="学历" prop="schoolrecord">
          <el-input v-model="form.schoolrecord" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="所在部门" prop="departmentname">
          <el-input v-model="form.departmentname" placeholder="请输入所在部门" />
        </el-form-item>
        <el-form-item label="参加工作" prop="worktime">
          <el-date-picker clearable
            v-model="form.worktime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择参加工作">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="进本单位时间" prop="enterdptdate">
          <el-date-picker clearable
            v-model="form.enterdptdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择进本单位时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="现任岗位" prop="post">
          <el-input v-model="form.post" placeholder="请输入现任岗位" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="political">
          <el-input v-model="form.political" placeholder="请输入政治面貌" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRenshiINFO, getRenshiINFO, delRenshiINFO, addRenshiINFO, updateRenshiINFO } from "@/api/system/renshiINFO";

export default {
  name: "RenshiINFO",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 人事信息表格数据
      renshiINFOList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        sex: null,
        birth: null,
        birthplace: null,
        nation: null,
        homeAddr: null,
        telehone: null,
        email: null,
        schoolrecord: null,
        departmentname: null,
        worktime: null,
        enterdptdate: null,
        post: null,
        political: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        birth: [
          { required: true, message: "出生日期不能为空", trigger: "blur" }
        ],
        birthplace: [
          { required: true, message: "籍贯不能为空", trigger: "blur" }
        ],
        nation: [
          { required: true, message: "民族不能为空", trigger: "blur" }
        ],
        homeAddr: [
          { required: true, message: "地址不能为空", trigger: "blur" }
        ],
        telehone: [
          { required: true, message: "电话不能为空", trigger: "blur" }
        ],
        enterdptdate: [
          { required: true, message: "进本单位时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询人事信息列表 */
    getList() {
      this.loading = true;
      listRenshiINFO(this.queryParams).then(response => {
        this.renshiINFOList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        staffid: null,
        name: null,
        sex: null,
        birth: null,
        birthplace: null,
        nation: null,
        homeAddr: null,
        telehone: null,
        email: null,
        schoolrecord: null,
        departmentname: null,
        worktime: null,
        enterdptdate: null,
        post: null,
        political: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.staffid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加人事信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const staffid = row.staffid || this.ids
      getRenshiINFO(staffid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人事信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.staffid != null) {
            updateRenshiINFO(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRenshiINFO(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const staffids = row.staffid || this.ids;
      this.$modal.confirm('是否确认删除人事信息编号为"' + staffids + '"的数据项？').then(function() {
        return delRenshiINFO(staffids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/renshiINFO/export', {
        ...this.queryParams
      }, `renshiINFO_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
