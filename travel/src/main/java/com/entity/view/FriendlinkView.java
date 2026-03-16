package com.entity.view;

import com.entity.FriendlinkEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 友情链接
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("friendlink")
public class FriendlinkView  extends FriendlinkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FriendlinkView(){
	}
 
 	public FriendlinkView(FriendlinkEntity friendlinkEntity){
 	try {
			BeanUtils.copyProperties(this, friendlinkEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
