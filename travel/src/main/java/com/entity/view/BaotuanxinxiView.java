package com.entity.view;

import com.entity.BaotuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 报团信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@TableName("baotuanxinxi")
public class BaotuanxinxiView  extends BaotuanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaotuanxinxiView(){
	}
 
 	public BaotuanxinxiView(BaotuanxinxiEntity baotuanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, baotuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
