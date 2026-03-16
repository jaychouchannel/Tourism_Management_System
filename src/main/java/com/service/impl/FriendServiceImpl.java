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


import com.dao.FriendDao;
import com.entity.FriendEntity;
import com.service.FriendService;
import com.entity.vo.FriendVO;
import com.entity.view.FriendView;

@Service("friendService")
public class FriendServiceImpl extends ServiceImpl<FriendDao, FriendEntity> implements FriendService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FriendEntity> page = this.selectPage(
                new Query<FriendEntity>(params).getPage(),
                new EntityWrapper<FriendEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FriendEntity> wrapper) {
		  Page<FriendView> page =new Query<FriendView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
    public PageUtils queryFriendPage(Map<String, Object> params) {
        Page<FriendView> page =new Query<FriendView>(params).getPage();
        page.setRecords(baseMapper.selectFriendListView(page, params));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
    
    @Override
	public List<FriendVO> selectListVO(Wrapper<FriendEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FriendVO selectVO(Wrapper<FriendEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FriendView> selectListView(Wrapper<FriendEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FriendView selectView(Wrapper<FriendEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
