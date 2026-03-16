package com.dao;

import com.entity.DaoyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaoyouVO;
import com.entity.view.DaoyouView;


/**
 * 导游
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
public interface DaoyouDao extends BaseMapper<DaoyouEntity> {
	
	List<DaoyouVO> selectListVO(@Param("ew") Wrapper<DaoyouEntity> wrapper);
	
	DaoyouVO selectVO(@Param("ew") Wrapper<DaoyouEntity> wrapper);
	
	List<DaoyouView> selectListView(@Param("ew") Wrapper<DaoyouEntity> wrapper);

	List<DaoyouView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyouEntity> wrapper);

	
	DaoyouView selectView(@Param("ew") Wrapper<DaoyouEntity> wrapper);
	

}
