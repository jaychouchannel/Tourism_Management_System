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
 * 导游
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
@TableName("daoyou")
public class DaoyouEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DaoyouEntity() {
		
	}
	
	public DaoyouEntity(T t) {
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
    @TableId
    private Long id;
	/**
	 * 导游工号
	 */
					
	private String daoyougonghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 导游姓名
	 */
					
	private String daoyouxingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 专业领域
	 */
					
	private String zhuanyelingyu;
	
	/**
	 * 语言能力
	 */
					
	private String yuyannengli;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 个人履历
	 */
					
	private String gerenlvli;
	
	/**
	 * 状态
	 */
					
	private Integer status;
	
	/**
	 * 密码错误次数
	 */
					
	private Integer passwordwrongnum;
	
	
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
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
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
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：专业领域
	 */
	public void setZhuanyelingyu(String zhuanyelingyu) {
		this.zhuanyelingyu = zhuanyelingyu;
	}
	/**
	 * 获取：专业领域
	 */
	public String getZhuanyelingyu() {
		return zhuanyelingyu;
	}
	/**
	 * 设置：语言能力
	 */
	public void setYuyannengli(String yuyannengli) {
		this.yuyannengli = yuyannengli;
	}
	/**
	 * 获取：语言能力
	 */
	public String getYuyannengli() {
		return yuyannengli;
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
	 * 设置：个人履历
	 */
	public void setGerenlvli(String gerenlvli) {
		this.gerenlvli = gerenlvli;
	}
	/**
	 * 获取：个人履历
	 */
	public String getGerenlvli() {
		return gerenlvli;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：密码错误次数
	 */
	public void setPasswordwrongnum(Integer passwordwrongnum) {
		this.passwordwrongnum = passwordwrongnum;
	}
	/**
	 * 获取：密码错误次数
	 */
	public Integer getPasswordwrongnum() {
		return passwordwrongnum;
	}

}
