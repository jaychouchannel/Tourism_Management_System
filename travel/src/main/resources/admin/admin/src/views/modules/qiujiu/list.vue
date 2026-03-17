<template>
	<div :style='{"padding":"0","fontSize":"14px","color":"#000","background":"none"}'>
		<template v-if="showFlag">
			<el-form :inline="true" :model="searchForm" class="detail-vuepreview" :style='{"border":"0","padding":"10px 0 0 ","margin":"0 0 10px","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","fontSize":"inherit","justifyContent":"flex-start"}'>
				<el-row :style='{"margin":"0px 0 10px","color":"#fff","flexWrap":"wrap","textAlign":"left","flexDirection":"row","display":"flex","width":"auto","fontSize":"inherit","justifyContent":"flex-start","order":"1"}'>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<el-input v-model="searchForm.yonghuxingming" placeholder="用户姓名" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<el-input v-model="searchForm.daoyougonghao" placeholder="导游工号" clearable></el-input>
					</div>
					<el-select clearable v-model="searchForm.sfsh" placeholder="处理状态">
						<el-option v-for="(item,index) in sfshOptions" v-bind:key="index" :label="item" :value="item"></el-option>
					</el-select>
					<el-button class="search" type="success" @click="search()">
						查找
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"margin":"0px 0 20px","color":"#fff","flexWrap":"wrap","textAlign":"right","flexDirection":"row","display":"flex","width":"auto","fontSize":"inherit","justifyContent":"flex-end","order":"2"}'>
					<el-button class="del" v-if="isAuth('qiujiu','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						删除
					</el-button>
					<el-button class="btn18" v-if="isAuth('qiujiu','响应')" :disabled="dataListSelections.length?false:true" type="success" @click="shBatchDialog()">
						响应
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0px 0 0","borderRadius":"20px","background":"rgba(255,255,255,1)"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#edf7ff","color":"inherit","borderRadius":"20px","borderWidth":"0px 0px 0 0px","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('qiujiu','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true' prop="daoyougonghao" label="导游工号">
						<template slot-scope="scope">
							{{scope.row.daoyougonghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="daoyouxingming" label="导游姓名">
						<template slot-scope="scope">
							{{scope.row.daoyouxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="yonghuzhanghao" label="用户账号">
						<template slot-scope="scope">
							{{scope.row.yonghuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="yonghuxingming" label="用户姓名">
						<template slot-scope="scope">
							{{scope.row.yonghuxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="lianxifangshi" label="联系方式">
						<template slot-scope="scope">
							{{scope.row.lianxifangshi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="qiujiuneirong" label="求救内容" show-overflow-tooltip>
						<template slot-scope="scope">
							<div style="white-space: nowrap;">{{scope.row.qiujiuneirong}}</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="huifuneirong" label="回复内容" show-overflow-tooltip>
						<template slot-scope="scope">
							<div style="white-space: nowrap;">{{scope.row.huifuneirong}}</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="sfsh" label="处理状态">
						<template slot-scope="scope">
							<el-tag v-if="scope.row.sfsh=='已处理'" type="success">已处理</el-tag>
							<el-tag v-if="scope.row.sfsh=='待处理'" type="warning">待处理</el-tag>
						</template>
					</el-table-column>
					
					<el-table-column width="200" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if="isAuth('qiujiu','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								查看
							</el-button>
							<el-button class="edit" v-if="isAuth('qiujiu','修改') && scope.row.sfsh=='待处理'" type="primary" @click="addOrUpdateHandler(scope.row.id)">
								响应
							</el-button>
							<el-button class="del" v-if="isAuth('qiujiu','删除')" type="danger" @click="deleteHandler(scope.row.id)">
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"inherit","textAlign":"left","width":"100%","fontSize":"inherit","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改/查看页面 -->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


		<el-dialog :title="this.batchIds.length>1?'批量响应':'响应'" :visible.sync="sfshBatchVisiable" width="50%">
			<el-form ref="shForm" :model="shBatchForm" label-width="80px">
				<el-form-item label="处理状态">
					<el-select v-model="shBatchForm.sfsh" placeholder="处理状态">
						<el-option label="已处理" value="已处理"></el-option>
						<el-option label="待处理" value="待处理"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="回复内容">
					<el-input type="textarea" :rows="8" v-model="shBatchForm.huifuneirong"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="sfshBatchVisiable=false">取 消</el-button>
				<el-button type="primary" @click="shBatchHandler">确 定</el-button>
			</span>
		</el-dialog>

	</div>
</template>

<script>
import AddOrUpdate from "./add-or-update";
	export default {
		data() {
			return {
				searchForm: {
					key: ""
				},
				form:{},
				sfshOptions: [],
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				sfshBatchVisiable: false,
				shBatchForm: {
					sfsh: '',
					huifuneirong: ''
				},
				batchIds:[],
				addOrUpdateFlag: false,
				layouts: ["prev","pager","next","jumper"],
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate
		},
		methods: {
			contentStyleChange(){
			},
			init() {
				this.sfshOptions = "待处理,已处理".split(',');
			},
			search() {
				this.pageIndex = 1;
				this.getDataList();
			},

			// 获取数据列表
			getDataList() {
				this.dataListLoading = true;
				let params = {
					page: this.pageIndex,
					limit: this.pageSize,
					sort: 'id',
					order: 'desc',
				}
				if(this.searchForm.yonghuxingming!='' && this.searchForm.yonghuxingming!=undefined){
					params['yonghuxingming'] = '%' + this.searchForm.yonghuxingming + '%'
				}
				if(this.searchForm.daoyougonghao!='' && this.searchForm.daoyougonghao!=undefined){
					params['daoyougonghao'] = '%' + this.searchForm.daoyougonghao + '%'
				}
				if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
					params['sfsh'] = this.searchForm.sfsh
				}
				this.$http({
					url: "qiujiu/page",
					method: "get",
					params: params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.dataList = data.data.list;
						this.totalPage = data.data.total;
					} else {
						this.dataList = [];
						this.totalPage = 0;
					}
					this.dataListLoading = false;
				});
			},
			// 每页数
			sizeChangeHandle(val) {
				this.pageSize = val;
				this.pageIndex = 1;
				this.getDataList();
			},
			// 当前页
			currentChangeHandle(val) {
				this.pageIndex = val;
				this.getDataList();
			},
			// 多选
			selectionChangeHandler(val) {
				this.dataListSelections = val;
			},
			// 新增 / 修改
			addOrUpdateHandler(id, type) {
				this.showFlag = false;
				this.addOrUpdateFlag = true;
				this.$nextTick(() => {
					this.$refs.addOrUpdate.init(id, type);
				});
			},
			// 删除
			deleteHandler(id) {
				let ids = id ? [id] : this.dataListSelections.map(item => {
					return item.id
				});
				this.$confirm(`是否确认删除?`, '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.$http({
						url: 'qiujiu/delete',
						method: 'post',
						data: ids
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: '操作成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				});
			},
			// 批量响应窗口
			shBatchDialog(){
				this.batchIds = []
				for(let x in this.dataListSelections){
					this.batchIds.push(this.dataListSelections[x].id)
				}
				this.sfshBatchVisiable = true
			},
			// 批量响应
			shBatchHandler(){
				this.$confirm(`是否响应选中的求救信息?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(() => {
					this.$http({
						url: "qiujiu/shBatch?sfsh=" + this.shBatchForm.sfsh + "&huifuneirong=" + encodeURIComponent(this.shBatchForm.huifuneirong),
						method: "post",
						data: this.batchIds
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "操作成功",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
									this.sfshBatchVisiable = false
									this.batchIds = []
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				});
			},
			refreshDataList() {
				this.getDataList();
			},
			sideClose() {
				this.showFlag = true;
				this.addOrUpdateFlag = false;
				this.getDataList();
			}
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
</style>
