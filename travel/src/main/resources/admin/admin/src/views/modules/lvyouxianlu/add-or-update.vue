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
			<template >
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="线路名称" prop="xianlumingcheng">
					<el-input v-model="ruleForm.xianlumingcheng" placeholder="线路名称" clearable  :readonly="ro.xianlumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="线路名称" prop="xianlumingcheng">
					<el-input v-model="ruleForm.xianlumingcheng" placeholder="线路名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="upload" v-if="type!='info' && !ro.xianlutupian" label="线路图片" prop="xianlutupian">
					<file-upload
						tip="点击上传线路图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.xianlutupian?ruleForm.xianlutupian:''"
						@change="xianlutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="upload" v-else-if="ruleForm.xianlutupian" label="线路图片" prop="xianlutupian">
					<img v-if="ruleForm.xianlutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.xianlutupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xianlutupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="select" v-if="type!='info'" label="景点名称" prop="jingdianmingcheng">
					<el-select :disabled="ro.jingdianmingcheng" @change="jingdianmingchengChange" v-model="ruleForm.jingdianmingcheng" placeholder="请选择景点名称">
						<el-option
							v-for="(item,index) in jingdianmingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-else-if="ruleForm.jingdianmingcheng" label="景点名称" prop="jingdianmingcheng">
					<el-input v-model="ruleForm.jingdianmingcheng" placeholder="景点名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="景点类型" prop="jingdianleixing">
					<el-input v-model="ruleForm.jingdianleixing" placeholder="景点类型" clearable  :readonly="ro.jingdianleixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="景点类型" prop="jingdianleixing">
					<el-input v-model="ruleForm.jingdianleixing" placeholder="景点类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="景点位置" prop="jingdianweizhi">
					<el-input v-model="ruleForm.jingdianweizhi" placeholder="景点位置" clearable  :readonly="ro.jingdianweizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="景点位置" prop="jingdianweizhi">
					<el-input v-model="ruleForm.jingdianweizhi" placeholder="景点位置" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" clearable  :readonly="ro.qidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="途径路段" prop="tujingluduan">
					<el-input v-model="ruleForm.tujingluduan" placeholder="途径路段" clearable  :readonly="ro.tujingluduan"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="途径路段" prop="tujingluduan">
					<el-input v-model="ruleForm.tujingluduan" placeholder="途径路段" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" clearable  :readonly="ro.zhongdian"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="线路费用" prop="xianlufeiyong">
					<el-input-number v-model="ruleForm.xianlufeiyong" placeholder="线路费用" :readonly="ro.xianlufeiyong"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="线路费用" prop="xianlufeiyong">
					<el-input v-model="ruleForm.xianlufeiyong" placeholder="线路费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="报团名额" prop="baotuanminge">
					<el-input v-model.number="ruleForm.baotuanminge" placeholder="报团名额" clearable  :readonly="ro.baotuanminge"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="报团名额" prop="baotuanminge">
					<el-input v-model="ruleForm.baotuanminge" placeholder="报团名额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="date" v-if="type!='info'" label="出发日期" prop="chufariqi">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.chufariqi" 
						type="datetime"
						:readonly="ro.chufariqi"
                        :picker-options="chufariqiPickerOptions"
						placeholder="出发日期"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-else-if="ruleForm.chufariqi" label="出发日期" prop="chufariqi">
					<el-input v-model="ruleForm.chufariqi" placeholder="出发日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="交通方式" prop="jiaotongfangshi">
					<el-input v-model="ruleForm.jiaotongfangshi" placeholder="交通方式" clearable  :readonly="ro.jiaotongfangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="交通方式" prop="jiaotongfangshi">
					<el-input v-model="ruleForm.jiaotongfangshi" placeholder="交通方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="导游工号" prop="daoyougonghao">
					<el-input v-model="ruleForm.daoyougonghao" placeholder="导游工号" clearable  :readonly="ro.daoyougonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="导游工号" prop="daoyougonghao">
					<el-input v-model="ruleForm.daoyougonghao" placeholder="导游工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="导游姓名" prop="daoyouxingming">
					<el-input v-model="ruleForm.daoyouxingming" placeholder="导游姓名" clearable  :readonly="ro.daoyouxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="导游姓名" prop="daoyouxingming">
					<el-input v-model="ruleForm.daoyouxingming" placeholder="导游姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="type!='info'"  label="线路详情" prop="xianluxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.xianluxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else-if="ruleForm.xianluxiangqing" label="线路详情" prop="xianluxiangqing">
                    <span :style='{"border":"2px solid #c8c8c8","padding":"0 20px","color":"inherit","background":"none","display":"inline-block","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"350px","fontWeight":"500"}' v-html="ruleForm.xianluxiangqing"></span>
                </el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="type!='info'"  label="导游介绍" prop="gerenlvli">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.gerenlvli" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else-if="ruleForm.gerenlvli" label="导游介绍" prop="gerenlvli">
                    <span :style='{"border":"2px solid #c8c8c8","padding":"0 20px","color":"inherit","background":"none","display":"inline-block","width":"auto","fontSize":"14px","lineHeight":"40px","minWidth":"350px","fontWeight":"500"}' v-html="ruleForm.gerenlvli"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"flex-start"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				xianlumingcheng : false,
				xianlutupian : false,
				jingdianmingcheng : false,
				jingdianleixing : false,
				jingdianweizhi : false,
				qidian : false,
				tujingluduan : false,
				zhongdian : false,
				xianlufeiyong : false,
				baotuanminge : false,
				chufariqi : false,
				jiaotongfangshi : false,
				xianluxiangqing : false,
				daoyougonghao : false,
				daoyouxingming : false,
				lianxifangshi : false,
				gerenlvli : false,
				thumbsupnum : false,
				crazilynum : false,
				discussnum : false,
				storeupnum : false,
			},
			
			
			ruleForm: {
				xianlumingcheng: '',
				xianlutupian: '',
				jingdianmingcheng: '',
				jingdianleixing: '',
				jingdianweizhi: '',
				qidian: '',
				tujingluduan: '',
				zhongdian: '',
				xianlufeiyong: '',
				baotuanminge: '',
				chufariqi: '',
				jiaotongfangshi: '',
				xianluxiangqing: '',
				daoyougonghao: '',
				daoyouxingming: '',
				lianxifangshi: '',
				gerenlvli: '',
			},
		
			jingdianmingchengOptions: [],

            chufariqiPickerOptions: {
                disabledDate(time) {
                    return time.getTime() < Date.now() - 8.64e7;
                }
            },
			
			rules: {
				xianlumingcheng: [
					{ required: true, message: '线路名称不能为空', trigger: 'blur' },
				],
				xianlutupian: [
				],
				jingdianmingcheng: [
					{ required: true, message: '景点名称不能为空', trigger: 'blur' },
				],
				jingdianleixing: [
				],
				jingdianweizhi: [
					{ required: true, message: '景点位置不能为空', trigger: 'blur' },
				],
				qidian: [
				],
				tujingluduan: [
				],
				zhongdian: [
				],
				xianlufeiyong: [
					{ required: true, message: '线路费用不能为空', trigger: 'blur' },
					{ validator: validateNumber, trigger: 'blur' },
				],
				baotuanminge: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				chufariqi: [
				],
				jiaotongfangshi: [
				],
				xianluxiangqing: [
				],
				daoyougonghao: [
				],
				daoyouxingming: [
				],
				lianxifangshi: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				gerenlvli: [
				],
				thumbsupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				crazilynum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				discussnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='xianlumingcheng'){
							this.ruleForm.xianlumingcheng = obj[o];
							this.ro.xianlumingcheng = true;
							continue;
						}
						if(o=='xianlutupian'){
							this.ruleForm.xianlutupian = obj[o];
							this.ro.xianlutupian = true;
							continue;
						}
						if(o=='jingdianmingcheng'){
							this.ruleForm.jingdianmingcheng = obj[o];
							this.ro.jingdianmingcheng = true;
							continue;
						}
						if(o=='jingdianleixing'){
							this.ruleForm.jingdianleixing = obj[o];
							this.ro.jingdianleixing = true;
							continue;
						}
						if(o=='jingdianweizhi'){
							this.ruleForm.jingdianweizhi = obj[o];
							this.ro.jingdianweizhi = true;
							continue;
						}
						if(o=='qidian'){
							this.ruleForm.qidian = obj[o];
							this.ro.qidian = true;
							continue;
						}
						if(o=='tujingluduan'){
							this.ruleForm.tujingluduan = obj[o];
							this.ro.tujingluduan = true;
							continue;
						}
						if(o=='zhongdian'){
							this.ruleForm.zhongdian = obj[o];
							this.ro.zhongdian = true;
							continue;
						}
						if(o=='xianlufeiyong'){
							this.ruleForm.xianlufeiyong = obj[o];
							this.ro.xianlufeiyong = true;
							continue;
						}
						if(o=='baotuanminge'){
							this.ruleForm.baotuanminge = obj[o];
							this.ro.baotuanminge = true;
							continue;
						}
						if(o=='chufariqi'){
							this.ruleForm.chufariqi = obj[o];
							this.ro.chufariqi = true;
							continue;
						}
						if(o=='jiaotongfangshi'){
							this.ruleForm.jiaotongfangshi = obj[o];
							this.ro.jiaotongfangshi = true;
							continue;
						}
						if(o=='xianluxiangqing'){
							this.ruleForm.xianluxiangqing = obj[o];
							this.ro.xianluxiangqing = true;
							continue;
						}
						if(o=='daoyougonghao'){
							this.ruleForm.daoyougonghao = obj[o];
							this.ro.daoyougonghao = true;
							continue;
						}
						if(o=='daoyouxingming'){
							this.ruleForm.daoyouxingming = obj[o];
							this.ro.daoyouxingming = true;
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
						if(o=='thumbsupnum'){
							this.ruleForm.thumbsupnum = obj[o];
							this.ro.thumbsupnum = true;
							continue;
						}
						if(o=='crazilynum'){
							this.ruleForm.crazilynum = obj[o];
							this.ro.crazilynum = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
				}
				





















			}
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.daoyougonghao!=''&&json.daoyougonghao) || json.daoyougonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.daoyougonghao = json.daoyougonghao
						this.ro.daoyougonghao = true;
					}
					if(((json.daoyouxingming!=''&&json.daoyouxingming) || json.daoyouxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.daoyouxingming = json.daoyouxingming
						this.ro.daoyouxingming = true;
					}
					if(((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxifangshi = json.lianxifangshi
						this.ro.lianxifangshi = true;
					}
					if(((json.gerenlvli!=''&&json.gerenlvli) || json.gerenlvli==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gerenlvli = json.gerenlvli
						this.ro.gerenlvli = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/remenjingdian/jingdianmingcheng`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.jingdianmingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			jingdianmingchengChange () {
				this.$http({
					url: `follow/remenjingdian/jingdianmingcheng?columnValue=`+ this.ruleForm.jingdianmingcheng,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.jingdianleixing){
							this.ruleForm.jingdianleixing = data.data.jingdianleixing
						}
						if(data.data.jingdianweizhi){
							this.ruleForm.jingdianweizhi = data.data.jingdianweizhi
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `lvyouxianlu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.xianluxiangqing = this.ruleForm.xianluxiangqing.replace(reg,'../../../travel/upload');
        this.ruleForm.gerenlvli = this.ruleForm.gerenlvli.replace(reg,'../../../travel/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {


	if(this.ruleForm.xianlutupian!=null) {
		this.ruleForm.xianlutupian = this.ruleForm.xianlutupian.replace(new RegExp(this.$base.url,"g"),"");
	}




















var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "lvyouxianlu/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `lvyouxianlu/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `lvyouxianlu/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    xianlutupianUploadChange(fileUrls) {
	    this.ruleForm.xianlutupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #999;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 160px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 160px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #c8c8c8;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 2px solid #c8c8c8;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #c8c8c8;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #c8c8c8;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
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
	  	  border: 2px solid #c8c8c8;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 600;
	  	  object-fit: cover;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #c8c8c8;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 600;
	  	  object-fit: cover;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #c8c8c8;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 600;
	  	  object-fit: cover;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #c8c8c8;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				padding: 0 30px;
				margin: 0px 20px 0 0;
				color: #fff;
				display: inline-block;
				font-size: 14px;
				line-height: 24px;
				border-radius: 4px;
				outline: none;
				background: #ffc054;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 30px;
				margin: 0px 20px 0 0;
				outline: none;
				color: #fff;
				background: #ffc054;
				width: auto;
				font-size: 14px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 30px;
				margin: 0px 20px 0 0;
				outline: none;
				color: #fff;
				background: #ffc054;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 30px;
				margin: 0px 20px 0 0;
				color: #fff;
				background: #ffc054;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 30px;
				margin: 0px 20px 0 0;
				color: #fff;
				background: #ffc054;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				transform: scale(0.9);
				opacity: 0.8;
			}
</style>
