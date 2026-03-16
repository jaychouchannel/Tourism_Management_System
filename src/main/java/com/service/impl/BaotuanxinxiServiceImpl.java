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


import com.dao.BaotuanxinxiDao;
import com.entity.BaotuanxinxiEntity;
import com.service.BaotuanxinxiService;
import com.entity.vo.BaotuanxinxiVO;
import com.entity.view.BaotuanxinxiView;

@Service("baotuanxinxiService")
public class BaotuanxinxiServiceImpl extends ServiceImpl<BaotuanxinxiDao, BaotuanxinxiEntity> implements BaotuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaotuanxinxiEntity> page = this.selectPage(
                new Query<BaotuanxinxiEntity>(params).getPage(),
                new EntityWrapper<BaotuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaotuanxinxiEntity> wrapper) {
		  Page<BaotuanxinxiView> page =new Query<BaotuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BaotuanxinxiVO> selectListVO(Wrapper<BaotuanxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaotuanxinxiVO selectVO(Wrapper<BaotuanxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaotuanxinxiView> selectListView(Wrapper<BaotuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaotuanxinxiView selectView(Wrapper<BaotuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<BaotuanxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<BaotuanxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<BaotuanxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
