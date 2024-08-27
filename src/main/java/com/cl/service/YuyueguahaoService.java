package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyueguahaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueguahaoView;


/**
 * 预约挂号
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface YuyueguahaoService extends IService<YuyueguahaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueguahaoView> selectListView(Wrapper<YuyueguahaoEntity> wrapper);
   	
   	YuyueguahaoView selectView(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueguahaoEntity> wrapper);
   	

}

