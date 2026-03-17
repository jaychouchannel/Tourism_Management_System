package com.dao;

import com.entity.QiujiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiujiuVO;
import com.entity.view.QiujiuView;


/**
 * 求救信息
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface QiujiuDao extends BaseMapper<QiujiuEntity> {
	
	List<QiujiuVO> selectListVO(@Param("ew") Wrapper<QiujiuEntity> wrapper);
	
	QiujiuVO selectVO(@Param("ew") Wrapper<QiujiuEntity> wrapper);
	
	List<QiujiuView> selectListView(@Param("ew") Wrapper<QiujiuEntity> wrapper);

	List<QiujiuView> selectListView(Pagination page,@Param("ew") Wrapper<QiujiuEntity> wrapper);

	
	QiujiuView selectView(@Param("ew") Wrapper<QiujiuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiujiuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiujiuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiujiuEntity> wrapper);



}
