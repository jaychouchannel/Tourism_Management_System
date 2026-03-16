package com.entity.view;

import com.entity.FriendEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 好友表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("friend")
public class FriendView  extends FriendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FriendView(){
	}
 
 	public FriendView(FriendEntity friendEntity){
 	try {
			BeanUtils.copyProperties(this, friendEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


    private String content;

    private int notreadnum;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNotreadnum() {
        return notreadnum;
    }

    public void setNotreadnum(int notreadnum) {
        this.notreadnum = notreadnum;
    }
}
