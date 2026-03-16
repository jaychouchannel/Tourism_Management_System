<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(https://pic3.zhimg.com/f55952455020a6e25a013984aa7a7329_r.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"40px 48% 20px 20px","boxShadow":"none","margin":"0","alignItems":"center","flexDirection":"column","display":"flex","justifyContent":"center","borderRadius":"0","background":"url() #ffffff95","width":"80%","backgroundSize":"65% 100%","backgroundPosition":"right center","backgroundRepeat":"no-repeat","height":"90vh"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"padding":"0 0 0 100px","margin":"40px 0 10px 0","color":"#DF847F","textAlign":"left","width":"100%","lineHeight":"50px","fontSize":"30px","textShadow":"none","fontWeight":"bold","order":"1"}'>西北旅游服务平台登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 50px","order":"2"}' prop="username">
				<div v-if="true" :style='{"width":"100px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"center"}'>账号：</div>
				<input :style='{"border":"1px solid #909090","padding":"0 10px","boxShadow":"none","outline":"none","color":"#000","outlineOffset":"0","borderWidth":"0 0 2px","background":"none","width":"300px","fontSize":"16px","height":"60px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 50px","order":"2"}' prop="password">
				<div v-if="true" :style='{"width":"100px","lineHeight":"60px","fontSize":"16px","color":"#818181","textAlign":"center"}'>密码：</div>
				<input :style='{"border":"1px solid #909090","padding":"0 10px","boxShadow":"none","outline":"none","color":"#000","outlineOffset":"0","borderWidth":"0 0 2px","background":"none","width":"300px","fontSize":"16px","height":"60px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>

			<el-form-item class="list-type select" :style='{"width":"100%","margin":"0 auto 50px","order":"2"}' v-if="roles.length>1">
			  <el-select v-model="loginForm.tableName" placeholder="请选择角色" @change="selectChange">
				<el-option v-for="item,index in roles" :key="index" :label="item.roleName" :value="item.tableName" />
			  </el-select>
			</el-form-item>

			
			<el-form-item class="list-btn" :style='{"width":"100%","margin":"40px auto","order":"4"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 0 0 100px","outline":"none","color":"#fff","borderRadius":"5px","background":"#DF847F","width":"300px","fontSize":"22px","height":"70px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","display":"none","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"margin":"20px 0 20px","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center","order":"5"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 10px","fontSize":"14px","textDecoration":"none","color":"#DF847F","background":"none"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
</div>
</template>

<script>
import menu from '@/config/menu'
export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}],
			flag: false,
			verifyCheck2: false,
		}
	},
  components: {
  },
	created() {
		this.roleMenus = menu.list()
		for(let item in this.roleMenus) {
		    if(this.roleMenus[item].hasFrontLogin=='是') {
		        this.roles.push(this.roleMenus[item]);
		    }
		}
		
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
	  selectChange(e){
		  this.role = e
	  },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }

		this.loginPost(formName)
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  loginPost(formName) {
		this.$refs[formName].validate((valid) => {
		  if (valid) {
		    this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
		      if (res.data.code === 0) {
		        localStorage.setItem('frontToken', res.data.token);
		        localStorage.setItem('UserTableName', this.loginForm.tableName);
		        localStorage.setItem('username', this.loginForm.username);
		        localStorage.setItem('adminName', this.loginForm.username);
		        localStorage.setItem('frontSessionTable', this.loginForm.tableName);
		        localStorage.setItem('frontRole', this.role);
		        localStorage.setItem('keyPath', 0);
		        this.$router.push('/');
		        this.$message({
		          message: '登录成功',
		          type: 'success',
		          duration: 1500,
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
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(https://pic3.zhimg.com/f55952455020a6e25a013984aa7a7329_r.jpg);
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-form-item__content {
			display: flex;
			align-items: center;
		}

		.list-code /deep/ .el-form-item__content {
			display: flex;
			align-items: center;
		}

		.list-type /deep/ .el-form-item__content {
			display: flex;
			order: 3;
		}

		.list-btn /deep/ .el-form-item__content {
			display: flex;
			justify-content: flex-start;
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #909090;
			padding: 0 10px;
			box-shadow: none;
			outline: none;
			color: #000;
			background: none;
			width: 300px;
			font-size: 16px;
			outline-offset: 0;
			border-width: 0 0 2px;
			height: 60px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #909090;
			padding: 0 10px;
			outline: none;
			margin: 0 10px 0 0;
			color: #000;
			background: none;
			display: inline-block;
			vertical-align: middle;
			width: 190px;
			font-size: 16px;
			border-width: 0 0 2px;
			height: 60px;
		}

		// select
		.list-type.select .el-select /deep/ .el-input__inner {
			border: 1px solid #909090;
			border-radius: 0;
			padding: 0 10px;
			box-shadow: none;
			margin: 0 0 0 100px;
			color: #000;
			background: none;
			width: 300px;
			font-size: 16px;
			border-width: 0 0 2px;
			height: 60px;
		}
	}

</style>
