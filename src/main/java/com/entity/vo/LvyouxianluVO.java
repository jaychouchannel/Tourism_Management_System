package com.entity.vo;

import com.entity.LvyouxianluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 旅游线路
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public class LvyouxianluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 线路图片
	 */
	
	private String xianlutupian;
		
	/**
	 * 景点名称
	 */
	
	private String jingdianmingcheng;
		
	/**
	 * 景点类型
	 */
	
	private String jingdianleixing;
		
	/**
	 * 景点位置
	 */
	
	private String jingdianweizhi;
		
	/**
	 * 起点
	 */
	
	private String qidian;
		
	/**
	 * 途径路段
	 */
	
	private String tujingluduan;
		
	/**
	 * 终点
	 */
	
	private String zhongdian;
		
	/**
	 * 线路费用
	 */
	
	private Double xianlufeiyong;
		
	/**
	 * 报团名额
	 */
	
	private Integer baotuanminge;
		
	/**
	 * 出发日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chufariqi;
		
	/**
	 * 交通方式
	 */
	
	private String jiaotongfangshi;
		
	/**
	 * 线路详情
	 */
	
	private String xianluxiangqing;
		
	/**
	 * 导游工号
	 */
	
	private String daoyougonghao;
		
	/**
	 * 导游姓名
	 */
	
	private String daoyouxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 导游介绍
	 */
	
	private String gerenlvli;
		
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
	 * 设置：线路图片
	 */
	 
	public void setXianlutupian(String xianlutupian) {
		this.xianlutupian = xianlutupian;
	}
	
	/**
	 * 获取：线路图片
	 */
	public String getXianlutupian() {
		return xianlutupian;
	}
				
	
	/**
	 * 设置：景点名称
	 */
	 
	public void setJingdianmingcheng(String jingdianmingcheng) {
		this.jingdianmingcheng = jingdianmingcheng;
	}
	
	/**
	 * 获取：景点名称
	 */
	public String getJingdianmingcheng() {
		return jingdianmingcheng;
	}
				
	
	/**
	 * 设置：景点类型
	 */
	 
	public void setJingdianleixing(String jingdianleixing) {
		this.jingdianleixing = jingdianleixing;
	}
	
	/**
	 * 获取：景点类型
	 */
	public String getJingdianleixing() {
		return jingdianleixing;
	}
				
	
	/**
	 * 设置：景点位置
	 */
	 
	public void setJingdianweizhi(String jingdianweizhi) {
		this.jingdianweizhi = jingdianweizhi;
	}
	
	/**
	 * 获取：景点位置
	 */
	public String getJingdianweizhi() {
		return jingdianweizhi;
	}
				
	
	/**
	 * 设置：起点
	 */
	 
	public void setQidian(String qidian) {
		this.qidian = qidian;
	}
	
	/**
	 * 获取：起点
	 */
	public String getQidian() {
		return qidian;
	}
				
	
	/**
	 * 设置：途径路段
	 */
	 
	public void setTujingluduan(String tujingluduan) {
		this.tujingluduan = tujingluduan;
	}
	
	/**
	 * 获取：途径路段
	 */
	public String getTujingluduan() {
		return tujingluduan;
	}
				
	
	/**
	 * 设置：终点
	 */
	 
	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}
	
	/**
	 * 获取：终点
	 */
	public String getZhongdian() {
		return zhongdian;
	}
				
	
	/**
	 * 设置：线路费用
	 */
	 
	public void setXianlufeiyong(Double xianlufeiyong) {
		this.xianlufeiyong = xianlufeiyong;
	}
	
	/**
	 * 获取：线路费用
	 */
	public Double getXianlufeiyong() {
		return xianlufeiyong;
	}
				
	
	/**
	 * 设置：报团名额
	 */
	 
	public void setBaotuanminge(Integer baotuanminge) {
		this.baotuanminge = baotuanminge;
	}
	
	/**
	 * 获取：报团名额
	 */
	public Integer getBaotuanminge() {
		return baotuanminge;
	}
				
	
	/**
	 * 设置：出发日期
	 */
	 
	public void setChufariqi(Date chufariqi) {
		this.chufariqi = chufariqi;
	}
	
	/**
	 * 获取：出发日期
	 */
	public Date getChufariqi() {
		return chufariqi;
	}
				
	
	/**
	 * 设置：交通方式
	 */
	 
	public void setJiaotongfangshi(String jiaotongfangshi) {
		this.jiaotongfangshi = jiaotongfangshi;
	}
	
	/**
	 * 获取：交通方式
	 */
	public String getJiaotongfangshi() {
		return jiaotongfangshi;
	}
				
	
	/**
	 * 设置：线路详情
	 */
	 
	public void setXianluxiangqing(String xianluxiangqing) {
		this.xianluxiangqing = xianluxiangqing;
	}
	
	/**
	 * 获取：线路详情
	 */
	public String getXianluxiangqing() {
		return xianluxiangqing;
	}
				
	
	/**
	 * 设置：导游工号
	 */
	 
	public void setDaoyougonghao(String daoyougonghao) {
		this.daoyougonghao = daoyougonghao;
	}
	
	/**
	 * 获取：导游工号
	 */
	public String getDaoyougonghao() {
		return daoyougonghao;
	}
				
	
	/**
	 * 设置：导游姓名
	 */
	 
	public void setDaoyouxingming(String daoyouxingming) {
		this.daoyouxingming = daoyouxingming;
	}
	
	/**
	 * 获取：导游姓名
	 */
	public String getDaoyouxingming() {
		return daoyouxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：导游介绍
	 */
	 
	public void setGerenlvli(String gerenlvli) {
		this.gerenlvli = gerenlvli;
	}
	
	/**
	 * 获取：导游介绍
	 */
	public String getGerenlvli() {
		return gerenlvli;
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
