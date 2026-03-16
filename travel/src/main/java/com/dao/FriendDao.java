package com.dao;

import com.entity.FriendEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FriendVO;
import com.entity.view.FriendView;


/**
 * 好友表
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface FriendDao extends BaseMapper<FriendEntity> {
	
	List<FriendVO> selectListVO(@Param("ew") Wrapper<FriendEntity> wrapper);
	
	FriendVO selectVO(@Param("ew") Wrapper<FriendEntity> wrapper);
	
	List<FriendView> selectListView(@Param("ew") Wrapper<FriendEntity> wrapper);

	List<FriendView> selectListView(Pagination page,@Param("ew") Wrapper<FriendEntity> wrapper);

    List<FriendView> selectFriendListView(Pagination page, Map<String, Object> params);
	
	FriendView selectView(@Param("ew") Wrapper<FriendEntity> wrapper);
	

}
