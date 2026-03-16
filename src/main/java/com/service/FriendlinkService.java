package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FriendlinkEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FriendlinkVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FriendlinkView;


/**
 * 友情链接
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface FriendlinkService extends IService<FriendlinkEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FriendlinkVO> selectListVO(Wrapper<FriendlinkEntity> wrapper);
   	
   	FriendlinkVO selectVO(@Param("ew") Wrapper<FriendlinkEntity> wrapper);
   	
   	List<FriendlinkView> selectListView(Wrapper<FriendlinkEntity> wrapper);
   	
   	FriendlinkView selectView(@Param("ew") Wrapper<FriendlinkEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FriendlinkEntity> wrapper);

   	

}

