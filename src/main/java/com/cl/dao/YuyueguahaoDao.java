package com.cl.dao;

import com.cl.entity.YuyueguahaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueguahaoView;


/**
 * 预约挂号
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface YuyueguahaoDao extends BaseMapper<YuyueguahaoEntity> {
	
	List<YuyueguahaoView> selectListView(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);

	List<YuyueguahaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	
	YuyueguahaoView selectView(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	

}
