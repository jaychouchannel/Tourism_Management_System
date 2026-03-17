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
 * 求救信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("qiujiu")
public class QiujiuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QiujiuEntity() {
		
	}
	
	public QiujiuEntity(T t) {
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
	 * 导游工号
	 */
	private String daoyougonghao;
	
	/**
	 * 导游姓名
	 */
	private String daoyouxingming;
	
	/**
	 * 用户账号
	 */
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
	private String yonghuxingming;
	
	/**
	 * 求救内容
	 */
	private String qiujiuneirong;
	
	/**
	 * 联系方式
	 */
	private String lianxifangshi;
	
	/**
	 * 是否处理
	 */
	private String sfsh;
	
	/**
	 * 回复内容
	 */
	private String huifuneirong;
	
	
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
	 * 设置：求救内容
	 */
	public void setQiujiuneirong(String qiujiuneirong) {
		this.qiujiuneirong = qiujiuneirong;
	}
	/**
	 * 获取：求救内容
	 */
	public String getQiujiuneirong() {
		return qiujiuneirong;
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
	 * 设置：是否处理
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否处理
	 */
	public String getSfsh() {
		return sfsh;
	}

	/**
	 * 设置：回复内容
	 */
	public void setHuifuneirong(String huifuneirong) {
		this.huifuneirong = huifuneirong;
	}
	/**
	 * 获取：回复内容
	 */
	public String getHuifuneirong() {
		return huifuneirong;
	}

}
