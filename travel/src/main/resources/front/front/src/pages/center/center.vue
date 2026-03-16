<template>
<div class="center-preview" :style='{"padding":"0 5%","margin":"10px auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative"}'>
	<div class="title" :style='{"margin":"10px auto","color":"#DF847F","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231220/e54f6cd4929f4d00b2ead8e5a5991d16.png)","width":"80%","fontSize":"24px","lineHeight":"54px","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","fontWeight":"bold"}'>{{ title }}</div>
	
	<div class="info" :style='{"border":"2px solid #DF847F","padding":"50px 120px 100px","boxShadow":"none","margin":"20px auto 100px","alignItems":"flex-start","flexDirection":"column","display":"flex","borderRadius":"0","flexWrap":"wrap","background":"#ffffff","width":"100%","position":"relative","height":"254px"}'>
		<div :style='{"borderColor":"#efefef","color":"#333","borderWidth":"0 0 1px 0","display":"none","width":"100%","lineHeight":"44px","fontSize":"15px","borderStyle":"solid","height":"44px"}'>个人信息</div>
		<div :style='{"borderColor":"#efefef","margin":"0 0 0 15px","borderWidth":"0","width":"auto","fontSize":0,"borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"margin":"0 auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"100px","borderStyle":"solid","height":"100px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>用户账号</div>
			<div :style='{"fontSize":"18px","color":"#000","flex":1,"fontWeight":"bold"}'>{{sessionForm.yonghuzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"0 5px 0 0","fontSize":"16px"}'>用户姓名</div>
			<div :style='{"fontSize":"16px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.yonghuxingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","justifyContent":"center","left":"120px","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>性别</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","fontWeight":"bold"}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","justifyContent":"center","left":"calc(18% + 190px)","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>联系方式</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.lianxifangshi}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","right":"calc(18% + 190px)","justifyContent":"center","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>状态</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.status}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","right":"120px","justifyContent":"center","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>密码错误次数</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.passwordwrongnum}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","fontSize":"14px","display":"none"}'>导游工号</div>
			<div :style='{"fontSize":"18px","color":"#000","flex":1,"fontWeight":"bold"}'>{{sessionForm.daoyougonghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"0 5px 0 0","fontSize":"16px"}'>导游姓名</div>
			<div :style='{"fontSize":"16px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.daoyouxingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","justifyContent":"center","left":"120px","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>头像</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","fontWeight":"bold"}'>{{sessionForm.touxiang}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","justifyContent":"center","left":"calc(18% + 190px)","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>专业领域</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.zhuanyelingyu}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","right":"calc(18% + 190px)","justifyContent":"center","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>语言能力</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.yuyannengli}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","alignItems":"center","bottom":"-75px","display":"flex","right":"120px","justifyContent":"center","borderWidth":"0","background":"url(http://codegen.caihongy.cn/20231222/faf48fa893634aeeb23463c91935e315.png)","width":"18%","lineHeight":"40px","backgroundSize":"100% 100%","position":"absolute","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","height":"150px"}' v-if="userTableName=='daoyou'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#000","padding":"24px 10px 0 0","fontSize":"14px"}'>联系方式</div>
			<div :style='{"padding":"24px 0 0","fontSize":"14px","color":"#000","textAlign":"left","fontWeight":"bold"}'>{{sessionForm.lianxifangshi}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"border":"2px solid #DF847F","width":"100%","flexWrap":"wrap","background":"none","borderWidth":"0 2px 2px","display":"flex"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yonghu'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yonghu'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yonghu'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="导游工号" prop="daoyougonghao">
            <el-input v-model="sessionForm.daoyougonghao" placeholder="导游工号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="导游姓名" prop="daoyouxingming">
            <el-input v-model="sessionForm.daoyouxingming" placeholder="导游姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="头像" prop="touxiang">
            <el-input v-model="sessionForm.touxiang" placeholder="头像" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="专业领域" prop="zhuanyelingyu">
            <el-input v-model="sessionForm.zhuanyelingyu" placeholder="专业领域" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="语言能力" prop="yuyannengli">
            <el-input v-model="sessionForm.yuyannengli" placeholder="语言能力" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
		  <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoyou'" label="个人履历">
		    <editor
		        :style='{"border":"0","boxShadow":"none","outline":"none","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
		        v-model="sessionForm.gerenlvli" 
		        class="editor" 
		        action="file/upload">
		    </editor>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#DF847F","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#8FD5E7","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
	  <el-tab-pane label="修改密码">
		<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="80px">
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="原密码" prop="password">
			  <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="新密码" prop="newpassword">
			  <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="确认密码" prop="repassword">
			  <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}'>
			  <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#DF847F","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}' type="primary" @click="updatePassword">修改密码</el-button>
			</el-form-item>
		</el-form>
	  </el-tab-pane>
	  <el-tab-pane label="好友列表" v-if="changeHasChat()">
	  	<div class="z-box" :style='{"width":"70%","padding":"20px","margin":"0 auto"}'>
	  		<div class="section-content" v-for="item in friendList" :key="item.id"
	  			style="justify-content: space-between;" @click.stop="chatClick(item)">
	  			<div style="display: flex;align-items: center;">
	  				<img :src="item.picture?baseUrl + item.picture:require('@/assets/avator.png')" style="width: 60px;border-radius: 50%;"
	  					alt="">
	  				<div
	  					style="margin: 0 0 0 10px;display: flex;flex-direction: column;align-items: flex-start;">
	  					<div :style='{"fontSize":"14px","color":"#000","flex":"1","fontWeight":"bold"}'
	  						class="item-style">{{item.name}}{{item.type==0?'申请添加您为好友':''}}</div>
	  				</div>
	  			</div>
	  			<div v-if="item.type==0">
	  				<el-button @click.native="confirmFriend(item)" size="small" type="success">同意</el-button>
	  				<el-button @click.native="cancelFriend(item)" size="small" type="danger">拒绝</el-button>
	  			</div>
	  		</div>
			<div class="noList" v-if="!friendList.length">
				暂无好友
			</div>
	  	</div>
	  </el-tab-pane>
	  <el-tab-pane label="聊天记录" style="width: 100%;" v-if="changeHasChat()">
	  	<div class="z-box" :style='{"width":"70%","padding":"20px","margin":"0 auto"}'>
	  		<div class="section-content" v-for="item in recordList" :key="item.id" @click="chatClick(item)">
	  			<img :src="item.picture?baseUrl + item.picture:require('@/assets/avator.png')" style="width: 60px;border-radius: 50%;"
	  				alt="">
	  			<div style="margin: 0 0 0 10px;display: flex;flex-direction: column;align-items: flex-start;">
	  				<div :style='{"fontSize":"14px","color":"#000","flex":"1","fontWeight":"bold"}'
	  					class="item-style">{{item.name}}</div>
	  				<div :style='{"color":"#666","flex":"1","fontSize":"14px","lineHeight":"1.5","display":"flex","alignItems":"center"}'
	  					class="item-style">
	  					<div v-if="item.notreadnum" style="padding: 0 5px;height: 16px;border-radius: 50%;text-align: center;line-height: 16px;font-size: 12px;background: #f00;color:#fff;width: auto;margin: 0 2px 0 0">{{item.notreadnum}}</div>
	  					{{item.content.split('/').length&&item.content.split('/')[0]=='upload'?'[图片]':item.content}}
	  				</div>
	  			</div>
	  		</div>
			<div class="noList" v-if="!recordList.length">
				暂无聊天记录
			</div>
	  	</div>
	  	
	  </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

	<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname">
		<div class="chat-content" id="chat-content">
			<div v-bind:key="item.id" v-for="item in chatList">
				<div v-if="item.uid==sessionForm.id" class="right-content">
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="warning"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
					<img :src="mypic?baseUrl + mypic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
				</div>
				<div v-else class="left-content">
					<img :src="nowfpic?baseUrl + nowfpic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="success"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
				</div>
				<div class="clear-float"></div>
			</div>
		</div>
		<div slot="footer" class="dialog-footer">
			<el-input @keydown.enter.native="addChat" v-model="chatForm.content" placeholder="请输入内容" style="width: calc(100% - 180px);float: left;">
			</el-input>
			<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat">发送</el-button>
			<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl" :on-success="uploadSuccess"
			    :show-file-list="false">
			    <el-button type="success">上传图片</el-button>
			</el-upload>
		</div>
	</el-dialog>
</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
		passwordForm: {},
		passwordRules: {
			password: [
				{
					required: true,
					message: "密码不能为空",
					trigger: "blur"
				}
			],
			newpassword: [
				{
					required: true,
					message: "新密码不能为空",
					trigger: "blur"
				}
			],
			repassword: [
				{
					required: true,
					message: "确认密码不能为空",
					trigger: "blur"
				}
			]
		},
        rules: {},
		menuList: [],
        disabled: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('frontToken')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
		nowtablename: '',
		friendList: [],
		recordList: [],
		chatVisible: false,
		nowfid: 0,
		nowfpic:'',
		nowname: '',
		mypic: localStorage.getItem('frontHeadportrait'),
		chatList: [],
		chatForm: {
			content: ''
		},
		chatTimer: null,
		hasChatList: [
			'yonghu',
		],
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuzhanghao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuxingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxifangshi', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'status', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'passwordwrongnum', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'daoyougonghao', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'daoyouxingming', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'zhuanyelingyu', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'yuyannengli', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxifangshi', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'gerenlvli', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'status', null);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.sessionForm, 'passwordwrongnum', null);
		}

		if ('yonghu' == this.userTableName&&this.rules['yonghuzhanghao']){
			this.rules['yonghuzhanghao'].push({ required: true, message: '请输入用户账号', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuzhanghao']) {
			this.$set(this.rules, 'yonghuzhanghao', [{ required: true, message: '请输入用户账号', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['yonghuxingming']){
			this.rules['yonghuxingming'].push({ required: true, message: '请输入用户姓名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuxingming']) {
			this.$set(this.rules, 'yonghuxingming', [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'status', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'passwordwrongnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName&&this.rules['daoyougonghao']){
			this.rules['daoyougonghao'].push({ required: true, message: '请输入导游工号', trigger: 'blur' })
		}else if('daoyou' == this.userTableName&&!this.rules['daoyougonghao']) {
			this.$set(this.rules, 'daoyougonghao', [{ required: true, message: '请输入导游工号', trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('daoyou' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName&&this.rules['daoyouxingming']){
			this.rules['daoyouxingming'].push({ required: true, message: '请输入导游姓名', trigger: 'blur' })
		}else if('daoyou' == this.userTableName&&!this.rules['daoyouxingming']) {
			this.$set(this.rules, 'daoyouxingming', [{ required: true, message: '请输入导游姓名', trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.rules, 'status', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}
		if ('daoyou' == this.userTableName) {
			this.$set(this.rules, 'passwordwrongnum', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
		}

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`yonghu` == this.userTableName && (this.sessionForm.yonghuzhanghao).toString().length<3){
			this.$message.error('用户账号长度不能小于3');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.yonghuzhanghao).toString().length>13){
			this.$message.error('用户账号长度不能大于13');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.mima).toString().length<3){
			this.$message.error('密码长度不能小于3');
			return
		}
		if(`yonghu` == this.userTableName && (this.sessionForm.mima).toString().length>13){
			this.$message.error('密码长度不能大于13');
			return
		}
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`daoyou` == this.userTableName && (this.sessionForm.daoyougonghao).toString().length<3){
			this.$message.error('导游工号长度不能小于3');
			return
		}
		if(`daoyou` == this.userTableName && (this.sessionForm.daoyougonghao).toString().length>13){
			this.$message.error('导游工号长度不能大于13');
			return
		}
		if(`daoyou` == this.userTableName && (this.sessionForm.mima).toString().length<3){
			this.$message.error('密码长度不能小于3');
			return
		}
		if(`daoyou` == this.userTableName && (this.sessionForm.mima).toString().length>13){
			this.$message.error('密码长度不能大于13');
			return
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '修改密码':
            this.passwordForm = {
				password: '',
				newpassword: '',
				repassword: '',
			}
			this.$forceUpdate()
            break;
			case '好友列表':
				this.getFriendList()
				break;
		  case '聊天记录':
			this.getRecordList()
			break;
          case '我的发布':
            tab.$router.push('/index/myForumList');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
		getFriendList() {
			this.$http.get('friend/page', {
				params: {
					uid: localStorage.getItem('frontUserid')
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					res.data.data.list.sort(function(a, b) {
						return (a.type - b.type)
					});
					let arr = []
					for (let x in res.data.data.list) {
						if (res.data.data.list[x].type != 2) {
							arr.push(res.data.data.list[x])
						}
					}
					this.friendList = arr
				}
			})
		},
		confirmFriend(item) {
			this.$confirm('是否同意好友申请？')
				.then(_ => {
					this.$http.post('friend/add', {
						uid: item.fid,
						fid: localStorage.getItem('frontUserid'),
						type: 1,
						tablename: localStorage.getItem('frontSessionTable'),
						name: localStorage.getItem('username'),
						picture: localStorage.getItem('frontHeadportrait'),
					}).then(res => {
						this.$http.post('friend/add', {
							uid: localStorage.getItem('frontUserid'),
							fid: item.fid,
							type: 1,
							tablename: item.tablename,
							name: item.name,
							picture: item.picture,
						}).then(res1 => {
							this.$http.post('friend/delete', [item.id]).then(res2 => {
								if (res2.data && res2.data.code == 0) {
									this.$message({
									  message: '添加好友成功',
									  type: 'success',
									  duration: 1500,
									  onClose: () => {
										  this.getFriendList()
									  }
									});
									
								}
							})
						})
					})
				}).catch(_ => {});
		
		},
		cancelFriend(item) {
			this.$confirm('是否拒绝此好友申请？')
				.then(_ => {
					this.$http.post('friend/delete', [item.id]).then(res2 => {
						if (res2.data && res2.data.code == 0) {
							this.$message({
							  message: '操作成功！',
							  type: 'success',
							  duration: 1500,
							  onClose: () => {
								  this.getFriendList()
							  }
							});
						}
					})
				}).catch(_ => {});
		},
		changeHasChat(){
			let table = localStorage.getItem('frontSessionTable')
			console.log(table)
			for(let x in this.hasChatList){
				if(this.hasChatList[x]==table){
					return true
				}
			}
			return false
		},
		getRecordList() {
			this.$http.get('friend/page2', {
				params: {
					uid: localStorage.getItem('frontUserid'),
					type: 2
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					this.recordList = res.data.data.list
				}
			})
		},
		chatClick(row) {
			if (row.type == 0) {
				return false
			}
			this.nowfid = row.fid
			this.nowfpic = row.picture
			this.nowname = row.name
			this.getChatList()
			this.chatVisible = true
		},
		getChatList() {
			this.$http.get('chatmessage/mlist', {
				params: {
					page: 1,
					limit: 1000,
					uid: localStorage.getItem('frontUserid'),
					fid: this.nowfid
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					this.chatList = res.data.data.list
					let div = document.getElementsByClassName('chat-content')[0]
					setTimeout(() => {
						if (div)
							div.scrollTop = div.scrollHeight
					}, 0)
					this.chatTimer = setTimeout(() => {
						this.getChatList()
					}, 5000)
				}
			})
		},
		clearChat(){
			clearTimeout(this.chatTimer)
			this.chatList = []
			this.getRecordList()
		},
		uploadSuccess(res) {
			if (res.code == 0) {
				clearTimeout(this.chatTimer)
				if (!this.chatList.length) {
					this.$http.post('friend/add', {
						uid: localStorage.getItem('frontUserid'),
						fid: this.nowfid,
						name: this.nowname,
						picture: this.nowfpic,
						type: 2,
						tablename: this.nowtablename
					}).then(res => {
						this.$http.post('friend/add', {
							uid: this.nowfid,
							fid: localStorage.getItem('frontUserid'),
							type: 2,
							tablename: localStorage.getItem('frontSessionTable'),
							name: localStorage.getItem('username'),
							picture: this.mypic,
						}).then(res1 => {
				
						})
					})
				}
				this.$http.post('chatmessage/add', {
					uid: localStorage.getItem('frontUserid'),
					fid: this.nowfid,
					content: 'upload/' + res.file,
					format: 2
				}).then(res2 => {
					this.chatForm = {
						content: ''
					}
					this.getChatList()
				})
			}
		},
		addChat() {
			clearTimeout(this.chatTimer)
			if (!this.chatList.length) {
				this.$http.post('friend/add', {
					uid: localStorage.getItem('frontUserid'),
					fid: this.nowfid,
					name: this.nowname,
					picture: this.nowfpic,
					type: 2,
					tablename: this.nowtablename
				}).then(res => {
					this.$http.post('friend/add', {
						uid: this.nowfid,
						fid: localStorage.getItem('frontUserid'),
						type: 2,
						tablename: localStorage.getItem('frontSessionTable'),
						name: localStorage.getItem('username'),
						picture: this.mypic,
					}).then(res1 => {
			
					})
				})
			}
			let sensitiveWords = "反共,亲美,精日,垃圾,仆街,咸家铲";
			let sensitiveWordsArr = [];
			if(sensitiveWords) {
				sensitiveWordsArr = sensitiveWords.split(",");
			}
			for(var i=0; i<sensitiveWordsArr.length; i++){
				//全局替换
				var reg = new RegExp(sensitiveWordsArr[i],"g");
				//判断内容中是否包括敏感词
				if (this.chatForm.content.indexOf(sensitiveWordsArr[i]) > -1) {
					// 将敏感词替换为 **
					this.chatForm.content = this.chatForm.content.replace(reg,"**");
				}
			}
			this.$http.post('chatmessage/add', {
				uid: localStorage.getItem('frontUserid'),
				fid: this.nowfid,
				content: this.chatForm.content,
				format: 1
			}).then(res2 => {
				this.chatForm = {
					content: ''
				}
				this.getChatList()
			})
		},
	  async updatePassword(){
			this.$refs["passwordForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.sessionForm.mima) {
						password = this.sessionForm.mima;
					} else if (this.sessionForm.password) {
						password = this.sessionForm.password;
					}
					if (this.passwordForm.password != password) {
						this.$message.error("原密码错误");
						return;
					}
					if (this.passwordForm.newpassword != this.passwordForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.userTableName == 'yonghu') {
						if(this.passwordForm.newpassword && (this.passwordForm.newpassword.length<3)){
							this.$message.error(`新密码长度不能小于3`);
							return
						}
						if(this.passwordForm.newpassword && (this.passwordForm.newpassword.length>13)){
							this.$message.error(`新密码长度不能大于13`);
							return
						}
					}
					this.sessionForm.password = this.passwordForm.newpassword;
					this.sessionForm.mima = this.passwordForm.newpassword;
					this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
							this.setSession()
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			})
	  },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  hasBack(name){
		  switch(name){
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 0;
	margin: 0;
	background: #DF847F;
	display: flex;
	width: 100%;
	border-color: #eee;
	border-width: 0;
	justify-content: center;
	position: relative;
	float: left;
	border-style: solid;
	height: auto;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 20px;
  	color: #000;
  	background: none;
  	font-weight: bold;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	margin: 0 20px;
  	color: #DF847F;
  	background: #fff;
  	font-weight: bold;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	margin: 0 20px;
  	color: #DF847F;
  	background: #fff;
  	font-weight: bold;
  	display: inline-block;
  	font-size: 14px;
  	line-height: 60px;
  	position: relative;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content {
  	padding: 10px;
  	background: #fff;
  	width: 100%;
  }
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #CDCDCD;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	width: 500px;
  	font-size: 16px;
  	height: 50px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #CDCDCD;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	width: 500px;
  	font-size: 16px;
  	height: 50px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
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
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
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
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #CDCDCD;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: none;
  	outline: none;
  	color: #000;
  	display: inline-block;
  	width: 390px;
  	font-size: 14px;
  	height: 50px;
  }
	.section-content {
		cursor: pointer;
		padding: 20px;
		box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
		margin: 0 0 20px;
		color: #333;
		background: #fff;
		display: flex;
		width: 100%;
		border-color: #efefef;
		border-width: 0;
		align-items: center;
		border-style: solid;
		position: relative;
	}

	.section-content:hover {
		color: #fff;
		background: #DF847F10;
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
			display: flex;
			align-items: center;
		}
	
		.right-content {
			float: right;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	}
	
	.clear-float {
		clear: both;
	}
	.noList {
		color: #9e9e9e;
		width: 100%;
		text-align: center;
		padding: 60px 0;
	}
</style>
