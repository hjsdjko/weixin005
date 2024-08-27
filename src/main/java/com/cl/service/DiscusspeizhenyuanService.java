package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusspeizhenyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusspeizhenyuanView;


/**
 * 陪诊员评论表
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface DiscusspeizhenyuanService extends IService<DiscusspeizhenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspeizhenyuanView> selectListView(Wrapper<DiscusspeizhenyuanEntity> wrapper);
   	
   	DiscusspeizhenyuanView selectView(@Param("ew") Wrapper<DiscusspeizhenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspeizhenyuanEntity> wrapper);
   	

}

