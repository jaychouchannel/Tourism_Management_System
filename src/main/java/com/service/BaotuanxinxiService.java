package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaotuanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaotuanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaotuanxinxiView;


/**
 * 报团信息
 *
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
public interface BaotuanxinxiService extends IService<BaotuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaotuanxinxiVO> selectListVO(Wrapper<BaotuanxinxiEntity> wrapper);
   	
   	BaotuanxinxiVO selectVO(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);
   	
   	List<BaotuanxinxiView> selectListView(Wrapper<BaotuanxinxiEntity> wrapper);
   	
   	BaotuanxinxiView selectView(@Param("ew") Wrapper<BaotuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaotuanxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BaotuanxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BaotuanxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BaotuanxinxiEntity> wrapper);



}

