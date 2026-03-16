<template>
	<div class="main-containers">
		<div class="body-containers" :style='{"minHeight":"100vh","padding":"200px 0 0","margin":"0","position":"relative","background":"#fff"}'>
		<div class="top-container" :style='{"boxShadow":"none","padding":"0 20px","alignItems":"center","display":"flex","justifyContent":"flex-end","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20231217/ae9a047f4d5d469a81c5ac2713a2e4c4.png)","width":"100%","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"200px","zIndex":"1002"}'>
			<!-- info -->
			<div :style='{"display":"block"}'>
			  <span :style='{"padding":"0 0 0 40px","color":"#000","top":"0","left":"0","lineHeight":"140px","fontSize":"34px","position":"absolute","float":"left","fontWeight":"bold"}'>西北旅游服务平台</span>
			</div>
			<!-- weather -->
			<div class="weather" :style='{"padding":"0 20px 0 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
				<div :style='{"padding":"0 4px","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{weather.city}}</div>
				<div :style='{"padding":"0 4px","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{weather.tem}}°</div>
				<div :style='{"padding":"0 4px","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{weather.wea}}</div>
				<div :style='{"padding":"0 4px","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{weather.win}}</div>
				<div :style='{"padding":"0 4px","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{weather.win_speed}}</div>
			</div>
			<!-- time -->
			<div :style='{"padding":"0 20px 0 0","fontSize":"18px","lineHeight":"1","color":"#DF847F","fontWeight":"500"}'>{{times}}</div>
			
			<div v-if="false" :style='{"color":"#666","margin":"0 10px","fontSize":"14px"}'>0753-1234567</div>
			
			<div id="search" class="search" :style='{"margin":"0 10px","flexWrap":"wrap","background":"#fff","display":"none","height":"auto"}'>
				<div :style='{"margin":"0 10px 0 0"}' class="select">
					<el-select v-model="queryIndex">
						<el-option v-for="(item,index) in queryList" :key="index" :label="item.queryName" :value="index"></el-option>
					</el-select>
				</div>
				<div :style='{"margin":"0 10px 0 0"}' class="input" v-if="queryIndex==0">
					<el-input v-model="remenjingdianjingdianmingcheng" placeholder="景点名称"></el-input>
				</div>
				<div :style='{"margin":"0"}' class="btn" v-if="queryIndex==0">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' type="primary" @click="search('remenjingdian')">
						<span class="icon iconfont icon-fangdajing07" :style='{"color":"rgba(255, 255, 255, 1)","margin":"0 4px 0 0","fontSize":"14px"}'></span>
						搜索
					</el-button>
				</div>
			</div>
			<img v-if="headportrait&&Token" :style='{"width":"50px","margin":"0 20px 0 0","borderRadius":"50%","height":"50px","order":"5"}' :src="headportrait?baseUrl + headportrait:require('@/assets/avator.png')">
			<div v-if="Token" :style='{"padding":"0 20px 0 0","color":"#DF847F","fontSize":"18px","lineHeight":"32px","fontWeight":"500","height":"32px","order":"6"}'>{{username}}</div>
			<div v-if="Token && notAdmin" :style='{"padding":"0 20px 0 0","color":"#DF847F","fontSize":"18px","lineHeight":"32px","fontWeight":"500","height":"32px","order":"7"}' @click="goMenu('/index/center')">个人中心</div>
			<el-button v-if="!Token" @click="toLogin()" :style='{"border":"none","padding":"0 20px 0 0","margin":"0 0px","color":"#DF847F","borderRadius":"0","background":"none","display":"inline-block","fontSize":"18px","lineHeight":"32px","fontWeight":"500","height":"32px","order":"1"}'>登录/注册</el-button>
			<el-button v-if="Token" @click="logout" :style='{"border":"none","padding":"0 20px 0 0","margin":"0 0px","color":"#DF847F","borderRadius":"0","background":"none","display":"inline-block","fontSize":"18px","lineHeight":"32px","fontWeight":"500","height":"32px","order":"2"}'>退出</el-button>
		</div>


			<div class="menu-preview" :style='{"padding":"0 0","borderColor":"#ADADAD","top":"140px","left":"0","background":"none","borderWidth":"2px 0 0","width":"100%","position":"absolute","borderStyle":"solid","height":"auto","zIndex":"1005"}'>
			<el-scrollbar wrap-class="scrollbar-wrapper-horizontal">
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","background":"none","display":"flex","position":"relative"}' :default-active="activeMenu" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<div class="userinfo" :style='{"width":"84px","padding":"6px 10px 0","display":"none","height":"auto"}'>
					  <el-image :style='{"width":"100%","objectFit":"cover","borderRadius":"20px","display":"block","height":"32px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					  <div :style='{"fontSize":"12px","lineHeight":"1.5","color":"#333","textAlign":"center"}'>nickname</div>
					</div>
					<el-menu-item class="home" index="/index/home" @click.native="goMenu('/index/home')">
						<span :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"inherit","height":"56px"}' class="icon iconfont icon-shouye-zhihui"></span>
						<span :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"inherit","color":"inherit","height":"56px"}'>系统首页</span>
					</el-menu-item>
					<el-menu-item class="item" v-for="(menu, index) in menuList" :index="menu.url" :key="index" @click.native="goMenu(menu.url)">
						<i :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"inherit","height":"56px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"inherit","color":"inherit","height":"56px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item class="user" index="/index/center" v-if="Token && notAdmin" @click.native="goMenu('/index/center')">
						<span :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"14px","height":"56px"}' class="icon iconfont icon-shouye-zhihui"></span>
						<span :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"14px","color":"inherit","height":"56px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</el-scrollbar>
			</div>



			<div :style='{"width":"100%","margin":"0 auto","background":"#fff","height":"auto"}'>
			  <div class="swiper21" :style='{"width":"100%","height":"auto"}'>
			    <div class="swiper-container mySwiper21">
			      <div class="swiper-wrapper">
			        <div class="swiper-slide" v-for="item in carouselList" :key="item.id">
			          <div :style='{"width":"100%","height":"auto"}'>
			            <el-image @click="carouselClick(item.url)" :style='{"objectFit":"cover","width":"100%","height":"600px"}' :src="baseUrl + item.value" fit="cover"></el-image>
			          </div>
			        </div>
			      </div>
			      <div class="swiper-button-prev" :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}'>
			        <span class="icon iconfont icon-jiantou39" :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'></span>
			      </div>
			      <div class="swiper-button-next" :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}'>
			        <span class="icon iconfont icon-jiantou18" :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'></span>
			      </div>
			    </div>
			  </div>
			  <div class="swiper22" :style='{"width":"100%","height":"auto"}'>
			    <div class="swiper-container mySwiper22">
			      <div class="swiper-wrapper">
			        <div class="swiper-slide" v-for="item in carouselList" :key="item.id">
			          <div>
			            <el-image :style='{"objectFit":"cover","width":"100%","height":"100px"}' :src="baseUrl + item.value" fit="cover"></el-image>
			          </div>
			        </div>
			      </div>
			      <div class="swiper-button-prev" :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}'>
			        <span class="icon iconfont icon-jiantou39" :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'></span>
			      </div>
			      <div class="swiper-button-next" :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}'>
			        <span class="icon iconfont icon-jiantou18" :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'></span>
			      </div>
			    </div>
			  </div>
			</div>

			<router-view id="scrollView"></router-view>
			
			<div class="bottom-preview" :style='{"width":"100%","height":"auto"}'>
				<div :style='{"minHeight":"120px","width":"100%","padding":"20px","overflow":"hidden","background":"#123","height":"auto"}'><div v-html="bottomContent"></div></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
