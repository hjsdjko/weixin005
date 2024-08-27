package com.cl.dao;

import com.cl.entity.DiscussmenzhenyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussmenzhenyishengView;


/**
 * 门诊医生评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface DiscussmenzhenyishengDao extends BaseMapper<DiscussmenzhenyishengEntity> {
	
	List<DiscussmenzhenyishengView> selectListView(@Param("ew") Wrapper<DiscussmenzhenyishengEntity> wrapper);

	List<DiscussmenzhenyishengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmenzhenyishengEntity> wrapper);
	
	DiscussmenzhenyishengView selectView(@Param("ew") Wrapper<DiscussmenzhenyishengEntity> wrapper);
	

}
