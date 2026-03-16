<template>
	<div :style='{"width":"100%","padding":"0 20% 0 10%","margin":"10px auto","position":"relative","background":"none"}'>
	<el-button :style='{"border":"0","cursor":"pointer","padding":"0 30px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"0","background":"#DF847F","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">返回</el-button>
	<div :style='{"width":"100%","padding":"0 10px"}'>
		<div :style='{"width":"80%","margin":"20px auto","height":"auto"}'>
			<div :style='{"margin":"10px 0","color":"#DF847F","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231220/e54f6cd4929f4d00b2ead8e5a5991d16.png)","fontSize":"26px","lineHeight":"54px","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","fontWeight":"bold"}'>旅游资讯</div>
		</div>
		<div :style='{"width":"100%","padding":"0 20px","position":"relative","flexWrap":"wrap","display":"flex"}'>
			<div  :style='{"color":"#000","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"20px","fontWeight":"bold","order":"1"}'>{{detail.title}}</div>
			
			<div :style='{"width":"100%","alignItems":"center","justifyContent":"center","display":"flex","order":"2"}'>
			  <div :style='{"padding":"0"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 6px 0 0","lineHeight":"1.5","fontSize":"13px","color":"#9E9E9E"}'></span>
			    <span :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"13px"}'>发布时间：{{detail.addtime}}</span>
			  </div>
			  <div :style='{"padding":"0","display":"none"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.name}}</span>
			  </div>
			  <div :style='{"padding":"0","display":"none"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","display":"none"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","display":"none"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.clicknum}}</span>
			  </div>
			</div>
			<div class="operate" :style='{"width":"50%","padding":"10px 0","alignItems":"center","justifyContent":"flex-start","display":"flex","order":"5"}'>
				<div @click="zanClick" :style='{"border":"1px solid #D8D8D8","padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-guanzhu-zhihui" :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#B4B4B4"}'></span>
					<span :style='{"color":"#B4B4B4","lineHeight":"20px","fontSize":"14px"}'>{{zanType?'取消赞':'点赞'}}</span>
				</div>
				<div @click="collectClick" :style='{"border":"1px solid #D8D8D8","padding":"0 15px","margin":"0 0 0 10px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#B4B4B4"}'></span>
					<span :style='{"color":"#B4B4B4","lineHeight":"20px","fontSize":"14px"}'>{{collectType?'取消收藏':'收藏'}}</span>
				</div>
			</div>
			
			<div :style='{"padding":"20px 0","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"16px","height":"auto","order":"4"}' class="content-detail" v-html="detail.content"></div>
		</div>
		<!-- option -->
		<div :style='{"width":"50%","padding":"0 20px","margin":"-30px 0 20px auto","justifyContent":"flex-end","display":"flex","height":"auto"}'>
		  <div :style='{"cursor":"pointer","padding":"0 10px","color":"#fff","background":"#DF847F","lineHeight":"20px","fontSize":"14px","zIndex":"999"}' @click="prepDetailClick">上一篇：prev</div>
		  <div :style='{"cursor":"pointer","padding":"0 10px","margin":"0 0 0 10px","color":"#fff","background":"#8FD5E7","lineHeight":"20px","fontSize":"14px","zIndex":"999"}' @click="nextDetailClick">下一篇：next</div>
		</div>

		<!-- 热门文章 -->
		<div class="hot" :style='{"border":"2px solid #DF847F","boxShadow":"none","top":"0","background":"#fff","width":"15%","position":"absolute","right":"5%","height":"auto"}'>
		  <div :style='{"color":"#DF847F","textAlign":"center","background":"none","width":"100%","lineHeight":"44px","fontSize":"26px","fontWeight":"bold"}'>热门文章</div>
		  <div :style='{"width":"100%","padding":"0 10px","background":"#fff","height":"auto"}'>
		    <div v-for="item in hotList" :key="item.id" :style='{"width":"100%","padding":"5px 5px 0","background":"#fff","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"width":"100%","objectFit":"cover","borderRadius":"15px","display":"block","height":"150px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"4px 5px 0","lineHeight":"2","fontSize":"16px","color":"#000","textAlign":"center"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 5px","lineHeight":"1.5","fontSize":"14px","color":"#909090","textAlign":"center"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
		<!-- 热门标签 -->
		<div class="tags" :style='{"border":"1px solid #C7C7C7","boxShadow":"none","margin":"0 0 0 -0","top":"0","left":"0","background":"#fff","width":"10%","position":"absolute","height":"auto"}'>
		  <div :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"#fff","textAlign":"center","background":"#DF847F"}'>热门标签</div>
		  <div :style='{"padding":"5px ","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <div v-for="(item,index) in categoryList" :key="index" :style='{"width":"calc(100% / 3)","lineHeight":"28px","fontSize":"14px","color":"#9E9E9E","textAlign":"center"}'>{{ item.typename }}</div>
		  </div>
		</div>
		<!-- 推荐文章 -->
		<div class="news" :style='{"width":"100%","background":"#fff","height":"auto"}'>
		  <div :style='{"border":"1px solid #DF847F","padding":"0 20px","color":"#DF847F","background":"none","borderWidth":"5px 1px 1px","width":"100%","lineHeight":"54px","fontSize":"22px","fontWeight":"bold"}'>推荐文章</div>
		  <div :style='{"width":"100%","padding":"20px","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
		    <div v-for="item in recommendList" :key="item.id" :style='{"border":"1px solid #DF847F","width":"calc(20% - 10px)","padding":"20px 20px ","background":"#fff","height":"auto"}' @click="toDetail(item.id)">
		      <img :style='{"width":"100%","objectFit":"cover","borderRadius":"80px","display":"block","height":"190px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"0 10px","lineHeight":"3","fontSize":"16px","color":"#000","textAlign":"center","fontWeight":"bold"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 10px","lineHeight":"1.5","fontSize":"14px","color":"#909090","textAlign":"center"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				id: 0,
				detail: {},
				zanType: false,
				zanForm: {},
				collectType:false,
				collectForm: {},
				baseUrl:'',
				hotList: [],
				recommendList: [],
				categoryList: [],
				currentIndex: 0,
				allList: []
			}
		},
		created() {
			this.id = this.$route.query.id
			this.baseUrl = this.$config.baseUrl;
			this.getCategoryList()
			this.getDetail()
			this.getNewsList()
			this.getHotList()
			this.getRecommendList()
		},
		watch:{
			$route(newValue) {
				this.id = this.$route.query.id
			    this.getDetail()
			}
		},
		methods: {
			  backClick() {
				  history.back()
			  },
			getNewsList() {
				let params = {page:1, limit: 100,sort:'addtime',order:'desc'};
				this.$http.get('news/list', {params: params}).then(res => {
					if (res.data.code == 0) {
						for(let x in res.data.data.list){
							if(res.data.data.list[x].id == this.id){
								this.currentIndex = Number(x)
								break
							}
						}
						this.allList = res.data.data.list
					}
				});
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data;
					}
				});
			},
			// 获取热门列表
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			// 获取推荐列表
			getRecommendList(){
				let url = 'news/autoSort'
				if(localStorage.getItem('frontToken')){
					url = 'news/autoSort2'
				}
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get(url, {params: params}).then(res => {
					if (res.data.code == 0) {
						this.recommendList = res.data.data.list;
					}
				});
			},
			// 跳转详情
			toDetail(id){
				this.$router.push({path: '/index/newsDetail', query: {id: id}});
			},
			getDetail(){
				this.$http.get(`news/detail/${this.id}`,{}).then(res=>{
					if(res.data&&res.data.code==0){
						this.detail = res.data.data
						window.scrollTo(0, 100)
						this.getZan()
						this.getCollect()
					}
				})
			},
			getZan() {
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 21,
						userid: localStorage.getItem('frontUserid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.zanType = true
							this.zanForm = res.data.data.list[0]
						}else{
							this.zanType = false
						}
					}
				})
			},
			getCollect(){
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 1,
						userid: localStorage.getItem('frontUserid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.collectType = true
							this.collectForm = res.data.data.list[0]
						}else{
							this.collectType = false
						}
					}
				})
			},
			zanClick() {
				if(this.zanType){
					this.$http.post('storeup/delete', [this.zanForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.thumbsupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 21,
						tablename: 'news',
						userid: localStorage.getItem('frontUserid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('点赞成功')
							this.detail.thumbsupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}
			},
			collectClick(){
				if(this.collectType){
					this.$http.post('storeup/delete', [this.collectForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.storeupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getCollect()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 1,
						tablename: 'news',
						userid: localStorage.getItem('frontUserid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.detail.storeupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.$message.success('收藏成功')
							this.getCollect()
						}
					})
				}
			},
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	.section-content {
		margin-top: 30px;
	}
	.content-title {
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	.content-sub-title {
		text-align: center;
		margin-top: 20px;
		color: #888888;
		font-size: 14px;
	}
	.operate{
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 0 40px;
	}
</style>