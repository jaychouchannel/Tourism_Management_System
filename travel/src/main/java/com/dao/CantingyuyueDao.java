package com.dao;

import com.entity.CantingyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CantingyuyueVO;
import com.entity.view.CantingyuyueView;


/**
 * 餐厅预约
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface CantingyuyueDao extends BaseMapper<CantingyuyueEntity> {
	
	List<CantingyuyueVO> selectListVO(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);
	
	CantingyuyueVO selectVO(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);
	
	List<CantingyuyueView> selectListView(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);

	List<CantingyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<CantingyuyueEntity> wrapper);

	
	CantingyuyueView selectView(@Param("ew") Wrapper<CantingyuyueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CantingyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CantingyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CantingyuyueEntity> wrapper);



}
