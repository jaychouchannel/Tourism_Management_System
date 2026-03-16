package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FriendEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FriendVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FriendView;


/**
 * 好友表
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface FriendService extends IService<FriendEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FriendVO> selectListVO(Wrapper<FriendEntity> wrapper);
   	
   	FriendVO selectVO(@Param("ew") Wrapper<FriendEntity> wrapper);
   	
   	List<FriendView> selectListView(Wrapper<FriendEntity> wrapper);
   	
   	FriendView selectView(@Param("ew") Wrapper<FriendEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FriendEntity> wrapper);

    PageUtils queryFriendPage(Map<String, Object> params);
   	

}

