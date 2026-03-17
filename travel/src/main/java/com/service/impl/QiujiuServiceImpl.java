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


import com.dao.QiujiuDao;
import com.entity.QiujiuEntity;
import com.service.QiujiuService;
import com.entity.vo.QiujiuVO;
import com.entity.view.QiujiuView;

@Service("qiujiuService")
public class QiujiuServiceImpl extends ServiceImpl<QiujiuDao, QiujiuEntity> implements QiujiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiujiuEntity> page = this.selectPage(
                new Query<QiujiuEntity>(params).getPage(),
                new EntityWrapper<QiujiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiujiuEntity> wrapper) {
		  Page<QiujiuView> page =new Query<QiujiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QiujiuVO> selectListVO(Wrapper<QiujiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiujiuVO selectVO(Wrapper<QiujiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiujiuView> selectListView(Wrapper<QiujiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiujiuView selectView(Wrapper<QiujiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QiujiuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QiujiuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QiujiuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
