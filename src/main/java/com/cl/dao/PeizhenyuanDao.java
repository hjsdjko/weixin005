package com.cl.dao;

import com.cl.entity.PeizhenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeizhenyuanView;


/**
 * 陪诊员
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface PeizhenyuanDao extends BaseMapper<PeizhenyuanEntity> {
	
	List<PeizhenyuanView> selectListView(@Param("ew") Wrapper<PeizhenyuanEntity> wrapper);

	List<PeizhenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PeizhenyuanEntity> wrapper);
	
	PeizhenyuanView selectView(@Param("ew") Wrapper<PeizhenyuanEntity> wrapper);
	

}
