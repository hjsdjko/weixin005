package com.cl.dao;

import com.cl.entity.DiscusspeizhenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusspeizhenyuanView;


/**
 * 陪诊员评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface DiscusspeizhenyuanDao extends BaseMapper<DiscusspeizhenyuanEntity> {
	
	List<DiscusspeizhenyuanView> selectListView(@Param("ew") Wrapper<DiscusspeizhenyuanEntity> wrapper);

	List<DiscusspeizhenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspeizhenyuanEntity> wrapper);
	
	DiscusspeizhenyuanView selectView(@Param("ew") Wrapper<DiscusspeizhenyuanEntity> wrapper);
	

}
