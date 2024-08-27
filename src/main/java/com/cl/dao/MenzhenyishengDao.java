package com.cl.dao;

import com.cl.entity.MenzhenyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenzhenyishengView;


/**
 * 门诊医生
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:02
 */
public interface MenzhenyishengDao extends BaseMapper<MenzhenyishengEntity> {
	
	List<MenzhenyishengView> selectListView(@Param("ew") Wrapper<MenzhenyishengEntity> wrapper);

	List<MenzhenyishengView> selectListView(Pagination page,@Param("ew") Wrapper<MenzhenyishengEntity> wrapper);
	
	MenzhenyishengView selectView(@Param("ew") Wrapper<MenzhenyishengEntity> wrapper);
	

}
