package com.dao;

import com.entity.MenpiaodingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MenpiaodingdanVO;
import com.entity.view.MenpiaodingdanView;


/**
 * 门票订单
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
public interface MenpiaodingdanDao extends BaseMapper<MenpiaodingdanEntity> {
	
	List<MenpiaodingdanVO> selectListVO(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);
	
	MenpiaodingdanVO selectVO(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);
	
	List<MenpiaodingdanView> selectListView(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);

	List<MenpiaodingdanView> selectListView(Pagination page,@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);

	
	MenpiaodingdanView selectView(@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaodingdanEntity> wrapper);



}
