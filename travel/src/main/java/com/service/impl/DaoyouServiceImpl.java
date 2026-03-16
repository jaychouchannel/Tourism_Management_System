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


import com.dao.DaoyouDao;
import com.entity.DaoyouEntity;
import com.service.DaoyouService;
import com.entity.vo.DaoyouVO;
import com.entity.view.DaoyouView;

@Service("daoyouService")
public class DaoyouServiceImpl extends ServiceImpl<DaoyouDao, DaoyouEntity> implements DaoyouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoyouEntity> page = this.selectPage(
                new Query<DaoyouEntity>(params).getPage(),
                new EntityWrapper<DaoyouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoyouEntity> wrapper) {
		  Page<DaoyouView> page =new Query<DaoyouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DaoyouVO> selectListVO(Wrapper<DaoyouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaoyouVO selectVO(Wrapper<DaoyouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaoyouView> selectListView(Wrapper<DaoyouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoyouView selectView(Wrapper<DaoyouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
