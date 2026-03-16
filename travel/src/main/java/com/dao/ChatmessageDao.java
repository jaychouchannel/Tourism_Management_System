package com.dao;

import com.entity.ChatmessageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChatmessageVO;
import com.entity.view.ChatmessageView;


/**
 * 消息表
 * 
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface ChatmessageDao extends BaseMapper<ChatmessageEntity> {
	
	List<ChatmessageVO> selectListVO(@Param("ew") Wrapper<ChatmessageEntity> wrapper);
	
	ChatmessageVO selectVO(@Param("ew") Wrapper<ChatmessageEntity> wrapper);
	
	List<ChatmessageView> selectListView(@Param("ew") Wrapper<ChatmessageEntity> wrapper);

	List<ChatmessageView> selectListView(Pagination page,@Param("ew") Wrapper<ChatmessageEntity> wrapper);

	
	ChatmessageView selectView(@Param("ew") Wrapper<ChatmessageEntity> wrapper);
	

}
