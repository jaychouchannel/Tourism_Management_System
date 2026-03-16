package com.dao;

import com.entity.BaotuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaotuanxinxiVO;
import com.entity.view.BaotuanxinxiView;


/**
 * 报团信息
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface BaotuanxinxiDao extends BaseMapper<BaotuanxinxiEntity> {
	
	List<BaotuanxinxiVO> selectListVO(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);
	
	BaotuanxinxiVO selectVO(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);
	
	List<BaotuanxinxiView> selectListView(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);

	List<BaotuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);

	
	BaotuanxinxiView selectView(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);



}
