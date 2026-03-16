package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CantingyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CantingyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CantingyuyueView;


/**
 * 餐厅预约
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface CantingyuyueService extends IService<CantingyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CantingyuyueVO> selectListVO(Wrapper<CantingyuyueEntity> wrapper);
   	
   	CantingyuyueVO selectVO(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);
   	
   	List<CantingyuyueView> selectListView(Wrapper<CantingyuyueEntity> wrapper);
   	
   	CantingyuyueView selectView(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CantingyuyueEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CantingyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CantingyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CantingyuyueEntity> wrapper);



}

