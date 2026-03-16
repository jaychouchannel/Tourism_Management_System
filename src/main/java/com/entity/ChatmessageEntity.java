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
 * 消息表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("chatmessage")
public class ChatmessageEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChatmessageEntity() {
		
	}
	
	public ChatmessageEntity(T t) {
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
	 * 用户ID
	 */
					
	private Long uid;
	
	/**
	 * 好友用户ID
	 */
					
	private Long fid;
	
	/**
	 * 内容
	 */
					
	private String content;
	
	/**
	 * 格式(1:文字，2:图片)
	 */
					
	private Integer format;
	
	/**
	 * 消息已读(0:未读，1:已读)
	 */
					
	private Integer isread;
	
	
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
	 * 设置：用户ID
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUid() {
		return uid;
	}
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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：格式(1:文字，2:图片)
	 */
	public void setFormat(Integer format) {
		this.format = format;
	}
	/**
	 * 获取：格式(1:文字，2:图片)
	 */
	public Integer getFormat() {
		return format;
	}
	/**
	 * 设置：消息已读(0:未读，1:已读)
	 */
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	/**
	 * 获取：消息已读(0:未读，1:已读)
	 */
	public Integer getIsread() {
		return isread;
	}

}
