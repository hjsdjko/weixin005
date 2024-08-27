package com.cl.dao;

import com.cl.entity.HuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuanzheView;


/**
 * 患者
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:02
 */
public interface HuanzheDao extends BaseMapper<HuanzheEntity> {
	
	List<HuanzheView> selectListView(@Param("ew") Wrapper<HuanzheEntity> wrapper);

	List<HuanzheView> selectListView(Pagination page,@Param("ew") Wrapper<HuanzheEntity> wrapper);
	
	HuanzheView selectView(@Param("ew") Wrapper<HuanzheEntity> wrapper);
	

}
