package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MenpiaodingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MenpiaodingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MenpiaodingdanView;


/**
 * 门票订单
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
public interface MenpiaodingdanService extends IService<MenpiaodingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenpiaodingdanVO> selectListVO(Wrapper<MenpiaodingdanEntity> wrapper);
   	
   	MenpiaodingdanVO selectVO(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);
   	
   	List<MenpiaodingdanView> selectListView(Wrapper<MenpiaodingdanEntity> wrapper);
   	
   	MenpiaodingdanView selectView(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenpiaodingdanEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<MenpiaodingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<MenpiaodingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<MenpiaodingdanEntity> wrapper);



}

