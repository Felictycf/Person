<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="培训开始时间" prop="trainingstart">
        <el-date-picker clearable
          v-model="queryParams.trainingstart"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择培训开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="培训结束时间" prop="trainingend">
        <el-date-picker clearable
          v-model="queryParams.trainingend"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择培训结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="考核官" prop="trainer">
        <el-input
          v-model="queryParams.trainer"
          placeholder="请输入考核官"
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
          v-hasPermi="['system:zhigongpractice:add']"
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
          v-hasPermi="['system:zhigongpractice:edit']"
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
          v-hasPermi="['system:zhigongpractice:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:zhigongpractice:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="zhigongpracticeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="职工号" align="center" prop="staffid" />
      <el-table-column label="培训开始时间" align="center" prop="trainingstart" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.trainingstart, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="培训结束时间" align="center" prop="trainingend" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.trainingend, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="培训内容" align="center" prop="trainingcontent" />
      <el-table-column label="考核官" align="center" prop="trainer" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:zhigongpractice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:zhigongpractice:remove']"
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

    <!-- 添加或修改职工培训对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="培训开始时间" prop="trainingstart">
          <el-date-picker clearable
            v-model="form.trainingstart"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择培训开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="培训结束时间" prop="trainingend">
          <el-date-picker clearable
            v-model="form.trainingend"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择培训结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="培训内容">
          <editor v-model="form.trainingcontent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="考核官" prop="trainer">
          <el-input v-model="form.trainer" placeholder="请输入考核官" />
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
import { listZhigongpractice, getZhigongpractice, delZhigongpractice, addZhigongpractice, updateZhigongpractice } from "@/api/system/zhigongpractice";

export default {
  name: "Zhigongpractice",
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
      // 职工培训表格数据
      zhigongpracticeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        trainingstart: null,
        trainingend: null,
        trainingcontent: null,
        trainer: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询职工培训列表 */
    getList() {
      this.loading = true;
      listZhigongpractice(this.queryParams).then(response => {
        this.zhigongpracticeList = response.rows;
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
        trainingstart: null,
        trainingend: null,
        trainingcontent: null,
        trainer: null
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
      this.title = "添加职工培训";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const staffid = row.staffid || this.ids
      getZhigongpractice(staffid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改职工培训";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.staffid != null) {
            updateZhigongpractice(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addZhigongpractice(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除职工培训编号为"' + staffids + '"的数据项？').then(function() {
        return delZhigongpractice(staffids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/zhigongpractice/export', {
        ...this.queryParams
      }, `zhigongpractice_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
