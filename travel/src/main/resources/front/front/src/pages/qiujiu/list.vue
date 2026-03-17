<template>
<div>
	<div :style='{"padding":"20px 20px 60px","margin":"10px auto","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20231217/d400927926594c4db68c914d1fab2fc3.png)","width":"90%","backgroundSize":"100% 40%","backgroundPosition":"bottom center","backgroundRepeat":"no-repeat"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'>'" :style='{"fontSize":"16px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div v-if="centerType" :style='{"padding":"20px 20px 60px","margin":"10px auto","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20231217/d400927926594c4db68c914d1fab2fc3.png)","width":"90%","backgroundSize":"100% 40%","backgroundPosition":"bottom center","backgroundRepeat":"no-repeat"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="list-preview" :style='{"padding":"0 5%","margin":"10px auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative"}'>
	
	<div class="list" :style='{"border":"2px solid #DF847F","width":"100%","padding":"20px","margin":"10px 0","background":"#fff"}'>
		<el-table :data="dataList" style="width: 100%">
			<el-table-column prop="daoyougonghao" label="导游工号"></el-table-column>
			<el-table-column prop="daoyouxingming" label="导游姓名"></el-table-column>
			<el-table-column prop="qiujiuneirong" label="求救内容" show-overflow-tooltip></el-table-column>
			<el-table-column prop="lianxifangshi" label="联系方式"></el-table-column>
			<el-table-column prop="sfsh" label="处理状态">
				<template slot-scope="scope">
					<el-tag v-if="scope.row.sfsh=='已处理'" type="success">已处理</el-tag>
					<el-tag v-else type="warning">待处理</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="huifuneirong" label="回复内容" show-overflow-tooltip></el-table-column>
			<el-table-column prop="addtime" label="提交时间"></el-table-column>
		</el-table>
	</div>

	<el-pagination
	  background
	  id="pagination"
	  class="pagination"
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
      @size-change="sizeChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '我的求救记录'
          }
        ],
        dataList: [],
        total: 1,
        pageSize: 10,
		pageSizes: [10,20,30,50],
        totalPage: 1,
		centerType: false,
      }
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
		this.baseUrl = this.$config.baseUrl;
      this.getList(1);
    },
    //方法集合
    methods: {
      backClick() {
        this.$router.go(-1);
      },
      getList(page) {
        let params = {
          page: page ? page : 1,
          limit: this.pageSize,
          sort: 'id',
          order: 'desc',
        }
        this.$http({
          url: 'qiujiu/page',
          method: 'get',
          params: params
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.dataList = data.data.list;
            this.total = data.data.total;
          } else {
            this.dataList = [];
            this.total = 0;
          }
        });
      },
      curChange(val) {
        this.getList(val);
      },
      sizeChange(val) {
        this.pageSize = val;
        this.getList(1);
      },
      prevClick(val) {
        this.getList(val);
      },
      nextClick(val) {
        this.getList(val);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
</style>
