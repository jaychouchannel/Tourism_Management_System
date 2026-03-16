package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussmeishicantingDao;
import com.entity.DiscussmeishicantingEntity;
import com.service.DiscussmeishicantingService;
import com.entity.vo.DiscussmeishicantingVO;
import com.entity.view.DiscussmeishicantingView;

@Service("discussmeishicantingService")
public class DiscussmeishicantingServiceImpl extends ServiceImpl<DiscussmeishicantingDao, DiscussmeishicantingEntity> implements DiscussmeishicantingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmeishicantingEntity> page = this.selectPage(
                new Query<DiscussmeishicantingEntity>(params).getPage(),
                new EntityWrapper<DiscussmeishicantingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmeishicantingEntity> wrapper) {
		  Page<DiscussmeishicantingView> page =new Query<DiscussmeishicantingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussmeishicantingVO> selectListVO(Wrapper<DiscussmeishicantingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmeishicantingVO selectVO(Wrapper<DiscussmeishicantingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmeishicantingView> selectListView(Wrapper<DiscussmeishicantingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmeishicantingView selectView(Wrapper<DiscussmeishicantingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
