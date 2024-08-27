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


import com.cl.dao.PeizhenyuanDao;
import com.cl.entity.PeizhenyuanEntity;
import com.cl.service.PeizhenyuanService;
import com.cl.entity.view.PeizhenyuanView;

@Service("peizhenyuanService")
public class PeizhenyuanServiceImpl extends ServiceImpl<PeizhenyuanDao, PeizhenyuanEntity> implements PeizhenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeizhenyuanEntity> page = this.selectPage(
                new Query<PeizhenyuanEntity>(params).getPage(),
                new EntityWrapper<PeizhenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeizhenyuanEntity> wrapper) {
		  Page<PeizhenyuanView> page =new Query<PeizhenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeizhenyuanView> selectListView(Wrapper<PeizhenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeizhenyuanView selectView(Wrapper<PeizhenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
