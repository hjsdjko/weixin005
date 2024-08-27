package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuanzheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuanzheView;


/**
 * 患者
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:02
 */
public interface HuanzheService extends IService<HuanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuanzheView> selectListView(Wrapper<HuanzheEntity> wrapper);
   	
   	HuanzheView selectView(@Param("ew") Wrapper<HuanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuanzheEntity> wrapper);
   	

}

