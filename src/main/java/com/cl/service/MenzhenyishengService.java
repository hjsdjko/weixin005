package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MenzhenyishengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenzhenyishengView;


/**
 * 门诊医生
 *
 * @author 
 * @email 
 * @date 2024-04-28 14:57:02
 */
public interface MenzhenyishengService extends IService<MenzhenyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenzhenyishengView> selectListView(Wrapper<MenzhenyishengEntity> wrapper);
   	
   	MenzhenyishengView selectView(@Param("ew") Wrapper<MenzhenyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenzhenyishengEntity> wrapper);
   	

}

