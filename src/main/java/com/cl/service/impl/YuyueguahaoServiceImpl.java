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


import com.cl.dao.YuyueguahaoDao;
import com.cl.entity.YuyueguahaoEntity;
import com.cl.service.YuyueguahaoService;
import com.cl.entity.view.YuyueguahaoView;

@Service("yuyueguahaoService")
public class YuyueguahaoServiceImpl extends ServiceImpl<YuyueguahaoDao, YuyueguahaoEntity> implements YuyueguahaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueguahaoEntity> page = this.selectPage(
                new Query<YuyueguahaoEntity>(params).getPage(),
                new EntityWrapper<YuyueguahaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueguahaoEntity> wrapper) {
		  Page<YuyueguahaoView> page =new Query<YuyueguahaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyueguahaoView> selectListView(Wrapper<YuyueguahaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueguahaoView selectView(Wrapper<YuyueguahaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
