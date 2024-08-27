package com.cl.dao;

import com.cl.entity.PeizhendengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeizhendengjiView;


/**
 * 陪诊等级
 * 
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface PeizhendengjiDao extends BaseMapper<PeizhendengjiEntity> {
	
	List<PeizhendengjiView> selectListView(@Param("ew") Wrapper<PeizhendengjiEntity> wrapper);

	List<PeizhendengjiView> selectListView(Pagination page,@Param("ew") Wrapper<PeizhendengjiEntity> wrapper);
	
	PeizhendengjiView selectView(@Param("ew") Wrapper<PeizhendengjiEntity> wrapper);
	

}
