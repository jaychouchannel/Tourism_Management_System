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


import com.dao.MenpiaodingdanDao;
import com.entity.MenpiaodingdanEntity;
import com.service.MenpiaodingdanService;
import com.entity.vo.MenpiaodingdanVO;
import com.entity.view.MenpiaodingdanView;

@Service("menpiaodingdanService")
public class MenpiaodingdanServiceImpl extends ServiceImpl<MenpiaodingdanDao, MenpiaodingdanEntity> implements MenpiaodingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenpiaodingdanEntity> page = this.selectPage(
                new Query<MenpiaodingdanEntity>(params).getPage(),
                new EntityWrapper<MenpiaodingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MenpiaodingdanEntity> wrapper) {
		  Page<MenpiaodingdanView> page =new Query<MenpiaodingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MenpiaodingdanVO> selectListVO(Wrapper<MenpiaodingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MenpiaodingdanVO selectVO(Wrapper<MenpiaodingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MenpiaodingdanView> selectListView(Wrapper<MenpiaodingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MenpiaodingdanView selectView(Wrapper<MenpiaodingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<MenpiaodingdanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<MenpiaodingdanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<MenpiaodingdanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
