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


import com.dao.CantingyuyueDao;
import com.entity.CantingyuyueEntity;
import com.service.CantingyuyueService;
import com.entity.vo.CantingyuyueVO;
import com.entity.view.CantingyuyueView;

@Service("cantingyuyueService")
public class CantingyuyueServiceImpl extends ServiceImpl<CantingyuyueDao, CantingyuyueEntity> implements CantingyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CantingyuyueEntity> page = this.selectPage(
                new Query<CantingyuyueEntity>(params).getPage(),
                new EntityWrapper<CantingyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CantingyuyueEntity> wrapper) {
		  Page<CantingyuyueView> page =new Query<CantingyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CantingyuyueVO> selectListVO(Wrapper<CantingyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CantingyuyueVO selectVO(Wrapper<CantingyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CantingyuyueView> selectListView(Wrapper<CantingyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CantingyuyueView selectView(Wrapper<CantingyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CantingyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CantingyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CantingyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
