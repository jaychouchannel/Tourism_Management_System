package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianluleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XianluleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XianluleixingView;


/**
 * 线路类型
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface XianluleixingService extends IService<XianluleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianluleixingVO> selectListVO(Wrapper<XianluleixingEntity> wrapper);
   	
   	XianluleixingVO selectVO(@Param("ew") Wrapper<XianluleixingEntity> wrapper);
   	
   	List<XianluleixingView> selectListView(Wrapper<XianluleixingEntity> wrapper);
   	
   	XianluleixingView selectView(@Param("ew") Wrapper<XianluleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianluleixingEntity> wrapper);

   	

}

