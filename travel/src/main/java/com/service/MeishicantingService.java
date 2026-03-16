package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishicantingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishicantingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishicantingView;


/**
 * 美食餐厅
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface MeishicantingService extends IService<MeishicantingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishicantingVO> selectListVO(Wrapper<MeishicantingEntity> wrapper);
   	
   	MeishicantingVO selectVO(@Param("ew") Wrapper<MeishicantingEntity> wrapper);
   	
   	List<MeishicantingView> selectListView(Wrapper<MeishicantingEntity> wrapper);
   	
   	MeishicantingView selectView(@Param("ew") Wrapper<MeishicantingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishicantingEntity> wrapper);

   	

}

