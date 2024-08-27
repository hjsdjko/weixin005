package com.cl.entity.view;

import com.cl.entity.DiscussmenzhenyishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 门诊医生评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
@TableName("discussmenzhenyisheng")
public class DiscussmenzhenyishengView  extends DiscussmenzhenyishengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmenzhenyishengView(){
	}
 
 	public DiscussmenzhenyishengView(DiscussmenzhenyishengEntity discussmenzhenyishengEntity){
 	try {
			BeanUtils.copyProperties(this, discussmenzhenyishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
