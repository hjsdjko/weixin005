package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussmenzhenyishengDao;
import com.cl.entity.DiscussmenzhenyishengEntity;
import com.cl.service.DiscussmenzhenyishengService;
import com.cl.entity.view.DiscussmenzhenyishengView;

@Service("discussmenzhenyishengService")
public class DiscussmenzhenyishengServiceImpl extends ServiceImpl<DiscussmenzhenyishengDao, DiscussmenzhenyishengEntity> implements DiscussmenzhenyishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmenzhenyishengEntity> page = this.selectPage(
                new Query<DiscussmenzhenyishengEntity>(params).getPage(),
                new EntityWrapper<DiscussmenzhenyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmenzhenyishengEntity> wrapper) {
		  Page<DiscussmenzhenyishengView> page =new Query<DiscussmenzhenyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussmenzhenyishengView> selectListView(Wrapper<DiscussmenzhenyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmenzhenyishengView selectView(Wrapper<DiscussmenzhenyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