import Swiper from "swiper";
import axios from 'axios'

export default {
    data() {
		return {
		queryList:[
		  {
			  queryName:"景点名称",
		  },
		],
		queryIndex: 0,
		remenjingdianjingdianmingcheng: '',
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","好友申请"],"appFrontIcon":"cuIcon-list","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除","审核"],"menu":"导游","menuJump":"列表","tableName":"daoyou"}],"menu":"导游管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除"],"menu":"景点类型","menuJump":"列表","tableName":"jingdianleixing"}],"menu":"景点类型管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即购买"],"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除","查看评论"],"menu":"热门景点","menuJump":"列表","tableName":"remenjingdian"}],"menu":"热门景点管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","日销售金额","景点销售额","销售类型统计","首页总数","首页统计"],"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除","日销售金额","景点销售额","销售类型统计","首页总数","首页统计"],"menu":"门票订单","menuJump":"列表","tableName":"menpiaodingdan"}],"menu":"门票订单管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"客房类型","menuJump":"列表","tableName":"kefangleixing"}],"menu":"客房类型管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预订"],"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除","查看评论"],"menu":"酒店信息","menuJump":"列表","tableName":"jiudianxinxi"}],"menu":"酒店信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","酒店业绩统计","首页总数","首页统计"],"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除","酒店业绩统计","客房业绩统计","首页总数","首页统计"],"menu":"酒店预订","menuJump":"列表","tableName":"jiudianyuding"}],"menu":"酒店预订管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预约"],"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除","查看评论","新增"],"menu":"美食餐厅","menuJump":"列表","tableName":"meishicanting"}],"menu":"美食餐厅管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","餐厅预约类型","首页总数","首页统计"],"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除","审核","餐厅预约类型","首页总数","首页统计"],"menu":"餐厅预约","menuJump":"列表","tableName":"cantingyuyue"}],"menu":"餐厅预约管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-paint","buttons":["新增","查看","修改","删除"],"menu":"线路类型","menuJump":"列表","tableName":"xianluleixing"}],"menu":"线路类型管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","报团加入"],"appFrontIcon":"cuIcon-wenzi","buttons":["查看","修改","删除","查看评论"],"menu":"旅游线路","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","线路报名人数","首页总数","首页统计"],"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除","线路报名人数","首页总数","首页统计"],"menu":"报团信息","menuJump":"列表","tableName":"baotuanxinxi"}],"menu":"报团信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除","查看评论"],"menu":"旅游攻略","menuJump":"列表","tableName":"lvyougonglve"}],"menu":"旅游攻略管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-group","buttons":["新增","查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"旅游资讯","tableName":"news"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"旅游资讯分类","tableName":"newstype"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"友情链接","tableName":"friendlink"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","好友申请"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","私聊","好友申请"],"menu":"用户列表","menuJump":"列表","tableName":"yonghu"}],"menu":"用户模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即购买"],"appFrontIcon":"cuIcon-pic","buttons":["查看","查看评论","立即购买"],"menu":"热门景点列表","menuJump":"列表","tableName":"remenjingdian"}],"menu":"热门景点模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预订"],"appFrontIcon":"cuIcon-vip","buttons":["立即预订","查看评论","查看"],"menu":"酒店信息列表","menuJump":"列表","tableName":"jiudianxinxi"}],"menu":"酒店信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预约"],"appFrontIcon":"cuIcon-explore","buttons":["查看","查看评论","立即预约"],"menu":"美食餐厅列表","menuJump":"列表","tableName":"meishicanting"}],"menu":"美食餐厅模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","报团加入"],"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","报团加入"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论"],"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"旅游攻略列表","menuJump":"列表","tableName":"lvyougonglve"}],"menu":"旅游攻略模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","支付","日销售金额","景点销售额","销售类型统计","首页总数","首页统计"],"appFrontIcon":"cuIcon-addressbook","buttons":["查看","删除","支付"],"menu":"门票订单","menuJump":"列表","tableName":"menpiaodingdan"}],"menu":"门票订单管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","酒店业绩统计","首页总数","首页统计"],"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","支付"],"menu":"酒店预订","menuJump":"列表","tableName":"jiudianyuding"}],"menu":"酒店预订管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","餐厅预约类型","首页总数","首页统计"],"appFrontIcon":"cuIcon-similar","buttons":["删除","查看"],"menu":"餐厅预约","menuJump":"列表","tableName":"cantingyuyue"}],"menu":"餐厅预约管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","线路报名人数","首页总数","首页统计"],"appFrontIcon":"cuIcon-list","buttons":["查看","删除","支付"],"menu":"报团信息","menuJump":"列表","tableName":"baotuanxinxi"}],"menu":"报团信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","查看评论"],"menu":"旅游攻略","menuJump":"列表","tableName":"lvyougonglve"}],"menu":"旅游攻略管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","好友申请"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","私聊","好友申请"],"menu":"用户列表","menuJump":"列表","tableName":"yonghu"}],"menu":"用户模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即购买"],"appFrontIcon":"cuIcon-pic","buttons":["查看","查看评论","立即购买"],"menu":"热门景点列表","menuJump":"列表","tableName":"remenjingdian"}],"menu":"热门景点模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预订"],"appFrontIcon":"cuIcon-vip","buttons":["立即预订","查看评论","查看"],"menu":"酒店信息列表","menuJump":"列表","tableName":"jiudianxinxi"}],"menu":"酒店信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预约"],"appFrontIcon":"cuIcon-explore","buttons":["查看","查看评论","立即预约"],"menu":"美食餐厅列表","menuJump":"列表","tableName":"meishicanting"}],"menu":"美食餐厅模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","报团加入"],"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","报团加入"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论"],"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"旅游攻略列表","menuJump":"列表","tableName":"lvyougonglve"}],"menu":"旅游攻略模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","报团加入"],"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除","查看评论"],"menu":"旅游线路","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路管理"},{"child":[{"allButtons":["新增","查看","修改","删除","支付","线路报名人数","首页总数","首页统计"],"appFrontIcon":"cuIcon-list","buttons":["查看","删除","线路报名人数","首页总数","首页统计"],"menu":"报团信息","menuJump":"列表","tableName":"baotuanxinxi"}],"menu":"报团信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"旅游资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","好友申请"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","私聊","好友申请"],"menu":"用户列表","menuJump":"列表","tableName":"yonghu"}],"menu":"用户模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即购买"],"appFrontIcon":"cuIcon-pic","buttons":["查看","查看评论","立即购买"],"menu":"热门景点列表","menuJump":"列表","tableName":"remenjingdian"}],"menu":"热门景点模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预订"],"appFrontIcon":"cuIcon-vip","buttons":["立即预订","查看评论","查看"],"menu":"酒店信息列表","menuJump":"列表","tableName":"jiudianxinxi"}],"menu":"酒店信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","立即预约"],"appFrontIcon":"cuIcon-explore","buttons":["查看","查看评论","立即预约"],"menu":"美食餐厅列表","menuJump":"列表","tableName":"meishicanting"}],"menu":"美食餐厅模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论","报团加入"],"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","报团加入"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"},{"child":[{"allButtons":["新增","查看","修改","删除","查看评论"],"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"旅游攻略列表","menuJump":"列表","tableName":"lvyougonglve"}],"menu":"旅游攻略模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"导游","tableName":"daoyou"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('frontUserid')
			},
			headportrait: localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'',
			Token: localStorage.getItem('frontToken'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('frontSessionTable')!='"users"',
			timer: '',
			// 时间
			times: '',
			// 天气
			weather: {},
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],
			bottomContent: '',
		}
    },
    created() {
		this.$nextTick(() => {
			// 获取时间
			this.setTimes()
		})
		// 获取天气
		this.getWeather()
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
        if(localStorage.getItem('frontToken') && localStorage.getItem('frontToken')!=null) {
			this.getSession()
        }
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';


		// banner
		setTimeout(()=>{
			let mySwiper22 = new Swiper(".mySwiper22", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"freeMode":true,"watchSlidesVisibility":true,"watchSlidesProgress":true,"loopedSlides":5,"slidesPerView":4,"spaceBetween":10})
			let option21 = {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"loopedSlides":5,"spaceBetween":10}
			option21.thumbs = {
				swiper: mySwiper22
			}
			new Swiper(".mySwiper21", option21)
		}, 500)

    },
    computed: {
		activeMenu() {
			const route = this.$route
			const {
				meta,
				path
			} = route
			// if st path, the sidebar will highlight the path you sete
			if (meta.activeMenu) {
				return meta.activeMenu
			}
			return path
		},
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('frontToken')
            if(arr[1]!='/index/home'){
            	var element = document.getElementById('scrollView');
            	var distance = element.offsetTop;
            	window.scrollTo( 0, distance )
            }else{
            	window.scrollTo( 0, 0 )
            }
        },
		headportrait(){
			this.$forceUpdate()
		},
    },
    methods: {
      search(tablename) {
        if (this.queryIndex == 0 && this.remenjingdianjingdianmingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.remenjingdianjingdianmingcheng}});
        }
      },
		// 获取当前时间
		setTimes() {
			setInterval(()=>{
				let d = new Date()
				this.times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds()
			},1000)
		},
		// 获取当前城市天气
		getWeather(){
			axios({
				method: 'get',
				url: 'http://v0.yiketianqi.com/free/day?appid=69475998&appsecret=rldbX1Zl'
			}).then(res => {
				this.weather = res.data
			})
		},

		async getSession() {
			await this.$http.get(`${localStorage.getItem('UserTableName')}/session`, {emulateJSON: true}).then(async res => {
				if (res.data.code == 0) {
					localStorage.setItem('sessionForm',JSON.stringify(res.data.data))
					localStorage.setItem('frontUserid', res.data.data.id);
					if(res.data.data.vip) {
						localStorage.setItem('vip', res.data.data.vip);
					}
					if(res.data.data.touxiang) {
						this.headportrait = res.data.data.touxiang
						localStorage.setItem('frontHeadportrait', res.data.data.touxiang);
					} else if(res.data.data.headportrait) {
						this.headportrait = res.data.data.headportrait
						localStorage.setItem('frontHeadportrait', res.data.data.headportrait);
					}
				}
			});
		},
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		// 轮播图跳转
		carouselClick(url) {
			if (url) {
				if (url.indexOf('https') != -1) {
					window.open(url)
				} else {
					this.$router.push(url)
				}
			}
		},
		goBackend() {
			localStorage.setItem('Token', localStorage.getItem('frontToken'));
			localStorage.setItem('role', localStorage.getItem('frontRole'));
			localStorage.setItem('sessionTable', localStorage.getItem('frontSessionTable'));
			localStorage.setItem('headportrait', localStorage.getItem('frontHeadportrait'));
			localStorage.setItem('userid', localStorage.getItem('frontUserid'));
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            this.$router.push(path);
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	  
	    & /deep/ .scrollbar-wrapper-vertical {
	      overflow-x: hidden;
	    }
	  
	    & /deep/ .scrollbar-wrapper-horizontal {
	      overflow-y: hidden;
	  
	      .el-scrollbar__view {
	        white-space: nowrap;
	      }
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				margin: 0 40px;
				color: #000;
				white-space: nowrap;
				display: flex;
				font-size: 16px;
				line-height: 60px;
				background: none;
				align-items: center;
				position: relative;
				list-style: none;
				height: 60px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home:hover {
				color: #fff;
				background: #DF847F;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home.is-active {
				color: #fff;
				background: #DF847F;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				margin: 0 40px;
				color: #000;
				white-space: nowrap;
				display: flex;
				font-size: 16px;
				line-height: 60px;
				background: none;
				align-items: center;
				position: relative;
				list-style: none;
				height: 60px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item:hover {
				color: #fff;
				background: #DF847F;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item.is-active {
				color: #fff;
				background: #DF847F;
			}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
        padding-bottom: 20px;
        width: 100%;
        margin-bottom: 10px;
        max-height: 300px;
        height: 300px;
        overflow-y: scroll;
        border: 1px solid #eeeeee;
        background: #fff;

        .left-content {
            float: left;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }

        .right-content {
            float: right;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }
    }

    .clear-float {
        clear: both;
    }

	.swiper21 .swiper-button-prev:after {
      display:none;
    }
    .swiper21 .swiper-button-next:after {
      display:none;
    }
    .swiper22 .swiper-button-prev:after {
      display:none;
    }
    .swiper22 .swiper-button-next:after {
      display:none;
    }
	
	.swiper22 .swiper-slide div {
				width: 100%;
				opacity: 0.4;
				height: auto;
			}
	
	.swiper22 .swiper-slide.swiper-slide-thumb-active div {
				opacity: 1;
			}

	
	// -------- search --------
	.main-containers .search .select /deep/ .el-input__inner {
				border: 0;
				border-radius: 4px;
				padding: 0 30px 0 10px;
				box-shadow: 0 0 6px rgba(64, 158, 255, .3);
				outline: none;
				color: rgba(64, 158, 255, 1);
				width: 180px;
				font-size: 14px;
				height: 44px;
			}
	
	.main-containers .search .input /deep/ .el-input__inner {
				border: 0;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: 0 0 6px rgba(64, 158, 255, .3);
				outline: none;
				color: rgba(64, 158, 255, 1);
				width: 180px;
				font-size: 14px;
				height: 44px;
			}
	// -------- search --------
	
	.main-containers .btn-service {
				border: 0;
				padding: 0 20px 0 0;
				margin: 0 0;
				color: #DF847F;
				background: none;
				font-weight: 500;
				width: auto;
				font-size: 18px;
				line-height: 32px;
				height: 32px;
				order: 4;
			}
	
	.main-containers .btn-service:hover {
				opacity: 0.7;
			}
	
	.main-containers .btn-shop {
				border: 0;
				padding: 0 20px 0 0;
				margin: 0 0px;
				color: #DF847F;
				background: none;
				font-weight: 500;
				width: auto;
				font-size: 18px;
				line-height: 32px;
				height: 32px;
				order: 3;
			}
	
	.main-containers .btn-shop:hover {
				opacity: 0.7;
			}
</style>
