<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231217/afee84f52c5a44c9b9350d0fc4718aed.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"20px 48% 20px 20px","boxShadow":"none","margin":"0","overflowY":"auto","borderRadius":"0","background":"url() #ffffff95","width":"80%","backgroundSize":"65% 100%","backgroundPosition":"right center","backgroundRepeat":"no-repeat","height":"90vh"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"padding":"0 0 0 100px","margin":"0 0 10px 0","color":"#DF847F","textAlign":"left","width":"100%","lineHeight":"100px","fontSize":"30px","textShadow":"none"}'>西北旅游服务平台注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuzhanghao">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
				<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima2">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuxingming">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
				<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="lianxifangshi">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="daoyougonghao">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('daoyougonghao')?'required':''">导游工号：</div>
				<el-input v-model="registerForm.daoyougonghao"  placeholder="请输入导游工号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="mima">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="mima2">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="daoyouxingming">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('daoyouxingming')?'required':''">导游姓名：</div>
				<el-input v-model="registerForm.daoyouxingming"  placeholder="请输入导游姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="touxiang">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('touxiang')?'required':''">头像：</div>
				<el-input v-model="registerForm.touxiang"  placeholder="请输入头像" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="zhuanyelingyu">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('zhuanyelingyu')?'required':''">专业领域：</div>
				<el-input v-model="registerForm.zhuanyelingyu"  placeholder="请输入专业领域" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="yuyannengli">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('yuyannengli')?'required':''">语言能力：</div>
				<el-input v-model="registerForm.yuyannengli"  placeholder="请输入语言能力" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="lianxifangshi">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='daoyou'" prop="gerenlvli">
				<div v-if="true" :style='{"width":"120px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"right"}' :class="changeRules('gerenlvli')?'required':''">个人履历：</div>
			    <editor
			        :style='{"border":"2px solid #DF847F","width":"100%","overflow":"hidden","borderRadius":"10px","background":"#fff","height":"auto"}'
			        v-model="registerForm.gerenlvli" 
			        class="editor" 
			        action="file/upload">
			    </editor>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"none","margin":"30px 0 20px 120px","color":"#fff","display":"block","outline":"none","borderRadius":"5px","background":"#DF847F","width":"300px","fontSize":"20px","lineHeight":"60px","height":"60px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 6px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"none","outline":"none","borderRadius":"8px","background":"rgba(64, 158, 255, 1)","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","color":"#DF847F","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					touxiang: '',
					xingbie: '',
					lianxifangshi: '',
					status: '',
					passwordwrongnum: '',
				}
			}
			if(this.tableName=='daoyou'){
				this.registerForm = {
					daoyougonghao: '',
					mima: '',
					mima2: '',
					daoyouxingming: '',
					touxiang: '',
					zhuanyelingyu: '',
					yuyannengli: '',
					lianxifangshi: '',
					gerenlvli: '',
					status: '',
					passwordwrongnum: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.requiredRules.daoyougonghao = [{ required: true, message: '请输入导游工号', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.requiredRules.daoyouxingming = [{ required: true, message: '请输入导游姓名', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.passwordwrongnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.daoyougonghao = [{ required: true, message: '请输入导游工号', trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.daoyouxingming = [{ required: true, message: '请输入导游姓名', trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('daoyou' == this.tableName) {
			this.rules.passwordwrongnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$message.error(`用户账号不能为空`);
					return
				}
              if(`yonghu` == this.tableName && (this.registerForm.yonghuzhanghao).toString().length<3){
                this.$message.error('用户账号长度不能小于3');
                return
              }
              if(`yonghu` == this.tableName && (this.registerForm.yonghuzhanghao).toString().length>13){
                this.$message.error('用户账号长度不能大于13');
                return
              }
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
              if(`yonghu` == this.tableName && (this.registerForm.mima).toString().length<3){
                this.$message.error('密码长度不能小于3');
                return
              }
              if(`yonghu` == this.tableName && (this.registerForm.mima).toString().length>13){
                this.$message.error('密码长度不能大于13');
                return
              }
				if((!this.registerForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$message.error(`用户姓名不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.lianxifangshi &&(!this.$validate.isMobile2(this.registerForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
				if((!this.registerForm.daoyougonghao) && `daoyou` == this.tableName){
					this.$message.error(`导游工号不能为空`);
					return
				}
              if(`daoyou` == this.tableName && (this.registerForm.daoyougonghao).toString().length<3){
                this.$message.error('导游工号长度不能小于3');
                return
              }
              if(`daoyou` == this.tableName && (this.registerForm.daoyougonghao).toString().length>13){
                this.$message.error('导游工号长度不能大于13');
                return
              }
               if(`daoyou` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `daoyou` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
              if(`daoyou` == this.tableName && (this.registerForm.mima).toString().length<3){
                this.$message.error('密码长度不能小于3');
                return
              }
              if(`daoyou` == this.tableName && (this.registerForm.mima).toString().length>13){
                this.$message.error('密码长度不能大于13');
                return
              }
				if((!this.registerForm.daoyouxingming) && `daoyou` == this.tableName){
					this.$message.error(`导游姓名不能为空`);
					return
				}
					if(`daoyou` == this.tableName && this.registerForm.lianxifangshi &&(!this.$validate.isMobile2(this.registerForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231217/afee84f52c5a44c9b9350d0fc4718aed.png);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						align-items: center;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #818181;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 300px;
						font-size: 16px;
						border-width: 0 0 2px;
						height: 60px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #818181;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 300px;
						font-size: 16px;
						border-width: 0 0 2px;
						height: 60px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #818181;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 300px;
						font-size: 16px;
						border-width: 0 0 2px;
						height: 60px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #818181;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 300px;
						font-size: 16px;
						border-width: 0 0 2px;
						height: 60px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 2px solid #818181;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #818181;
		  		  width: 200px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 2px solid #818181;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #818181;
		  		  width: 200px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 2px solid #818181;
		  		  cursor: pointer;
		  		  border-radius: 30px;
		  		  color: #818181;
		  		  width: 200px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 115px;
				position: absolute;
				content: "*";
			}
</style>
