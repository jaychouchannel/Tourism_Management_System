package com.entity.view;

import com.entity.XianluleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 线路类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("xianluleixing")
public class XianluleixingView  extends XianluleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianluleixingView(){
	}
 
 	public XianluleixingView(XianluleixingEntity xianluleixingEntity){
 	try {
			BeanUtils.copyProperties(this, xianluleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
