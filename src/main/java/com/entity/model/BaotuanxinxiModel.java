package com.entity.model;

import com.entity.BaotuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 报团信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public class BaotuanxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 线路图片
	 */
	
	private String xianlutupian;
		
	/**
	 * 出发日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chufariqi;
		
	/**
	 * 线路费用
	 */
	
	private Double xianlufeiyong;
		
	/**
	 * 报名人数
	 */
	
	private Integer xianluminge;
		
	/**
	 * 报团金额
	 */
	
	private Double baotuanjine;
		
	/**
	 * 导游工号
	 */
	
	private String daoyougonghao;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 报团时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baotuanshijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：报名人数
	 */
	 
	public void setXianluminge(Integer xianluminge) {
		this.xianluminge = xianluminge;
	}
	
	/**
	 * 获取：报名人数
	 */
	public Integer getXianluminge() {
		return xianluminge;
	}
				
	
	/**
	 * 设置：报团金额
	 */
	 
	public void setBaotuanjine(Double baotuanjine) {
		this.baotuanjine = baotuanjine;
	}
	
	/**
	 * 获取：报团金额
	 */
	public Double getBaotuanjine() {
		return baotuanjine;
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
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
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
	 * 设置：报团时间
	 */
	 
	public void setBaotuanshijian(Date baotuanshijian) {
		this.baotuanshijian = baotuanshijian;
	}
	
	/**
	 * 获取：报团时间
	 */
	public Date getBaotuanshijian() {
		return baotuanshijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
