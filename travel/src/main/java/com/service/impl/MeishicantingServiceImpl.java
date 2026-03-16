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


import com.dao.MeishicantingDao;
import com.entity.MeishicantingEntity;
import com.service.MeishicantingService;
import com.entity.vo.MeishicantingVO;
import com.entity.view.MeishicantingView;

@Service("meishicantingService")
public class MeishicantingServiceImpl extends ServiceImpl<MeishicantingDao, MeishicantingEntity> implements MeishicantingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishicantingEntity> page = this.selectPage(
                new Query<MeishicantingEntity>(params).getPage(),
                new EntityWrapper<MeishicantingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishicantingEntity> wrapper) {
		  Page<MeishicantingView> page =new Query<MeishicantingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MeishicantingVO> selectListVO(Wrapper<MeishicantingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishicantingVO selectVO(Wrapper<MeishicantingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishicantingView> selectListView(Wrapper<MeishicantingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishicantingView selectView(Wrapper<MeishicantingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
