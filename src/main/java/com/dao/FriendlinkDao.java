package com.dao;

import com.entity.FriendlinkEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FriendlinkVO;
import com.entity.view.FriendlinkView;


/**
 * 友情链接
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface FriendlinkDao extends BaseMapper<FriendlinkEntity> {
	
	List<FriendlinkVO> selectListVO(@Param("ew") Wrapper<FriendlinkEntity> wrapper);
	
	FriendlinkVO selectVO(@Param("ew") Wrapper<FriendlinkEntity> wrapper);
	
	List<FriendlinkView> selectListView(@Param("ew") Wrapper<FriendlinkEntity> wrapper);

	List<FriendlinkView> selectListView(Pagination page,@Param("ew") Wrapper<FriendlinkEntity> wrapper);

	
	FriendlinkView selectView(@Param("ew") Wrapper<FriendlinkEntity> wrapper);
	

}
