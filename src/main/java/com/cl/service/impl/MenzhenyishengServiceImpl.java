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


import com.cl.dao.MenzhenyishengDao;
import com.cl.entity.MenzhenyishengEntity;
import com.cl.service.MenzhenyishengService;
import com.cl.entity.view.MenzhenyishengView;

@Service("menzhenyishengService")
public class MenzhenyishengServiceImpl extends ServiceImpl<MenzhenyishengDao, MenzhenyishengEntity> implements MenzhenyishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenzhenyishengEntity> page = this.selectPage(
                new Query<MenzhenyishengEntity>(params).getPage(),
                new EntityWrapper<MenzhenyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MenzhenyishengEntity> wrapper) {
		  Page<MenzhenyishengView> page =new Query<MenzhenyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MenzhenyishengView> selectListView(Wrapper<MenzhenyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MenzhenyishengView selectView(Wrapper<MenzhenyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
