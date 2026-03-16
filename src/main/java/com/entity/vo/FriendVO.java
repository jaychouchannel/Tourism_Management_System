package com.entity.vo;

import com.entity.FriendEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 好友表
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public class FriendVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 好友用户ID
	 */
	
	private Long fid;
		
	/**
	 * 名称
	 */
	
	private String name;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 角色
	 */
	
	private String role;
		
	/**
	 * 表名
	 */
	
	private String tablename;
		
	/**
	 * 别名
	 */
	
	private String alias;
		
	/**
	 * 类型(0:好友申请，1:好友，2:消息)
	 */
	
	private Integer type;
				
	
	/**
	 * 设置：好友用户ID
	 */
	 
	public void setFid(Long fid) {
		this.fid = fid;
	}
	
	/**
	 * 获取：好友用户ID
	 */
	public Long getFid() {
		return fid;
	}
				
	
	/**
	 * 设置：名称
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：角色
	 */
	 
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * 获取：角色
	 */
	public String getRole() {
		return role;
	}
				
	
	/**
	 * 设置：表名
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 获取：表名
	 */
	public String getTablename() {
		return tablename;
	}
				
	
	/**
	 * 设置：别名
	 */
	 
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 获取：别名
	 */
	public String getAlias() {
		return alias;
	}
				
	
	/**
	 * 设置：类型(0:好友申请，1:好友，2:消息)
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型(0:好友申请，1:好友，2:消息)
	 */
	public Integer getType() {
		return type;
	}
			
}
