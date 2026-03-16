package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 报团信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("baotuanxinxi")
public class BaotuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BaotuanxinxiEntity() {
		
	}
	
	public BaotuanxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 线路名称
	 */
					
	private String xianlumingcheng;
	
	/**
	 * 线路图片
	 */
					
	private String xianlutupian;
	
	/**
	 * 出发日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baotuanshijian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：线路名称
	 */
	public void setXianlumingcheng(String xianlumingcheng) {
		this.xianlumingcheng = xianlumingcheng;
	}
	/**
	 * 获取：线路名称
	 */
	public String getXianlumingcheng() {
		return xianlumingcheng;
	}
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
