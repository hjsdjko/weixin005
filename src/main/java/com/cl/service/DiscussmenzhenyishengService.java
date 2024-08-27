package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussmenzhenyishengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussmenzhenyishengView;


/**
 * 门诊医生评论表
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
public interface DiscussmenzhenyishengService extends IService<DiscussmenzhenyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmenzhenyishengView> selectListView(Wrapper<DiscussmenzhenyishengEntity> wrapper);
   	
   	DiscussmenzhenyishengView selectView(@Param("ew") Wrapper<DiscussmenzhenyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmenzhenyishengEntity> wrapper);
   	

}

