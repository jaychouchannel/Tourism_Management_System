package com.entity.view;

import com.entity.MeishicantingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 美食餐厅
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("meishicanting")
public class MeishicantingView  extends MeishicantingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MeishicantingView(){
	}
 
 	public MeishicantingView(MeishicantingEntity meishicantingEntity){
 	try {
			BeanUtils.copyProperties(this, meishicantingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
