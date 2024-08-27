package com.cl.entity.view;

import com.cl.entity.PeizhendengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 陪诊等级
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
@TableName("peizhendengji")
public class PeizhendengjiView  extends PeizhendengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeizhendengjiView(){
	}
 
 	public PeizhendengjiView(PeizhendengjiEntity peizhendengjiEntity){
 	try {
			BeanUtils.copyProperties(this, peizhendengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
