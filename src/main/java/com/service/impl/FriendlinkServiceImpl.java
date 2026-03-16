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


import com.dao.FriendlinkDao;
import com.entity.FriendlinkEntity;
import com.service.FriendlinkService;
import com.entity.vo.FriendlinkVO;
import com.entity.view.FriendlinkView;

@Service("friendlinkService")
public class FriendlinkServiceImpl extends ServiceImpl<FriendlinkDao, FriendlinkEntity> implements FriendlinkService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FriendlinkEntity> page = this.selectPage(
                new Query<FriendlinkEntity>(params).getPage(),
                new EntityWrapper<FriendlinkEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FriendlinkEntity> wrapper) {
		  Page<FriendlinkView> page =new Query<FriendlinkView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FriendlinkVO> selectListVO(Wrapper<FriendlinkEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FriendlinkVO selectVO(Wrapper<FriendlinkEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FriendlinkView> selectListView(Wrapper<FriendlinkEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FriendlinkView selectView(Wrapper<FriendlinkEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
