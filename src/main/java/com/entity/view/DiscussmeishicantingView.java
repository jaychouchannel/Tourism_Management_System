package com.entity.view;

import com.entity.DiscussmeishicantingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 美食餐厅评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:57
 */
@TableName("discussmeishicanting")
public class DiscussmeishicantingView  extends DiscussmeishicantingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmeishicantingView(){
	}
 
 	public DiscussmeishicantingView(DiscussmeishicantingEntity discussmeishicantingEntity){
 	try {
			BeanUtils.copyProperties(this, discussmeishicantingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
