import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import daoyou from '@/views/modules/daoyou/list'
    import kefangleixing from '@/views/modules/kefangleixing/list'
    import jingdianleixing from '@/views/modules/jingdianleixing/list'
    import remenjingdian from '@/views/modules/remenjingdian/list'
    import discussjiudianxinxi from '@/views/modules/discussjiudianxinxi/list'
    import jiudianxinxi from '@/views/modules/jiudianxinxi/list'
    import discussmeishicanting from '@/views/modules/discussmeishicanting/list'
    import friendlink from '@/views/modules/friendlink/list'
    import discusslvyouxianlu from '@/views/modules/discusslvyouxianlu/list'
    import forum from '@/views/modules/forum/list'
    import xianluleixing from '@/views/modules/xianluleixing/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discussremenjingdian from '@/views/modules/discussremenjingdian/list'
    import discusslvyougonglve from '@/views/modules/discusslvyougonglve/list'
    import lvyougonglve from '@/views/modules/lvyougonglve/list'
    import menpiaodingdan from '@/views/modules/menpiaodingdan/list'
    import cantingyuyue from '@/views/modules/cantingyuyue/list'
    import lvyouxianlu from '@/views/modules/lvyouxianlu/list'
    import baotuanxinxi from '@/views/modules/baotuanxinxi/list'
    import jiudianyuding from '@/views/modules/jiudianyuding/list'
    import meishicanting from '@/views/modules/meishicanting/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '旅游资讯',
        component: news
      }
      ,{
	path: '/daoyou',
        name: '导游',
        component: daoyou
      }
      ,{
	path: '/kefangleixing',
        name: '客房类型',
        component: kefangleixing
      }
      ,{
	path: '/jingdianleixing',
        name: '景点类型',
        component: jingdianleixing
      }
      ,{
	path: '/remenjingdian',
        name: '热门景点',
        component: remenjingdian
      }
      ,{
	path: '/discussjiudianxinxi',
        name: '酒店信息评论',
        component: discussjiudianxinxi
      }
      ,{
	path: '/jiudianxinxi',
        name: '酒店信息',
        component: jiudianxinxi
      }
      ,{
	path: '/discussmeishicanting',
        name: '美食餐厅评论',
        component: discussmeishicanting
      }
      ,{
	path: '/friendlink',
        name: '友情链接',
        component: friendlink
      }
      ,{
	path: '/discusslvyouxianlu',
        name: '旅游线路评论',
        component: discusslvyouxianlu
      }
      ,{
	path: '/forum',
        name: '交流论坛',
        component: forum
      }
      ,{
	path: '/xianluleixing',
        name: '线路类型',
        component: xianluleixing
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/discussremenjingdian',
        name: '热门景点评论',
        component: discussremenjingdian
      }
      ,{
	path: '/discusslvyougonglve',
        name: '旅游攻略评论',
        component: discusslvyougonglve
      }
      ,{
	path: '/lvyougonglve',
        name: '旅游攻略',
        component: lvyougonglve
      }
      ,{
	path: '/menpiaodingdan',
        name: '门票订单',
        component: menpiaodingdan
      }
      ,{
	path: '/cantingyuyue',
        name: '餐厅预约',
        component: cantingyuyue
      }
      ,{
	path: '/lvyouxianlu',
        name: '旅游线路',
        component: lvyouxianlu
      }
      ,{
	path: '/baotuanxinxi',
        name: '报团信息',
        component: baotuanxinxi
      }
      ,{
	path: '/jiudianyuding',
        name: '酒店预订',
        component: jiudianyuding
      }
      ,{
	path: '/meishicanting',
        name: '美食餐厅',
        component: meishicanting
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '旅游资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
