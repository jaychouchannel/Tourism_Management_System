<template>
<div>
	<div :style='{"padding":"20px 20px 60px","margin":"10px auto","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20231217/d400927926594c4db68c914d1fab2fc3.png)","width":"90%","backgroundSize":"100% 40%","backgroundPosition":"bottom center","backgroundRepeat":"no-repeat"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'>'" :style='{"fontSize":"16px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="news-preview-pv" :style='{"width":"100%","padding":"0 5%","margin":"10px auto","position":"relative","background":"none"}'>
		<el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"padding":"10px","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
			<el-form-item :style='{"margin":"0 10px"}'>
				<el-input v-model="title" placeholder="标题"></el-input>
			</el-form-item>
			<el-button type="primary" @click="getNewsList(1)" :style='{"cursor":"pointer","border":"1px solid #DF847F","padding":"0px 15px","margin":"0 10px 0 0","outline":"none","color":"#DF847F","borderRadius":"30px","background":"none","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}'>
				<span class="icon iconfont icon-chakan14" :style='{"color":"#DF847F","margin":"0 6px 0 0","fontSize":"14px"}'></span>
				搜索
			</el-button>
		</el-form>
		
		<!-- category -->
		<div class="category" :style='{"width":"100%","padding":"10px","background":"#fff","justifyContent":"center","display":"flex","height":"auto"}'>
		  <div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
		  <div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
		</div>
	
				<!-- 样式一 -->
		<div class="list1 index-pv1" :style='{"width":"85%","padding":"0 10px","flexWrap":"wrap","background":"#fff","display":"flex","height":"auto"}'>
			<div :style='{"border":"2px solid #DF847F","padding":"20px 0 0","margin":"10px 5px","overflow":"hidden","borderRadius":"10px","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(25% - 10px)","position":"relative","justifyContent":"center","height":"auto"}' v-for="item in newsList" :key="item.id" @click="toNewsDetail(item)" class="list-item animation-box">
				<el-image :style='{"width":"calc(100% - 30px)","objectFit":"cover","borderRadius":"130px","display":"block","height":"300px","order":"1"}' :src="baseUrl + item.picture" :fit="fill"></el-image>
				<div :style='{"padding":"5px 10px 0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","textAlign":"center","width":"100%","lineHeight":"2","fontSize":"16px","textOverflow":"ellipsis","fontWeight":"bold","order":"2"}' class="title">{{item.title}}</div>
				<div :style='{"padding":"0 10px 5px","whiteSpace":"nowrap","overflow":"hidden","color":"#000","textAlign":"center","width":"100%","lineHeight":"2","fontSize":"14px","textOverflow":"ellipsis","order":"3"}' class="introduction">{{item.introduction}}</div>
				<div :style='{"width":"100%","padding":"0 10px","textAlign":"center","background":"#DF847F","order":"8"}'>
				  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 4px 0 0","lineHeight":"40px","fontSize":"14px","color":"#fff"}'></span>
				  <span :style='{"color":"#fff","lineHeight":"40px","fontSize":"14px"}'>{{item.addtime}}</span>
				</div>
				<div :style='{"padding":"0 10px 5px","order":"7"}'>
				  <span class="icon iconfont icon-geren16" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#858585"}'></span>
				  <span :style='{"color":"#858585","lineHeight":"1.5","fontSize":"14px"}'>{{item.name}}</span>
				</div>
				<div :style='{"padding":"0 10px 5px","order":"4"}'>
				  <span class="icon iconfont icon-zan10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#858585"}'></span>
				  <span :style='{"color":"#858585","lineHeight":"1.5","fontSize":"14px"}'>{{item.thumbsupnum}}</span>
				</div>
				<div :style='{"padding":"0 10px 5px","order":"5"}'>
				  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#858585"}'></span>
				  <span :style='{"color":"#858585","lineHeight":"1.5","fontSize":"14px"}'>{{item.storeupnum}}</span>
				</div>
				<div :style='{"padding":"0 10px 5px","order":"6"}'>
				  <span class="icon iconfont icon-chakan9" :style='{"margin":"0 4px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#858585"}'></span>
				  <span :style='{"color":"#858585","lineHeight":"1.5","fontSize":"14px"}'>{{item.clicknum}}</span>
				</div>
			</div>
		</div>
				
				
				
				
				
				
				
				
				
		<el-pagination
		  background
		  id="pagination" class="pagination"
		  :pager-count="7"
		  :page-size="pageSize"
		  :page-sizes="pageSizes"
		  prev-text="<"
		  next-text=">"
		  :hide-on-single-page="true"
		  :layout='["total","prev","pager","next","sizes"].join()'
		  :total="total"
		  :style='{"padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"1200px","fontWeight":"500"}'
		  @current-change="curChange"
		  @prev-click="prevClick"
		  @next-click="nextClick"
		></el-pagination>

		<!-- 热门信息 -->
		<div class="hot" :style='{"border":"2px solid #DF847F","boxShadow":"none","top":"170px","flexWrap":"wrap","background":"#fff","display":"flex","width":"13.5%","position":"absolute","right":"5%","height":"auto"}'>
		  <div :style='{"border":"1px solid #DF847F","margin":"0 auto","color":"#DF847F","textAlign":"center","background":"none","borderWidth":"0 0 2px","width":"calc(100% - 40px)","lineHeight":"54px","fontSize":"26px","fontWeight":"bold"}'>热门信息</div>
		  <div :style='{"width":"100%","padding":"0 20px","background":"#fff","height":"auto"}'>
		    <div v-for="item in hotList" :key="item.id" :style='{"width":"100%","padding":"10px 0","background":"#fff","height":"auto"}' @click="toNewsDetail(item)">
		      <img :style='{"width":"100%","objectFit":"cover","borderRadius":"15px","display":"block","height":"150px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"4px 5px 0","lineHeight":"2","fontSize":"16px","color":"#000","textAlign":"center","fontWeight":"bold"}'>{{ item.title }}</div>
		      <div :style='{"padding":"0 5px","lineHeight":"1.5","fontSize":"12px","color":"#909090","textAlign":"center"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
		<!-- 最新动态 -->
		<div class="news" :style='{"width":"85%","flexWrap":"wrap","background":"#fff","display":"flex","height":"auto"}'>
		  <div :style='{"border":"1px solid #DF847F","padding":"0 20px","color":"#DF847F","background":"none","borderWidth":"10px 2px 2px","width":"100%","lineHeight":"60px","fontSize":"26px","fontWeight":"bold"}'>最新动态</div>
		  <div :style='{"padding":"20px 0","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <div v-for="item in recommendList" :key="item.id" :style='{"border":"1px solid #DF847F","padding":"20px 0 0","margin":"10px","alignItems":"center","background":"#fff","flexDirection":"column","display":"flex","width":"calc(20% - 20px)","height":"auto"}' @click="toNewsDetail(item)">
		      <img :style='{"width":"calc(100% - 30px)","objectFit":"cover","borderRadius":"130px","display":"block","height":"190px"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"0 10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"2","fontSize":"16px","fontWeight":"bold"}'>{{ item.title }}</div>
		      <div :style='{"width":"100%","padding":"0 10px","lineHeight":"2","fontSize":"14px","color":"#909090","textAlign":"center"}'>{{item.addtime}}</div>
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
				baseUrl: this.$config.baseUrl,
				breadcrumbItem: [
				  {
					name: '旅游资讯'
				  }
				],
				newsList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [10,20,30,50],
				totalPage: 1,
				layouts: '',
				title: '',
				categoryIndex: 0,
				categoryList: [],
				hotList: [],
				recommendList: [],
			}
		},
		created() {
			this.getCategoryList()
			this.getNewsList(1);
			this.getHotList()
			this.getRecommendList()
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getNewsList()
			},
			getNewsList(page) {
				let params = {page, limit: this.pageSize,sort:'addtime',order:'desc'};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						this.totalPage = res.data.data.totalPage;
					}
				});
			},
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
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
			curChange(page) {
				this.getNewsList(page);
			},
			prevClick(page) {
				this.getNewsList(page);
			},
			nextClick(page) {
				this.getNewsList(page);
			},
			toNewsDetail(item) {
				this.$router.push({path: '/index/newsDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 20px;
		color: #000;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #000;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #000;
		display: inline-block;
	}
	
	.news-wrap {
	  width: 1000px;
	  margin: 0 auto;
	}
	.news-item {
	  height: 200px;
	  width: auto;
	  margin-bottom: 30px;
	  cursor: pointer;
	}
	.news-item-text {
	  width: calc(100% - 215px);
	  display: inline-block;
	  vertical-align: top;
	  margin-left: 15px;
	}
	.news-item-text-title {
	  font-size: 16px;
	  margin-bottom: 15px;
	}
	.news-item-text-intro {
	  font-size: 14px;
	  color: #666;
	}
	
	.hide1 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide2 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide3 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 3;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(10deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: rotate(360deg) scale(0.8) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		
	#pagination.el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}
	
	#pagination.el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #DF847F;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #DF847F;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.news-preview-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #DF847F;
				border-radius: 40px;
				padding: 0 10px;
				margin: 0;
				outline: none;
				color: #333;
				width: 300px;
				font-size: 14px;
				line-height: 42px;
				height: 42px;
			}
	
	.news-preview-pv .category .item {
				cursor: pointer;
				border: 1px solid #C7C7C7;
				padding:  10px 30px 30px;
				margin: 0 10px 0 0;
				background-size: 100% 40%;
				color: #999;
				font-size: 14px;
				line-height: 36px;
				background-position: bottom center;
				border-radius: 10px;
				background-repeat: no-repeat;
				background: url(http://codegen.caihongy.cn/20231219/b1565a93d167425cb53a28e54ef4598c.png) #fff;
				width: auto;
				text-align: center;
			}
	
	.news-preview-pv .category .item:hover {
				background-repeat: no-repeat;
				background-size: 100% 40%;
				color: #fff;
				background: url(http://codegen.caihongy.cn/20231219/b1565a93d167425cb53a28e54ef4598c.png) #DF847F;
				background-position: bottom center;
			}
	
	.news-preview-pv .category .item.active {
				background-repeat: no-repeat;
				background-size: 100% 40%;
				color: #fff;
				background: url(http://codegen.caihongy.cn/20231219/b1565a93d167425cb53a28e54ef4598c.png) #80BBCA;
				background-position: bottom center;
			}
	
	.news-preview-pv .list9 .item .image {
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}
	
	.news-preview-pv .list9 .item:hover .image {
				transform: scale(1.1);
			}
	
	.news-preview-pv .list9 .item .info {
				padding: 10px;
				left: 0;
				bottom: -100%;
				background: rgba(0,0,0,.5);
				width: 100%;
				position: absolute;
				transition: 0.3s;
				height: 100%;
			}
	
	.news-preview-pv .list9 .item:hover .info {
				bottom: 0;
			}
</style>
