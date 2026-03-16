import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import daoyouList from '../pages/daoyou/list'
import daoyouDetail from '../pages/daoyou/detail'
import daoyouAdd from '../pages/daoyou/add'
import jingdianleixingList from '../pages/jingdianleixing/list'
import jingdianleixingDetail from '../pages/jingdianleixing/detail'
import jingdianleixingAdd from '../pages/jingdianleixing/add'
import remenjingdianList from '../pages/remenjingdian/list'
import remenjingdianDetail from '../pages/remenjingdian/detail'
import remenjingdianAdd from '../pages/remenjingdian/add'
import menpiaodingdanList from '../pages/menpiaodingdan/list'
import menpiaodingdanDetail from '../pages/menpiaodingdan/detail'
import menpiaodingdanAdd from '../pages/menpiaodingdan/add'
import kefangleixingList from '../pages/kefangleixing/list'
import kefangleixingDetail from '../pages/kefangleixing/detail'
import kefangleixingAdd from '../pages/kefangleixing/add'
import jiudianxinxiList from '../pages/jiudianxinxi/list'
import jiudianxinxiDetail from '../pages/jiudianxinxi/detail'
import jiudianxinxiAdd from '../pages/jiudianxinxi/add'
import jiudianyudingList from '../pages/jiudianyuding/list'
import jiudianyudingDetail from '../pages/jiudianyuding/detail'
import jiudianyudingAdd from '../pages/jiudianyuding/add'
import meishicantingList from '../pages/meishicanting/list'
import meishicantingDetail from '../pages/meishicanting/detail'
import meishicantingAdd from '../pages/meishicanting/add'
import cantingyuyueList from '../pages/cantingyuyue/list'
import cantingyuyueDetail from '../pages/cantingyuyue/detail'
import cantingyuyueAdd from '../pages/cantingyuyue/add'
import xianluleixingList from '../pages/xianluleixing/list'
import xianluleixingDetail from '../pages/xianluleixing/detail'
import xianluleixingAdd from '../pages/xianluleixing/add'
import lvyouxianluList from '../pages/lvyouxianlu/list'
import lvyouxianluDetail from '../pages/lvyouxianlu/detail'
import lvyouxianluAdd from '../pages/lvyouxianlu/add'
import baotuanxinxiList from '../pages/baotuanxinxi/list'
import baotuanxinxiDetail from '../pages/baotuanxinxi/detail'
import baotuanxinxiAdd from '../pages/baotuanxinxi/add'
import lvyougonglveList from '../pages/lvyougonglve/list'
import lvyougonglveDetail from '../pages/lvyougonglve/detail'
import lvyougonglveAdd from '../pages/lvyougonglve/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import friendlinkList from '../pages/friendlink/list'
import friendlinkDetail from '../pages/friendlink/detail'
import friendlinkAdd from '../pages/friendlink/add'
import discussremenjingdianList from '../pages/discussremenjingdian/list'
import discussremenjingdianDetail from '../pages/discussremenjingdian/detail'
import discussremenjingdianAdd from '../pages/discussremenjingdian/add'
import discussjiudianxinxiList from '../pages/discussjiudianxinxi/list'
import discussjiudianxinxiDetail from '../pages/discussjiudianxinxi/detail'
import discussjiudianxinxiAdd from '../pages/discussjiudianxinxi/add'
import discussmeishicantingList from '../pages/discussmeishicanting/list'
import discussmeishicantingDetail from '../pages/discussmeishicanting/detail'
import discussmeishicantingAdd from '../pages/discussmeishicanting/add'
import discusslvyouxianluList from '../pages/discusslvyouxianlu/list'
import discusslvyouxianluDetail from '../pages/discusslvyouxianlu/detail'
import discusslvyouxianluAdd from '../pages/discusslvyouxianlu/add'
import discusslvyougonglveList from '../pages/discusslvyougonglve/list'
import discusslvyougonglveDetail from '../pages/discusslvyougonglve/detail'
import discusslvyougonglveAdd from '../pages/discusslvyougonglve/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'daoyou',
					component: daoyouList
				},
				{
					path: 'daoyouDetail',
					component: daoyouDetail
				},
				{
					path: 'daoyouAdd',
					component: daoyouAdd
				},
				{
					path: 'jingdianleixing',
					component: jingdianleixingList
				},
				{
					path: 'jingdianleixingDetail',
					component: jingdianleixingDetail
				},
				{
					path: 'jingdianleixingAdd',
					component: jingdianleixingAdd
				},
				{
					path: 'remenjingdian',
					component: remenjingdianList
				},
				{
					path: 'remenjingdianDetail',
					component: remenjingdianDetail
				},
				{
					path: 'remenjingdianAdd',
					component: remenjingdianAdd
				},
				{
					path: 'menpiaodingdan',
					component: menpiaodingdanList
				},
				{
					path: 'menpiaodingdanDetail',
					component: menpiaodingdanDetail
				},
				{
					path: 'menpiaodingdanAdd',
					component: menpiaodingdanAdd
				},
				{
					path: 'kefangleixing',
					component: kefangleixingList
				},
				{
					path: 'kefangleixingDetail',
					component: kefangleixingDetail
				},
				{
					path: 'kefangleixingAdd',
					component: kefangleixingAdd
				},
				{
					path: 'jiudianxinxi',
					component: jiudianxinxiList
				},
				{
					path: 'jiudianxinxiDetail',
					component: jiudianxinxiDetail
				},
				{
					path: 'jiudianxinxiAdd',
					component: jiudianxinxiAdd
				},
				{
					path: 'jiudianyuding',
					component: jiudianyudingList
				},
				{
					path: 'jiudianyudingDetail',
					component: jiudianyudingDetail
				},
				{
					path: 'jiudianyudingAdd',
					component: jiudianyudingAdd
				},
				{
					path: 'meishicanting',
					component: meishicantingList
				},
				{
					path: 'meishicantingDetail',
					component: meishicantingDetail
				},
				{
					path: 'meishicantingAdd',
					component: meishicantingAdd
				},
				{
					path: 'cantingyuyue',
					component: cantingyuyueList
				},
				{
					path: 'cantingyuyueDetail',
					component: cantingyuyueDetail
				},
				{
					path: 'cantingyuyueAdd',
					component: cantingyuyueAdd
				},
				{
					path: 'xianluleixing',
					component: xianluleixingList
				},
				{
					path: 'xianluleixingDetail',
					component: xianluleixingDetail
				},
				{
					path: 'xianluleixingAdd',
					component: xianluleixingAdd
				},
				{
					path: 'lvyouxianlu',
					component: lvyouxianluList
				},
				{
					path: 'lvyouxianluDetail',
					component: lvyouxianluDetail
				},
				{
					path: 'lvyouxianluAdd',
					component: lvyouxianluAdd
				},
				{
					path: 'baotuanxinxi',
					component: baotuanxinxiList
				},
				{
					path: 'baotuanxinxiDetail',
					component: baotuanxinxiDetail
				},
				{
					path: 'baotuanxinxiAdd',
					component: baotuanxinxiAdd
				},
				{
					path: 'lvyougonglve',
					component: lvyougonglveList
				},
				{
					path: 'lvyougonglveDetail',
					component: lvyougonglveDetail
				},
				{
					path: 'lvyougonglveAdd',
					component: lvyougonglveAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'friendlink',
					component: friendlinkList
				},
				{
					path: 'friendlinkDetail',
					component: friendlinkDetail
				},
				{
					path: 'friendlinkAdd',
					component: friendlinkAdd
				},
				{
					path: 'discussremenjingdian',
					component: discussremenjingdianList
				},
				{
					path: 'discussremenjingdianDetail',
					component: discussremenjingdianDetail
				},
				{
					path: 'discussremenjingdianAdd',
					component: discussremenjingdianAdd
				},
				{
					path: 'discussjiudianxinxi',
					component: discussjiudianxinxiList
				},
				{
					path: 'discussjiudianxinxiDetail',
					component: discussjiudianxinxiDetail
				},
				{
					path: 'discussjiudianxinxiAdd',
					component: discussjiudianxinxiAdd
				},
				{
					path: 'discussmeishicanting',
					component: discussmeishicantingList
				},
				{
					path: 'discussmeishicantingDetail',
					component: discussmeishicantingDetail
				},
				{
					path: 'discussmeishicantingAdd',
					component: discussmeishicantingAdd
				},
				{
					path: 'discusslvyouxianlu',
					component: discusslvyouxianluList
				},
				{
					path: 'discusslvyouxianluDetail',
					component: discusslvyouxianluDetail
				},
				{
					path: 'discusslvyouxianluAdd',
					component: discusslvyouxianluAdd
				},
				{
					path: 'discusslvyougonglve',
					component: discusslvyougonglveList
				},
				{
					path: 'discusslvyougonglveDetail',
					component: discusslvyougonglveDetail
				},
				{
					path: 'discusslvyougonglveAdd',
					component: discusslvyougonglveAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
