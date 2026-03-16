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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="线路名称" prop="xianlumingcheng">
            <el-input v-model="ruleForm.xianlumingcheng" 
                placeholder="线路名称" clearable :disabled=" false  ||ro.xianlumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="线路图片" v-if="type!='cross' || (type=='cross' && !ro.xianlutupian)" prop="xianlutupian">
            <file-upload
            tip="点击上传线路图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.xianlutupian?ruleForm.xianlutupian:''"
            @change="xianlutupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' class="upload" v-else label="线路图片" prop="xianlutupian">
                <img v-if="ruleForm.xianlutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.xianlutupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xianlutupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="出发日期" prop="chufariqi">
              <el-date-picker
				  :disabled=" false  ||ro.chufariqi"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.chufariqi" 
                  type="date"
                  placeholder="出发日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="线路费用" prop="xianlufeiyong">
			<el-input-number v-model="ruleForm.xianlufeiyong" placeholder="线路费用" :readonly="ro.xianlufeiyong"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="报名人数" prop="xianluminge">
              <el-input v-model="xianluminge" placeholder="报名人数" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="报团金额" prop="baotuanjine">
			<el-input-number v-model="ruleForm.baotuanjine" placeholder="报团金额" :readonly="ro.baotuanjine"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="导游工号" prop="daoyougonghao">
            <el-input v-model="ruleForm.daoyougonghao" 
                placeholder="导游工号" clearable :disabled=" false  ||ro.daoyougonghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="ruleForm.yonghuzhanghao" 
                placeholder="用户账号" clearable :disabled=" false  ||ro.yonghuzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="用户姓名" prop="yonghuxingming">
            <el-input v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" clearable :disabled=" false  ||ro.yonghuxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="联系方式" prop="lianxifangshi">
            <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" clearable :disabled=" false  ||ro.lianxifangshi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="报团时间" prop="baotuanshijian">
              <el-date-picker
				  :disabled=" false  ||ro.baotuanshijian"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.baotuanshijian" 
                  type="date"
                  placeholder="报团时间">
              </el-date-picker> 
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
				xianlumingcheng : false,
				xianlutupian : false,
				chufariqi : false,
				xianlufeiyong : false,
				xianluminge : false,
				baotuanjine : false,
				daoyougonghao : false,
				yonghuzhanghao : false,
				yonghuxingming : false,
				lianxifangshi : false,
				baotuanshijian : false,
				ispay : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          xianlumingcheng: '',
          xianlutupian: '',
          chufariqi: '',
          xianlufeiyong: '',
          xianluminge: '',
          baotuanjine: '',
          daoyougonghao: '',
          yonghuzhanghao: '',
          yonghuxingming: '',
          lianxifangshi: '',
          baotuanshijian: '',
          ispay: '',
        },


        rules: {
          xianlumingcheng: [
          ],
          xianlutupian: [
          ],
          chufariqi: [
          ],
          xianlufeiyong: [
            { required: true, message: '线路费用不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          xianluminge: [
            { required: true, message: '报名人数不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          baotuanjine: [
            { required: true, message: '报团金额不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          daoyougonghao: [
          ],
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          lianxifangshi: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          baotuanshijian: [
          ],
          ispay: [
          ],
        },
		centerType: false,
      };
    },
    computed: {
		xianluminge : {
			get: function () {
				let c = this.ruleForm
				let a = c.xianlufeiyong*c.xianluminge
				this.ruleForm.xianluminge = a?Number(a).toFixed(2):0
				return a?Number(a).toFixed(2):0
			}
			
		},



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
      this.ruleForm.baotuanshijian = this.getCurDate()
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
            if(o=='xianlumingcheng'){
              this.ruleForm.xianlumingcheng = obj[o];
              this.ro.xianlumingcheng = true;
              continue;
            }
            if(o=='xianlutupian'){
              this.ruleForm.xianlutupian = obj[o].split(",")[0];
              this.ro.xianlutupian = true;
              continue;
            }
            if(o=='chufariqi'){
              this.ruleForm.chufariqi = obj[o];
              this.ro.chufariqi = true;
              continue;
            }
            if(o=='xianlufeiyong'){
              this.ruleForm.xianlufeiyong = obj[o];
              this.ro.xianlufeiyong = true;
              continue;
            }
            if(o=='xianluminge'){
              this.ruleForm.xianluminge = obj[o];
              this.ro.xianluminge = true;
              continue;
            }
            if(o=='baotuanjine'){
              this.ruleForm.baotuanjine = obj[o];
              this.ro.baotuanjine = true;
              continue;
            }
            if(o=='daoyougonghao'){
              this.ruleForm.daoyougonghao = obj[o];
              this.ro.daoyougonghao = true;
              continue;
            }
            if(o=='yonghuzhanghao'){
              this.ruleForm.yonghuzhanghao = obj[o];
              this.ro.yonghuzhanghao = true;
              continue;
            }
            if(o=='yonghuxingming'){
              this.ruleForm.yonghuxingming = obj[o];
              this.ro.yonghuxingming = true;
              continue;
            }
            if(o=='lianxifangshi'){
              this.ruleForm.lianxifangshi = obj[o];
              this.ro.lianxifangshi = true;
              continue;
            }
            if(o=='baotuanshijian'){
              this.ruleForm.baotuanshijian = obj[o];
              this.ro.baotuanshijian = true;
              continue;
            }
          }
          this.ruleForm.xianluminge = 0
		  this.ro.xianluminge = false;
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
                this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
            }
            if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
                this.ruleForm.yonghuxingming = json.yonghuxingming
            }
            if((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0){
                this.ruleForm.lianxifangshi = json.lianxifangshi
            }
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
        this.$http.get(`baotuanxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			if(this.ruleForm.xianluminge==0){
				this.$message.error('报名人数不能为空')
				return false
			}
			if(!this.ruleForm.xianluminge){
				this.$message.error("报名人数不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.xianluminge = obj.xianluminge - this.ruleForm.xianluminge
			if(obj.xianluminge<0){
				this.$message.error("报名人数不足");
				return
			}
      
			//this.$http.post(table+`/update`, obj).then(res => {});
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
						this.$http.get('baotuanxinxi/list', {
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
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								var table = localStorage.getItem('crossTable');

								obj.xianluminge = parseFloat(obj.xianluminge) - parseFloat(this.ruleForm.xianluminge)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`baotuanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.xianluminge = parseFloat(obj.xianluminge) - parseFloat(this.ruleForm.xianluminge)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`baotuanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      xianlutupianUploadChange(fileUrls) {
          this.ruleForm.xianlutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
