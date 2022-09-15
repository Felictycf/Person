<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="人数" prop="opeople">
        <el-input
          v-model="queryParams.opeople"
          placeholder="请输入人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="餐桌号" prop="canzuohao">
        <el-input
          v-model="queryParams.canzuohao"
          placeholder="请输入餐桌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号码" prop="cotel">
        <el-input
          v-model="queryParams.cotel"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总金额" prop="total">
        <el-input
          v-model="queryParams.total"
          placeholder="请输入总金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款时间" prop="payment">
        <el-date-picker clearable
          v-model="queryParams.payment"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择付款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="入账时间" prop="entry">
        <el-date-picker clearable
          v-model="queryParams.entry"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入账时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="订单状态" prop="dingdanstate">
        <el-input
          v-model="queryParams.dingdanstate"
          placeholder="请输入订单状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单内容" prop="tablecontext">
        <el-input
          v-model="queryParams.tablecontext"
          placeholder="请输入订单内容"
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
          v-hasPermi="['system:orderform:add']"
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
          v-hasPermi="['system:orderform:edit']"
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
          v-hasPermi="['system:orderform:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:orderform:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderformList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单编号" align="center" prop="onum" />
      <el-table-column label="人数" align="center" prop="opeople" />
      <el-table-column label="餐桌号" align="center" prop="canzuohao" />
      <el-table-column label="手机号码" align="center" prop="cotel" />
      <el-table-column label="总金额" align="center" prop="total" />
      <el-table-column label="付款时间" align="center" prop="payment" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.payment, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入账时间" align="center" prop="entry" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.entry, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="订单状态" align="center" prop="dingdanstate" />
      <el-table-column label="订单内容" align="center" prop="tablecontext" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:orderform:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:orderform:remove']"
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

    <!-- 添加或修改订单信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="人数" prop="opeople">
          <el-input v-model="form.opeople" placeholder="请输入人数" />
        </el-form-item>
        <el-form-item label="餐桌号" prop="canzuohao">
          <el-input v-model="form.canzuohao" placeholder="请输入餐桌号" />
        </el-form-item>
        <el-form-item label="手机号码" prop="cotel">
          <el-input v-model="form.cotel" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="总金额" prop="total">
          <el-input v-model="form.total" placeholder="请输入总金额" />
        </el-form-item>
        <el-form-item label="付款时间" prop="payment">
          <el-date-picker clearable
            v-model="form.payment"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择付款时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入账时间" prop="entry">
          <el-date-picker clearable
            v-model="form.entry"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入账时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单状态" prop="dingdanstate">
          <el-input v-model="form.dingdanstate" placeholder="请输入订单状态" />
        </el-form-item>
        <el-form-item label="订单内容" prop="tablecontext">
          <el-input v-model="form.tablecontext" placeholder="请输入订单内容" />
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
import { listOrderform, getOrderform, delOrderform, addOrderform, updateOrderform } from "@/api/system/orderform";

export default {
  name: "Orderform",
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
      // 订单信息表格数据
      orderformList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        opeople: null,
        canzuohao: null,
        cotel: null,
        total: null,
        payment: null,
        entry: null,
        dingdanstate: null,
        tablecontext: null
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
    /** 查询订单信息列表 */
    getList() {
      this.loading = true;
      listOrderform(this.queryParams).then(response => {
        this.orderformList = response.rows;
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
        onum: null,
        opeople: null,
        canzuohao: null,
        cotel: null,
        total: null,
        payment: null,
        entry: null,
        dingdanstate: null,
        tablecontext: null
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
      this.ids = selection.map(item => item.onum)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const onum = row.onum || this.ids
      getOrderform(onum).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.onum != null) {
            updateOrderform(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderform(this.form).then(response => {
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
      const onums = row.onum || this.ids;
      this.$modal.confirm('是否确认删除订单信息编号为"' + onums + '"的数据项？').then(function() {
        return delOrderform(onums);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/orderform/export', {
        ...this.queryParams
      }, `orderform_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
