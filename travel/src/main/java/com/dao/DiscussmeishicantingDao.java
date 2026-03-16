package com.dao;

import com.entity.DiscussmeishicantingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmeishicantingVO;
import com.entity.view.DiscussmeishicantingView;


/**
 * 美食餐厅评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:57
 */
public interface DiscussmeishicantingDao extends BaseMapper<DiscussmeishicantingEntity> {
	
	List<DiscussmeishicantingVO> selectListVO(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);
	
	DiscussmeishicantingVO selectVO(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);
	
	List<DiscussmeishicantingView> selectListView(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);

	List<DiscussmeishicantingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);

	
	DiscussmeishicantingView selectView(@Param("ew") Wrapper<DiscussmeishicantingEntity> wrapper);
	

}
