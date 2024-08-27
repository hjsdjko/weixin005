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


import com.cl.dao.DiscusspeizhenyuanDao;
import com.cl.entity.DiscusspeizhenyuanEntity;
import com.cl.service.DiscusspeizhenyuanService;
import com.cl.entity.view.DiscusspeizhenyuanView;

@Service("discusspeizhenyuanService")
public class DiscusspeizhenyuanServiceImpl extends ServiceImpl<DiscusspeizhenyuanDao, DiscusspeizhenyuanEntity> implements DiscusspeizhenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspeizhenyuanEntity> page = this.selectPage(
                new Query<DiscusspeizhenyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusspeizhenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspeizhenyuanEntity> wrapper) {
		  Page<DiscusspeizhenyuanView> page =new Query<DiscusspeizhenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusspeizhenyuanView> selectListView(Wrapper<DiscusspeizhenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspeizhenyuanView selectView(Wrapper<DiscusspeizhenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
