package com.dao;

import com.entity.MeishicantingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeishicantingVO;
import com.entity.view.MeishicantingView;


/**
 * 美食餐厅
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface MeishicantingDao extends BaseMapper<MeishicantingEntity> {
	
	List<MeishicantingVO> selectListVO(@Param("ew") Wrapper<MeishicantingEntity> wrapper);
	
	MeishicantingVO selectVO(@Param("ew") Wrapper<MeishicantingEntity> wrapper);
	
	List<MeishicantingView> selectListView(@Param("ew") Wrapper<MeishicantingEntity> wrapper);

	List<MeishicantingView> selectListView(Pagination page,@Param("ew") Wrapper<MeishicantingEntity> wrapper);

	
	MeishicantingView selectView(@Param("ew") Wrapper<MeishicantingEntity> wrapper);
	

}
