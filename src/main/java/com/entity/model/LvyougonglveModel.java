package com.entity.model;

import com.entity.LvyougonglveEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 旅游攻略
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public class LvyougonglveModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 景点封面
	 */
	
	private String jingdianfengmian;
		
	/**
	 * 包含景点
	 */
	
	private String jingdianmingcheng;
		
	/**
	 * 出发城市
	 */
	
	private String chufachengshi;
		
	/**
	 * 行程天数
	 */
	
	private String xingchengtianshu;
		
	/**
	 * 行程距离
	 */
	
	private String xingchengjuli;
		
	/**
	 * 交通工具
	 */
	
	private String jiaotonggongju;
		
	/**
	 * 行程路线
	 */
	
	private String xingchengluxian;
		
	/**
	 * 攻略详情
	 */
	
	private String gonglvexiangqing;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：景点封面
	 */
	 
	public void setJingdianfengmian(String jingdianfengmian) {
		this.jingdianfengmian = jingdianfengmian;
	}
	
	/**
	 * 获取：景点封面
	 */
	public String getJingdianfengmian() {
		return jingdianfengmian;
	}
				
	
	/**
	 * 设置：包含景点
	 */
	 
	public void setJingdianmingcheng(String jingdianmingcheng) {
		this.jingdianmingcheng = jingdianmingcheng;
	}
	
	/**
	 * 获取：包含景点
	 */
	public String getJingdianmingcheng() {
		return jingdianmingcheng;
	}
				
	
	/**
	 * 设置：出发城市
	 */
	 
	public void setChufachengshi(String chufachengshi) {
		this.chufachengshi = chufachengshi;
	}
	
	/**
	 * 获取：出发城市
	 */
	public String getChufachengshi() {
		return chufachengshi;
	}
				
	
	/**
	 * 设置：行程天数
	 */
	 
	public void setXingchengtianshu(String xingchengtianshu) {
		this.xingchengtianshu = xingchengtianshu;
	}
	
	/**
	 * 获取：行程天数
	 */
	public String getXingchengtianshu() {
		return xingchengtianshu;
	}
				
	
	/**
	 * 设置：行程距离
	 */
	 
	public void setXingchengjuli(String xingchengjuli) {
		this.xingchengjuli = xingchengjuli;
	}
	
	/**
	 * 获取：行程距离
	 */
	public String getXingchengjuli() {
		return xingchengjuli;
	}
				
	
	/**
	 * 设置：交通工具
	 */
	 
	public void setJiaotonggongju(String jiaotonggongju) {
		this.jiaotonggongju = jiaotonggongju;
	}
	
	/**
	 * 获取：交通工具
	 */
	public String getJiaotonggongju() {
		return jiaotonggongju;
	}
				
	
	/**
	 * 设置：行程路线
	 */
	 
	public void setXingchengluxian(String xingchengluxian) {
		this.xingchengluxian = xingchengluxian;
	}
	
	/**
	 * 获取：行程路线
	 */
	public String getXingchengluxian() {
		return xingchengluxian;
	}
				
	
	/**
	 * 设置：攻略详情
	 */
	 
	public void setGonglvexiangqing(String gonglvexiangqing) {
		this.gonglvexiangqing = gonglvexiangqing;
	}
	
	/**
	 * 获取：攻略详情
	 */
	public String getGonglvexiangqing() {
		return gonglvexiangqing;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
