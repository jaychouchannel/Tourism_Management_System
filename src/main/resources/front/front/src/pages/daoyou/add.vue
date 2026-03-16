<template>
<div :style='{"border":"2px solid #DF847F","width":"90%","padding":"20px 0","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="导游工号" prop="daoyougonghao">
            <el-input v-model="ruleForm.daoyougonghao" 
                placeholder="导游工号" clearable :disabled=" false  ||ro.daoyougonghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="密码" prop="mima">
            <el-input v-model="ruleForm.mima" 
                placeholder="密码" clearable :disabled=" false  ||ro.mima"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="导游姓名" prop="daoyouxingming">
            <el-input v-model="ruleForm.daoyouxingming" 
                placeholder="导游姓名" clearable :disabled=" false  ||ro.daoyouxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="头像" prop="touxiang">
            <el-input v-model="ruleForm.touxiang" 
                placeholder="头像" clearable :disabled=" false  ||ro.touxiang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="专业领域" prop="zhuanyelingyu">
            <el-input v-model="ruleForm.zhuanyelingyu" 
                placeholder="专业领域" clearable :disabled=" false  ||ro.zhuanyelingyu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="语言能力" prop="yuyannengli">
            <el-input v-model="ruleForm.yuyannengli" 
                placeholder="语言能力" clearable :disabled=" false  ||ro.yuyannengli"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="联系方式" prop="lianxifangshi">
            <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" clearable :disabled=" false  ||ro.lianxifangshi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="个人履历" prop="gerenlvli">
            <editor 
                :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.gerenlvli" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#DF847F","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#8FD5E7","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				daoyougonghao : false,
				mima : false,
				daoyouxingming : false,
				touxiang : false,
				zhuanyelingyu : false,
				yuyannengli : false,
				lianxifangshi : false,
				gerenlvli : false,
				status : false,
				passwordwrongnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          daoyougonghao: '',
          mima: '',
          daoyouxingming: '',
          touxiang: '',
          zhuanyelingyu: '',
          yuyannengli: '',
          lianxifangshi: '',
          gerenlvli: '',
          status: '',
          passwordwrongnum: '',
        },


        rules: {
          daoyougonghao: [
            { required: true, message: '导游工号不能为空', trigger: 'blur' },
          ],
          mima: [
            { required: true, message: '密码不能为空', trigger: 'blur' },
          ],
          daoyouxingming: [
            { required: true, message: '导游姓名不能为空', trigger: 'blur' },
          ],
          touxiang: [
          ],
          zhuanyelingyu: [
          ],
          yuyannengli: [
          ],
          lianxifangshi: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          gerenlvli: [
          ],
          status: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          passwordwrongnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='daoyougonghao'){
              this.ruleForm.daoyougonghao = obj[o];
              this.ro.daoyougonghao = true;
              continue;
            }
            if(o=='mima'){
              this.ruleForm.mima = obj[o];
              this.ro.mima = true;
              continue;
            }
            if(o=='daoyouxingming'){
              this.ruleForm.daoyouxingming = obj[o];
              this.ro.daoyouxingming = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='zhuanyelingyu'){
              this.ruleForm.zhuanyelingyu = obj[o];
              this.ro.zhuanyelingyu = true;
              continue;
            }
            if(o=='yuyannengli'){
              this.ruleForm.yuyannengli = obj[o];
              this.ro.yuyannengli = true;
              continue;
            }
            if(o=='lianxifangshi'){
              this.ruleForm.lianxifangshi = obj[o];
              this.ro.lianxifangshi = true;
              continue;
            }
            if(o=='gerenlvli'){
              this.ruleForm.gerenlvli = obj[o];
              this.ro.gerenlvli = true;
              continue;
            }
            if(o=='status'){
              this.ruleForm.status = obj[o];
              this.ro.status = true;
              continue;
            }
            if(o=='passwordwrongnum'){
              this.ruleForm.passwordwrongnum = obj[o];
              this.ro.passwordwrongnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`daoyou/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			if((this.ruleForm.daoyougonghao).toString().length<3){
                this.$message.error('导游工号长度不能小于3');
                return
			}
			if((this.ruleForm.daoyougonghao).toString().length>13){
                this.$message.error('导游工号长度不能大于13');
                return
			}
			if((this.ruleForm.mima).toString().length<3){
                this.$message.error('密码长度不能小于3');
                return
			}
			if((this.ruleForm.mima).toString().length>13){
                this.$message.error('密码长度不能大于13');
                return
			}
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('daoyou/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`daoyou/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`daoyou/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #CDCDCD;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 50px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #CDCDCD;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 50px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #CDCDCD;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 50px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #CDCDCD;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 50px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #CDCDCD;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #3d3d3d;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #CDCDCD;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #3d3d3d;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #CDCDCD;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #3d3d3d;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #CDCDCD;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 500px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
