<template>
<div class="home-preview" :style='{"width":"100%","margin":"0 auto","position":"relative","alignItems":"flex-start","flexWrap":"wrap","display":"flex"}'>

	<!-- 搜索 -->
	<div id="search" class="search animate__animated" :style='{"padding":"0 40px 0 0","margin":"0","alignItems":"center","display":"flex","justifyContent":"flex-end","top":"60px","borderRadius":"0 900px 900px 0","flexWrap":"wrap","left":"0","background":"#DF847F","width":"90%","position":"absolute","height":"140px","order":"1","zIndex":"111"}'>
		<div :style='{"margin":"0 10px 0 0"}' class="select">
			<el-select v-model="queryIndex">
				<el-option
				  v-for="(item,index) in queryList"
				  :key="index"
				  :label="item.queryName"
				  :value="index"
				></el-option>
			</el-select>
		</div>
		<div :style='{"margin":"0 10px 0 0"}' class="input" v-if="queryIndex==0">
			<el-input v-model="remenjingdianjingdianmingcheng" placeholder="景点名称"></el-input>
		</div>
		<div :style='{"padding":"0","margin":"0"}' class="btn" v-if="queryIndex==0">
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"#DF847F","borderRadius":"40px","background":"#fff","width":"120px","lineHeight":"60px","fontSize":"0","height":"60px"}' type="primary" @click="search('remenjingdian')">
				<span class="icon iconfont icon-fangdajing07" :style='{"color":"#DF847F","margin":"0 4px 0 0","fontSize":"24px"}'></span>
				搜索
			</el-button>
		</div>
	</div>
	<!-- 搜索 -->



		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"padding":"270px 20px 140px 10%","margin":"0 0 0","background":"url(http://codegen.caihongy.cn/20231217/9d455cda5ca74132a89d74e798694541.png)","width":"50%","backgroundPosition":"left center","position":"relative","backgroundRepeat":"no-repeat","order":"2"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"border":"none","margin":"10px auto","textAlign":"center","background":"none","borderWidth":"0","width":"100%","lineHeight":"54px"}'>
			<span :style='{"border":"2px solid #BFF2FF","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 40px)","fontSize":"32px","fontWeight":"bold"}'>旅游资讯</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		






		<div v-if="newsList.length" class="list list17 index-pv1" :style='{"border":"5px solid #BFF2FF","padding":"124px 20px 40px","margin":"-100px 0 0","borderRadius":"20px","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		  <div class="swiper" :style='{"width":"45%","background":"#fff","height":"auto"}'>
		    <div class="swiper-container newsSwiper17 new-list-17news">
		      <div class="swiper-wrapper">
				<template v-for="(item,index) in newsList">
		        <div v-if="index < 3" class="swiper-slide">
		          <div :style='{"width":"100%","position":"relative","height":"auto"}' @click="toDetail('newsDetail', item)">
		            <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"325px"}' :src="baseUrl + item.picture">
		            <div :style='{"alignItems":"center","left":"0","bottom":"0","background":"rgba(0,0,0,.3)","display":"flex","width":"100%","position":"absolute"}'>
		              <div :style='{"padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff"}'>{{item.title}}</div>
		              <div :style='{"padding":"0 10px"}'>
		                <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		                <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
		              </div>
		            </div>
		          </div>
		        </div>
				</template>
		      </div>
		      <!-- Add Pagination -->
		      <div class="swiper-pagination" :style='{"width":"100%","left":"0","textAlign":"right","bottom":"10px"}'></div>
		    </div>
		  </div>
		  <div class="right" :style='{"width":"53%","height":"auto"}'>
		    <div v-if="newsList.length > 3" :style='{"border":"1px solid #50D9FF","padding":"10px","margin":"0 0 20px 0","flexWrap":"wrap","background":"#EDFBFF","display":"flex","width":"100%","height":"auto"}' @click="toDetail('newsDetail', newsList[3])">
		      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"30px","fontSize":"16px","textOverflow":"ellipsis","fontWeight":"bold","order":"1"}' class="name">{{newsList[3].title}}</div>
		      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#4D4D4D","width":"100%","lineHeight":"28px","fontSize":"14px","textOverflow":"ellipsis","order":"2"}' class="desc">{{newsList[3].introduction}}</div>
		      <div :style='{"padding":"0","display":"inline-block","order":"7"}'>
		        <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#4D4D4D"}'></span>
		        <span :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[3].addtime}}</span>
		      </div>
		      <div :style='{"padding":"0 10px 0 0","display":"inline-block","order":"6"}'>
		        <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#4D4D4D"}'></span>
		        <span :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[3].name}}</span>
		      </div>
		      <div :style='{"padding":"0 10px 0 0","display":"inline-block","order":"3"}'>
		        <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#4D4D4D"}'></span>
		        <span :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[3].thumbsupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px 0 0","display":"inline-block","order":"4"}'>
		        <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#4D4D4D"}'></span>
		        <span :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[3].storeupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px 0 0","display":"inline-block","order":"5"}'>
		        <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#4D4D4D"}'></span>
		        <span :style='{"color":"#4D4D4D","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[3].clicknum}}</span>
		      </div>
		    </div>
		    <div class="list" :style='{"border":"1px solid #50D9FF","width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			  <template v-for="(item,index) in newsList">
		      <div v-if="index > 3" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}' @click="toDetail('newsDetail', item)">
		        <div :style='{"width":"10px","margin":"0 10px","borderRadius":"100%","background":"#DF847F","height":"10px"}'></div>
		        <div class="title">{{item.title}}</div>
		        <div :style='{"padding":"0 6px"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"color":"#909090","lineHeight":"44px","fontSize":"12px"}'></span>
		          <span :style='{"color":"#909090","lineHeight":"44px","fontSize":"12px"}'>{{item.addtime}}</span>
		        </div>
		      </div>
			  </template>
		    </div>
		  </div>
		</div>





		<div @click="moreBtn('news')" :style='{"border":"2px solid #80BBCA","cursor":"pointer","margin":"10px auto","top":"280px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"30px","position":"absolute","right":"40px"}'>
			<span :style='{"color":"#80BBCA","fontSize":"12px"}'>查看更多</span>
			<i :style='{"color":"#80BBCA","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


