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


import com.cl.dao.PeizhendengjiDao;
import com.cl.entity.PeizhendengjiEntity;
import com.cl.service.PeizhendengjiService;
import com.cl.entity.view.PeizhendengjiView;

@Service("peizhendengjiService")
public class PeizhendengjiServiceImpl extends ServiceImpl<PeizhendengjiDao, PeizhendengjiEntity> implements PeizhendengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeizhendengjiEntity> page = this.selectPage(
                new Query<PeizhendengjiEntity>(params).getPage(),
                new EntityWrapper<PeizhendengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeizhendengjiEntity> wrapper) {
		  Page<PeizhendengjiView> page =new Query<PeizhendengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeizhendengjiView> selectListView(Wrapper<PeizhendengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeizhendengjiView selectView(Wrapper<PeizhendengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
