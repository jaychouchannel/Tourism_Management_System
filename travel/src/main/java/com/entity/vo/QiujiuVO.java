package com.entity.vo;

import com.entity.QiujiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 求救信息
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public class QiujiuVO implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public void setDaoyougonghao(String daoyougonghao) {
		this.daoyougonghao = daoyougonghao;
	}
	public String getDaoyougonghao() {
		return daoyougonghao;
	}

	public void setDaoyouxingming(String daoyouxingming) {
		this.daoyouxingming = daoyouxingming;
	}
	public String getDaoyouxingming() {
		return daoyouxingming;
	}

	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}

	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	public String getYonghuxingming() {
		return yonghuxingming;
	}

	public void setQiujiuneirong(String qiujiuneirong) {
		this.qiujiuneirong = qiujiuneirong;
	}
	public String getQiujiuneirong() {
		return qiujiuneirong;
	}

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	public String getLianxifangshi() {
		return lianxifangshi;
	}

	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	public String getSfsh() {
		return sfsh;
	}

	public void setHuifuneirong(String huifuneirong) {
		this.huifuneirong = huifuneirong;
	}
	public String getHuifuneirong() {
		return huifuneirong;
	}
			
}
