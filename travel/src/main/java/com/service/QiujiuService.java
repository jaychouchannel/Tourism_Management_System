package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiujiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiujiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiujiuView;


/**
 * 求救信息
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface QiujiuService extends IService<QiujiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiujiuVO> selectListVO(Wrapper<QiujiuEntity> wrapper);
   	
   	QiujiuVO selectVO(@Param("ew") Wrapper<QiujiuEntity> wrapper);
   	
   	List<QiujiuView> selectListView(Wrapper<QiujiuEntity> wrapper);
   	
   	QiujiuView selectView(@Param("ew") Wrapper<QiujiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiujiuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QiujiuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QiujiuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QiujiuEntity> wrapper);



}
