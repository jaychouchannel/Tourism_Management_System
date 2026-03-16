<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","border":"30px solid #ffc054","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231107/de423fd8df8f4765b7a00108faf7266e.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center bottom","backgroundRepeat":"no-repeat","justifyContent":"flex-end"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #f6f6f6","minHeight":"calc(100vh - 60px)","padding":"20px 60px 20px 120px","margin":"0","borderRadius":"0px","textAlign":"center","background":"#fff","width":"35vw","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0px","margin":"0px auto 20px","borderColor":"#eee","color":"#1e3c4f","textAlign":"center","display":"inline-block","background":"#fff","borderWidth":"0px","width":"100%","lineHeight":"40px","fontSize":"24px","borderStyle":"solid","fontWeight":"600"}' class="title">西北旅游服务平台注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
					<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
					<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('daoyougonghao')?'required':''">导游工号：</div>
					<el-input  v-model="ruleForm.daoyougonghao"  autocomplete="off" placeholder="导游工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('daoyouxingming')?'required':''">导游姓名：</div>
					<el-input  v-model="ruleForm.daoyouxingming"  autocomplete="off" placeholder="导游姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
					<el-input  v-model="ruleForm.touxiang"  autocomplete="off" placeholder="头像"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('zhuanyelingyu')?'required':''">专业领域：</div>
					<el-input  v-model="ruleForm.zhuanyelingyu"  autocomplete="off" placeholder="专业领域"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('yuyannengli')?'required':''">语言能力：</div>
					<el-input  v-model="ruleForm.yuyannengli"  autocomplete="off" placeholder="语言能力"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='daoyou'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#002355","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gerenlvli')?'required':''">个人履历：</div>
					<editor
						style="min-width: 200px; max-width: 600px;"
						:style='{"width":"100%","height":"auto"}'
						v-model="ruleForm.gerenlvli" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"inline-block","letterSpacing":"4px","outline":"none","borderRadius":"0px","background":"#ffc054","width":"100%","fontSize":"18px","fontWeight":"500","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0px","margin":"10px 0 0","color":"#ffc054","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					touxiang: '',
					xingbie: '',
					lianxifangshi: '',
					status: '',
					passwordwrongnum: '',
				}
			}
			if(this.tableName=='daoyou'){
				this.ruleForm = {
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
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.rules.daoyougonghao = [{ required: true, message: '请输入导游工号', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('daoyou' == this.tableName) {
				this.rules.daoyouxingming = [{ required: true, message: '请输入导游姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
						this.$message.error(`用户账号不能为空`);
						return
					}
					if(this.ruleForm.yonghuzhanghao && ((this.ruleForm.yonghuzhanghao).toString().length<3) && `yonghu` == this.tableName){
						this.$message.error(`用户账号长度不能小于3`);
						return
					}
					if(this.ruleForm.yonghuzhanghao && ((this.ruleForm.yonghuzhanghao).toString().length>13) && `yonghu` == this.tableName){
						this.$message.error(`用户账号长度不能大于13`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length<3) && `yonghu` == this.tableName){
						this.$message.error(`密码长度不能小于3`);
						return
					}
					if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length>13) && `yonghu` == this.tableName){
						this.$message.error(`密码长度不能大于13`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
						this.$message.error(`用户姓名不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`yonghu` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
					if((!this.ruleForm.daoyougonghao) && `daoyou` == this.tableName){
						this.$message.error(`导游工号不能为空`);
						return
					}
					if(this.ruleForm.daoyougonghao && ((this.ruleForm.daoyougonghao).toString().length<3) && `daoyou` == this.tableName){
						this.$message.error(`导游工号长度不能小于3`);
						return
					}
					if(this.ruleForm.daoyougonghao && ((this.ruleForm.daoyougonghao).toString().length>13) && `daoyou` == this.tableName){
						this.$message.error(`导游工号长度不能大于13`);
						return
					}
					if((!this.ruleForm.mima) && `daoyou` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length<3) && `daoyou` == this.tableName){
						this.$message.error(`密码长度不能小于3`);
						return
					}
					if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length>13) && `daoyou` == this.tableName){
						this.$message.error(`密码长度不能大于13`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `daoyou` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.daoyouxingming) && `daoyou` == this.tableName){
						this.$message.error(`导游姓名不能为空`);
						return
					}
					if(`daoyou` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231107/de423fd8df8f4765b7a00108faf7266e.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #a5a5a5;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #a5a5a5;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #a5a5a5;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #a5a5a5;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
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
		  		  cursor: pointer;
		  		  color: #a5a5a5;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #a5a5a5;
		  		  line-height: 60px;
		  		  border-radius: 0px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 0 0 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  color: #a5a5a5;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #a5a5a5;
		  		  line-height: 60px;
		  		  border-radius: 0px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 0 0 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  color: #a5a5a5;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #a5a5a5;
		  		  line-height: 60px;
		  		  border-radius: 0px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 0 0 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 6px;
				content: "*";
				order: 1;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
