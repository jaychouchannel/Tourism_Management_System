package com.dao;

import com.entity.LvyougonglveEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LvyougonglveVO;
import com.entity.view.LvyougonglveView;


/**
 * 旅游攻略
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface LvyougonglveDao extends BaseMapper<LvyougonglveEntity> {
	
	List<LvyougonglveVO> selectListVO(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
	
	LvyougonglveVO selectVO(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
	
	List<LvyougonglveView> selectListView(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);

	List<LvyougonglveView> selectListView(Pagination page,@Param("ew") Wrapper<LvyougonglveEntity> wrapper);

	
	LvyougonglveView selectView(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
	

}
