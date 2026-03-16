package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmeishicantingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmeishicantingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmeishicantingView;


/**
 * 美食餐厅评论表
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:57
 */
public interface DiscussmeishicantingService extends IService<DiscussmeishicantingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishicantingVO> selectListVO(Wrapper<DiscussmeishicantingEntity> wrapper);
   	
   	DiscussmeishicantingVO selectVO(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);
   	
   	List<DiscussmeishicantingView> selectListView(Wrapper<DiscussmeishicantingEntity> wrapper);
   	
   	DiscussmeishicantingView selectView(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishicantingEntity> wrapper);

   	

}

