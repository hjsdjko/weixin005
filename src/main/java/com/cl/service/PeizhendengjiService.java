package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeizhendengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeizhendengjiView;


/**
 * 陪诊等级
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface PeizhendengjiService extends IService<PeizhendengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeizhendengjiView> selectListView(Wrapper<PeizhendengjiEntity> wrapper);
   	
   	PeizhendengjiView selectView(@Param("ew") Wrapper<PeizhendengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeizhendengjiEntity> wrapper);
   	

}

