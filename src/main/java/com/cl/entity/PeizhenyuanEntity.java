package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 陪诊员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
@TableName("peizhenyuan")
public class PeizhenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeizhenyuanEntity() {
		
	}
	
	public PeizhenyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 陪诊员账号
	 */
					
	private String peizhenyuanzhanghao;
	
	/**
	 * 登录密码
	 */
					
	private String denglumima;
	
	/**
	 * 陪诊员姓名
	 */
					
	private String peizhenyuanxingming;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 职位类型
	 */
					
	private String zhiweileixing;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：陪诊员账号
	 */
	public void setPeizhenyuanzhanghao(String peizhenyuanzhanghao) {
		this.peizhenyuanzhanghao = peizhenyuanzhanghao;
	}
	/**
	 * 获取：陪诊员账号
	 */
	public String getPeizhenyuanzhanghao() {
		return peizhenyuanzhanghao;
	}
	/**
	 * 设置：登录密码
	 */
	public void setDenglumima(String denglumima) {
		this.denglumima = denglumima;
	}
	/**
	 * 获取：登录密码
	 */
	public String getDenglumima() {
		return denglumima;
	}
	/**
	 * 设置：陪诊员姓名
	 */
	public void setPeizhenyuanxingming(String peizhenyuanxingming) {
		this.peizhenyuanxingming = peizhenyuanxingming;
	}
	/**
	 * 获取：陪诊员姓名
	 */
	public String getPeizhenyuanxingming() {
		return peizhenyuanxingming;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：职位类型
	 */
	public void setZhiweileixing(String zhiweileixing) {
		this.zhiweileixing = zhiweileixing;
	}
	/**
	 * 获取：职位类型
	 */
	public String getZhiweileixing() {
		return zhiweileixing;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
