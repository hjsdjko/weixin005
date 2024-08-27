package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeizhenyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeizhenyuanView;


/**
 * 陪诊员
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface PeizhenyuanService extends IService<PeizhenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeizhenyuanView> selectListView(Wrapper<PeizhenyuanEntity> wrapper);
   	
   	PeizhenyuanView selectView(@Param("ew") Wrapper<PeizhenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeizhenyuanEntity> wrapper);
   	

}