<!-- 商品推荐 -->
<div id="animate_recommendremenjingdian" class="recommend animate__animated" :style='{"padding":"110px 10%","margin":"0","background":"url(http://codegen.caihongy.cn/20231228/66b2219633104669aa2b2ccc41d01f72.png)","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","position":"relative","backgroundRepeat":"no-repeat","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","margin":"10px auto","lineHeight":"54px","textAlign":"center","background":"none"}'>
		<span :style='{"border":"1px solid #BFF2FF","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 40px)","fontSize":"30px","fontWeight":"bold"}'>热门景点推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	





	<div v-if="remenjingdianRecommend.length" class="list list14 index-pv1" :style='{"border":"5px solid #BFF2FF","padding":"120px 50px 50px","margin":"-90px 0 0","borderRadius":"20px","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	  <div :style='{"width":"30%","position":"relative","height":"auto"}' class="left">
	    <img :style='{"width":"100% ","objectFit":"cover","display":"block","height":"535px"}' src="http://codegen.caihongy.cn/20230814/797fe92c8ce14417a09161c42381f9b3.jpg">
	    <template v-for="item,index in remenjingdianRecommend">
		<template v-if="recommendIndex14remenjingdian == index">
		<img @click="toDetail('remenjingdianDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
		<img @click="toDetail('remenjingdianDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	  <div :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}' class="list">
	    <template v-for="item,index in remenjingdianRecommend">
		<img @click="recommendClick14(index, 'remenjingdian')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
		<img @click="recommendClick14(index, 'remenjingdian')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
		</template>
	  </div>
	</div>


	
	<div @click="moreBtn('remenjingdian')" :style='{"border":"2px solid #80BBCA","margin":"10px auto","top":"120px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"30px","position":"absolute","right":"calc(10% + 20px)"}'>
		<span :style='{"color":"#80BBCA","fontSize":"12px"}'>查看更多</span>
		<i :style='{"color":"#80BBCA","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendjiudianxinxi" class="recommend animate__animated" :style='{"padding":"110px 10%","margin":"0","background":"url(http://codegen.caihongy.cn/20231228/66b2219633104669aa2b2ccc41d01f72.png)","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","position":"relative","backgroundRepeat":"no-repeat","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","margin":"10px auto","lineHeight":"54px","textAlign":"center","background":"none"}'>
		<span :style='{"border":"1px solid #BFF2FF","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 40px)","fontSize":"30px","fontWeight":"bold"}'>酒店信息推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	





	<div v-if="jiudianxinxiRecommend.length" class="list list14 index-pv1" :style='{"border":"5px solid #BFF2FF","padding":"120px 50px 50px","margin":"-90px 0 0","borderRadius":"20px","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	  <div :style='{"width":"30%","position":"relative","height":"auto"}' class="left">
	    <img :style='{"width":"100% ","objectFit":"cover","display":"block","height":"535px"}' src="http://codegen.caihongy.cn/20230814/797fe92c8ce14417a09161c42381f9b3.jpg">
	    <template v-for="item,index in jiudianxinxiRecommend">
		<template v-if="recommendIndex14jiudianxinxi == index">
		<img @click="toDetail('jiudianxinxiDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-if="preHttp(item.kefangtupian)" :src="item.kefangtupian.split(',')[0]" alt="" />
		<img @click="toDetail('jiudianxinxiDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-else :src="baseUrl + (item.kefangtupian?item.kefangtupian.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	  <div :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}' class="list">
	    <template v-for="item,index in jiudianxinxiRecommend">
		<img @click="recommendClick14(index, 'jiudianxinxi')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-if="preHttp(item.kefangtupian)" :src="item.kefangtupian.split(',')[0]" alt="" />
		<img @click="recommendClick14(index, 'jiudianxinxi')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-else :src="baseUrl + (item.kefangtupian?item.kefangtupian.split(',')[0]:'')" alt="" />
		</template>
	  </div>
	</div>


	
	<div @click="moreBtn('jiudianxinxi')" :style='{"border":"2px solid #80BBCA","margin":"10px auto","top":"120px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"30px","position":"absolute","right":"calc(10% + 20px)"}'>
		<span :style='{"color":"#80BBCA","fontSize":"12px"}'>查看更多</span>
		<i :style='{"color":"#80BBCA","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendmeishicanting" class="recommend animate__animated" :style='{"padding":"110px 10%","margin":"0","background":"url(http://codegen.caihongy.cn/20231228/66b2219633104669aa2b2ccc41d01f72.png)","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","position":"relative","backgroundRepeat":"no-repeat","order":"4"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","margin":"10px auto","lineHeight":"54px","textAlign":"center","background":"none"}'>
		<span :style='{"border":"1px solid #BFF2FF","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 40px)","fontSize":"30px","fontWeight":"bold"}'>美食餐厅推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	





	<div v-if="meishicantingRecommend.length" class="list list14 index-pv1" :style='{"border":"5px solid #BFF2FF","padding":"120px 50px 50px","margin":"-90px 0 0","borderRadius":"20px","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	  <div :style='{"width":"30%","position":"relative","height":"auto"}' class="left">
	    <img :style='{"width":"100% ","objectFit":"cover","display":"block","height":"535px"}' src="http://codegen.caihongy.cn/20230814/797fe92c8ce14417a09161c42381f9b3.jpg">
	    <template v-for="item,index in meishicantingRecommend">
		<template v-if="recommendIndex14meishicanting == index">
		<img @click="toDetail('meishicantingDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-if="preHttp(item.cantingtupian)" :src="item.cantingtupian.split(',')[0]" alt="" />
		<img @click="toDetail('meishicantingDetail', item)" :name="item.id" :style='{"objectFit":"cover","top":"70px","left":"96px","display":"block","width":"88% ","position":"absolute","height":"500px"}' v-else :src="baseUrl + (item.cantingtupian?item.cantingtupian.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	  <div :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}' class="list">
	    <template v-for="item,index in meishicantingRecommend">
		<img @click="recommendClick14(index, 'meishicanting')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-if="preHttp(item.cantingtupian)" :src="item.cantingtupian.split(',')[0]" alt="" />
		<img @click="recommendClick14(index, 'meishicanting')" :name="item.id" :style='{"width":"31% ","objectFit":"cover","display":"block","height":"220px"}' v-else :src="baseUrl + (item.cantingtupian?item.cantingtupian.split(',')[0]:'')" alt="" />
		</template>
	  </div>
	</div>


	
	<div @click="moreBtn('meishicanting')" :style='{"border":"2px solid #80BBCA","margin":"10px auto","top":"120px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"30px","position":"absolute","right":"calc(10% + 20px)"}'>
		<span :style='{"color":"#80BBCA","fontSize":"12px"}'>查看更多</span>
		<i :style='{"color":"#80BBCA","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->


<!-- 特价商品 -->
<div id="animate_listlvyouxianlu" class="lists animate__animated" :style='{"padding":"100px 10%","margin":"0 0 ","background":"#fff","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","position":"relative","backgroundRepeat":"no-repeat","order":"7"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","margin":"10px auto","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"border":"1px solid #BFF2FF","margin":"0 auto","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 140px)","fontSize":"30px","lineHeight":"54px","fontWeight":"bold"}'>旅游线路展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	
	<!-- 样式九 -->
	<div class="list list9 index-pv1" :style='{"border":"5px solid #BFF2FF","padding":"140px 70px 50px","margin":"-100px 0 0","borderRadius":"20px","background":"#fff","width":"100%","height":"auto"}'>
		<div class="list-4-body" :style='{"width":"100%","margin":"0 0 30px","display":"flex","height":"auto"}'>
			<div v-if="lvyouxianluList.length>0" @click="toDetail('lvyouxianluDetail', lvyouxianluList[0])" class="list-4-item animation-box item-1" :style='{"width":"calc(50% - 20px)","margin":"0 40px 0 0","position":"relative","display":"inline-block","height":"340px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(lvyouxianluList[0].xianlutupian)" :src="lvyouxianluList[0].xianlutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (lvyouxianluList[0].xianlutupian?lvyouxianluList[0].xianlutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"border":"5px solid #BFF2FF","padding":"10px","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.5)","display":"flex","width":"100%","position":"absolute"}'>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>{{lvyouxianluList[0].xianlumingcheng}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>起点:{{lvyouxianluList[0].qidian}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>终点:{{lvyouxianluList[0].zhongdian}}</div>
					<div :style='{"width":"100%","padding":"0 10px","order":"6"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[0].addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"5"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[0].daoyougonghao}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"2"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[0].thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"3"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[0].storeupnum}}</span>
					</div>
                </div>
			</div>
			<div v-if="lvyouxianluList.length>1" @click="toDetail('lvyouxianluDetail', lvyouxianluList[1])" class="list-4-item animation-box item-2" :style='{"width":"calc(50% - 20px)","margin":"0 0","position":"relative","display":"inline-block","height":"340px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(lvyouxianluList[1].xianlutupian)" :src="lvyouxianluList[1].xianlutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (lvyouxianluList[1].xianlutupian?lvyouxianluList[1].xianlutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"border":"5px solid #BFF2FF","padding":"10px","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.5)","display":"flex","width":"100%","position":"absolute"}'>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>{{lvyouxianluList[1].xianlumingcheng}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>起点:{{lvyouxianluList[1].qidian}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>终点:{{lvyouxianluList[1].zhongdian}}</div>
					<div :style='{"width":"100%","padding":"0 10px","order":"6"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[1].addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"5"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[1].daoyougonghao}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"2"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[1].thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"3"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[1].storeupnum}}</span>
					</div>
                </div>
			</div>
		</div>
		<div class="list-4-body" :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}'>
			<div v-if="lvyouxianluList.length>2" @click="toDetail('lvyouxianluDetail', lvyouxianluList[2])" class="list-4-item animation-box item-3" :style='{"width":"calc(100% / 3 - 30px)","margin":"0 45px 0 0","position":"relative","height":"360px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(lvyouxianluList[2].xianlutupian)" :src="lvyouxianluList[2].xianlutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (lvyouxianluList[2].xianlutupian?lvyouxianluList[2].xianlutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"border":"5px solid #BFF2FF","padding":"10px","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.5)","display":"flex","width":"100%","position":"absolute"}'>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>{{lvyouxianluList[2].xianlumingcheng}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>起点:{{lvyouxianluList[2].qidian}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>终点:{{lvyouxianluList[2].zhongdian}}</div>
					<div :style='{"width":"100%","padding":"0 10px","order":"6"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[2].addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"5"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[2].daoyougonghao}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"2"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[2].thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"3"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[2].storeupnum}}</span>
					</div>
                </div>
			</div>
			<div v-if="lvyouxianluList.length>3" @click="toDetail('lvyouxianluDetail', lvyouxianluList[3])" class="list-4-item animation-box item-4" :style='{"width":"calc(100% / 3 - 30px)","margin":"0 45px 0 0","position":"relative","height":"360px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(lvyouxianluList[3].xianlutupian)" :src="lvyouxianluList[3].xianlutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (lvyouxianluList[3].xianlutupian?lvyouxianluList[3].xianlutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"border":"5px solid #BFF2FF","padding":"10px","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.5)","display":"flex","width":"100%","position":"absolute"}'>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>{{lvyouxianluList[3].xianlumingcheng}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>起点:{{lvyouxianluList[3].qidian}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>终点:{{lvyouxianluList[3].zhongdian}}</div>
					<div :style='{"width":"100%","padding":"0 10px","order":"6"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[3].addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"5"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[3].daoyougonghao}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"2"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[3].thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"3"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[3].storeupnum}}</span>
					</div>
                </div>
			</div>
			<div v-if="lvyouxianluList.length>4" @click="toDetail('lvyouxianluDetail', lvyouxianluList[4])" class="list-4-item animation-box item-5" :style='{"width":"calc(100% / 3 - 30px)","margin":"0 0","position":"relative","height":"360px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(lvyouxianluList[4].xianlutupian)" :src="lvyouxianluList[4].xianlutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (lvyouxianluList[4].xianlutupian?lvyouxianluList[4].xianlutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"border":"5px solid #BFF2FF","padding":"10px","left":"0","flexWrap":"wrap","bottom":"0","background":"rgba(0,0,0,.5)","display":"flex","width":"100%","position":"absolute"}'>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>{{lvyouxianluList[4].xianlumingcheng}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>起点:{{lvyouxianluList[4].qidian}}</div>
                    <div :style='{"width":"100%","padding":"0 10px","lineHeight":"44px","fontSize":"18px","color":"#fff","order":"1"}'>终点:{{lvyouxianluList[4].zhongdian}}</div>
					<div :style='{"width":"100%","padding":"0 10px","order":"6"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[4].addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"5"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[4].daoyougonghao}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"2"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[4].thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","order":"3"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"2","fontSize":"12px","color":"#fff"}'></span>
					  <span class="text" :style='{"color":"#fff","lineHeight":"2","fontSize":"12px"}'>{{lvyouxianluList[4].storeupnum}}</span>
					</div>
                </div>
			</div>
		</div>
	</div>






	
	
	<div @click="moreBtn('lvyouxianlu')" :style='{"border":"1px solid #80BBCA","margin":"10px auto","top":"110px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(10% + 70px)"}'>
		<span :style='{"color":"#80BBCA","fontSize":"12px"}'>更多</span>
		<i :style='{"color":"#80BBCA","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
	<!-- 友链 -->
	<div id="friendly" class="friendly animate__animated" :style='{"padding":"270px 10% 140px 20px","margin":"0 auto","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20231217/9d455cda5ca74132a89d74e798694541.png)","width":"50%","backgroundSize":"cover","backgroundPosition":"right center","backgroundRepeat":"no-repeat","height":"auto","order":"3"}'>
	  <div :style='{"borderColor":"#BFF2FF","margin":"10px auto","textAlign":"center","borderWidth":"0 0 2px","width":"100%","lineHeight":"54px","borderStyle":"solid","height":"auto"}'>
	    <div :style='{"padding":"0 10px","borderColor":"#BFF2FF","margin":"0","color":"#000","borderWidth":"0 0 2px","display":"inline-block","width":"calc(100% - 40px)","fontSize":"32px","borderStyle":"solid","fontWeight":"bold"}'>友情链接</div>
	  </div>
	  <div :style='{"border":"5px solid #BFF2FF","padding":"120px 20px 40px","margin":"-100px 0 0","borderRadius":"20px","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"500px"}'>
	    <div :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","padding":"20px","margin":"0 0 20px","alignItems":"center","borderRadius":"10px","flexDirection":"column","background":"#fff","display":"flex","width":"23%","justifyContent":"center","height":"auto"}' v-for="item in friendLinkList" :key="item.id" @click="friendlinkClick(item.url)">
	      <img :style='{"width":"100%","margin":"0 auto","objectFit":"cover","borderRadius":"4px","display":"block","height":"60px"}' :src="item.picture?(baseUrl + item.picture.split(',')[0]): ''" alt="">
	      <div :style='{"color":"#000","lineHeight":"30px","fontSize":"14px"}'>{{item.name}}</div>
	    </div>
	  </div>
	</div>
	<!-- 友链 -->
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        queryList:[
          {
              queryName:"景点名称",
          },
        ],
        queryIndex: 0,
        remenjingdianjingdianmingcheng: '',
        newsList: [],
        remenjingdianRecommend: [],
        jiudianxinxiRecommend: [],
        meishicantingRecommend: [],

        lvyouxianluList: [],

		newListSwiper17news: null,

		recommendIndex14remenjingdian: 0,
		recommendIndex14jiudianxinxi: 0,
		recommendIndex14meishicanting: 0,


		friendLinkList: [],
      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getList();
		this.getFriendLinkList()
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			if (this['newListSwiper17news']) this['newListSwiper17news'].destroy()
			setTimeout(()=>{
				this['newListSwiper17news'] = new Swiper(".new-list-17news", {"pagination":{"el":".swiper-pagination","clickable":true}})
			},750)
		},
		// 获取友链列表
		getFriendLinkList(){
			this.$http.get('friendlink/list', {params:{page: 1,limit: 100}}).then(res => {
			  if(res.data.code == 0) {
			    this.friendLinkList = res.data.data.list
			  }
			})
		},
		// 友链跳转
		friendlinkClick(url){
			if(url){
				window.open(url)
			}
		},
		recommendClick14(index, name) {
			this['recommendIndex14' + name] = index
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__backInUp'},
				{id:'about',css:'animate__bounceInUp'},
				{id:'system',css:'animate__slideInDown'},
				{id:'animate_recommendremenjingdian',css:'animate__rotateInUpRight'},
				{id:'animate_recommendjiudianxinxi',css:'animate__rotateInUpRight'},
				{id:'animate_recommendmeishicanting',css:'animate__rotateInUpRight'},
				{id:'animate_listlvyouxianlu',css:'animate__fadeInTopRight'},
				{id:'animate_newsnews',css:'animate__heartBeat'},
				{id:'msgs',css:'animate__backInLeft'},
				{id:'friendly',css:'animate__fadeInBottomLeft'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      search(tablename) {
        if (this.queryIndex == 0 && this.remenjingdianjingdianmingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.remenjingdianjingdianmingcheng}});
        }
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 6,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "remenjingdian/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "remenjingdian/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.remenjingdianRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "jiudianxinxi/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "jiudianxinxi/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.jiudianxinxiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "meishicanting/autoSort";
          if(localStorage.getItem('frontToken')) {
              autoSortUrl = "meishicanting/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.meishicantingRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			data = {
				page: 1,
				limit: 6,
			}
			this.$http.get('lvyouxianlu/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.lvyouxianluList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0;
			border-radius: 40px;
			padding: 0 30px 0 20px;
			box-shadow: none;
			outline: none;
			color: #000;
			width: 240px;
			font-size: 18px;
			height: 60px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 0;
			border-radius: 40px;
			padding: 0 20px;
			box-shadow: 0 0 6px rgba(64, 158, 255, .3);
			outline: none;
			color: #000;
			width: 600px;
			font-size: 18px;
			height: 60px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	



	.home-preview .news .list17 .newsSwiper17 .swiper-pagination /deep/ span.swiper-pagination-bullet {
				border-radius: 100%;
				margin: 0 4px;
				background: #fff;
				display: inline-block;
				width: 10px;
				opacity: .2;
				height: 10px;
			}
	
	.home-preview .news .list17 .newsSwiper17 .swiper-pagination /deep/ span.swiper-pagination-bullet:hover {
				background: #50D9FF;
				opacity: 1;
			}
	
	.home-preview .news .list17 .newsSwiper17 .swiper-pagination /deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
				background: #50D9FF;
				opacity: 1;
			}
	
	.home-preview .news .list17 .right .list .title {
				padding: 0 10px 0 0;
				overflow: hidden;
				color: #000;
				white-space: nowrap;
				flex: 1;
				font-weight: bold;
				font-size: 16px;
				line-height: 46px;
				text-overflow: ellipsis;
				transition: 0.3s;
			}
	
	.home-preview .news .list17 .right .list .title:hover {
				transform: translate3d(10px, 0px, 0px);
			}







</style>
