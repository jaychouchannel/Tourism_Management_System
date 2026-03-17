<template>
	<div class="addEdit-block" :style='{"padding":"0px 0px 30px","fontSize":"14px","color":"#000","background":"none"}'>
		<el-form
			:style='{"border":"0px solid rgba(255,255,255,1)","padding":"30px 0 10px","borderRadius":"0 0 8px 8px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,0)","display":"flex","fontSize":"inherit"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="160px"
		>
			<template>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="导游工号" prop="daoyougonghao">
					<el-input v-model="ruleForm.daoyougonghao" placeholder="导游工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="导游姓名" prop="daoyouxingming">
					<el-input v-model="ruleForm.daoyouxingming" placeholder="导游姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"96%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="求救内容" prop="qiujiuneirong">
					<el-input type="textarea" :rows="4" v-model="ruleForm.qiujiuneirong" placeholder="求救内容" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="处理状态" prop="sfsh">
					<el-select v-model="ruleForm.sfsh" placeholder="处理状态" :disabled="type=='info'">
						<el-option label="待处理" value="待处理"></el-option>
						<el-option label="已处理" value="已处理"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"96%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" label="回复内容" prop="huifuneirong">
					<el-input type="textarea" :rows="4" v-model="ruleForm.huifuneirong" placeholder="请输入回复内容" :readonly="type=='info'"></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'" :style='{"width":"100%","margin":"0","fontSize":"inherit","color":"inherit"}'>
				<el-button type="primary" @click="dataFormSubmit()">确定</el-button>
				<el-button @click="sideClose">取消</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				type: '',
				ruleForm: {
					id: '',
					daoyougonghao: '',
					daoyouxingming: '',
					yonghuzhanghao: '',
					yonghuxingming: '',
					qiujiuneirong: '',
					lianxifangshi: '',
					sfsh: '',
					huifuneirong: '',
				},
				ro: {
					daoyougonghao: false,
					daoyouxingming: false,
					yonghuzhanghao: false,
					yonghuxingming: false,
					qiujiuneirong: false,
					lianxifangshi: false,
					sfsh: false,
					huifuneirong: false,
				},
				rules: {
					sfsh: [],
					huifuneirong: [],
				}
			};
		},
		methods: {
			init(id, type) {
				this.type = type;
				this.ruleForm.id = id || 0;
				if (id) {
					this.$http({
						url: `qiujiu/info/${id}`,
						method: 'get'
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.ruleForm = data.data;
						}
					});
				}
			},
			// 表单提交
			dataFormSubmit() {
				this.$refs['ruleForm'].validate(valid => {
					if (valid) {
						this.$http({
							url: `qiujiu/${this.ruleForm.id ? 'update' : 'save'}`,
							method: 'post',
							data: this.ruleForm
						}).then(({ data }) => {
							if (data && data.code === 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$emit('refreshDataList');
										this.sideClose();
									}
								});
							} else {
								this.$message.error(data.msg);
							}
						});
					}
				});
			},
			sideClose() {
				this.$emit('sideClose');
			}
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 500;
		font-size: inherit;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		font-size: inherit;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #CDCDCD;
		border-radius: 4px;
		padding: 0 12px;
		color: #000;
		font-size: inherit;
		height: 40px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #CDCDCD;
		border-radius: 4px;
		padding: 8px 12px;
		color: #000;
		font-size: inherit;
	}
</style>
