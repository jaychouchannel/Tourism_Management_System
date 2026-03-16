package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChatmessageEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChatmessageVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChatmessageView;


/**
 * 消息表
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface ChatmessageService extends IService<ChatmessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChatmessageVO> selectListVO(Wrapper<ChatmessageEntity> wrapper);
   	
   	ChatmessageVO selectVO(@Param("ew") Wrapper<ChatmessageEntity> wrapper);
   	
   	List<ChatmessageView> selectListView(Wrapper<ChatmessageEntity> wrapper);
   	
   	ChatmessageView selectView(@Param("ew") Wrapper<ChatmessageEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChatmessageEntity> wrapper);

   	

}

