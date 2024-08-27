package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.PeizhendengjiEntity;
import com.cl.entity.view.PeizhendengjiView;

import com.cl.service.PeizhendengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 陪诊等级
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
@RestController
@RequestMapping("/peizhendengji")
public class PeizhendengjiController {
    @Autowired
    private PeizhendengjiService peizhendengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeizhendengjiEntity peizhendengji,
		HttpServletRequest request){
        EntityWrapper<PeizhendengjiEntity> ew = new EntityWrapper<PeizhendengjiEntity>();

		PageUtils page = peizhendengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peizhendengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeizhendengjiEntity peizhendengji, 
		HttpServletRequest request){
        EntityWrapper<PeizhendengjiEntity> ew = new EntityWrapper<PeizhendengjiEntity>();

		PageUtils page = peizhendengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peizhendengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeizhendengjiEntity peizhendengji){
       	EntityWrapper<PeizhendengjiEntity> ew = new EntityWrapper<PeizhendengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peizhendengji, "peizhendengji")); 
        return R.ok().put("data", peizhendengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeizhendengjiEntity peizhendengji){
        EntityWrapper< PeizhendengjiEntity> ew = new EntityWrapper< PeizhendengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peizhendengji, "peizhendengji")); 
		PeizhendengjiView peizhendengjiView =  peizhendengjiService.selectView(ew);
		return R.ok("查询陪诊等级成功").put("data", peizhendengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeizhendengjiEntity peizhendengji = peizhendengjiService.selectById(id);
		peizhendengji = peizhendengjiService.selectView(new EntityWrapper<PeizhendengjiEntity>().eq("id", id));
        return R.ok().put("data", peizhendengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeizhendengjiEntity peizhendengji = peizhendengjiService.selectById(id);
		peizhendengji = peizhendengjiService.selectView(new EntityWrapper<PeizhendengjiEntity>().eq("id", id));
        return R.ok().put("data", peizhendengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeizhendengjiEntity peizhendengji, HttpServletRequest request){
        if(peizhendengjiService.selectCount(new EntityWrapper<PeizhendengjiEntity>().eq("peizhendengji", peizhendengji.getPeizhendengji()))>0) {
            return R.error("陪诊等级已存在");
        }
    	peizhendengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peizhendengji);
        peizhendengjiService.insert(peizhendengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeizhendengjiEntity peizhendengji, HttpServletRequest request){
        if(peizhendengjiService.selectCount(new EntityWrapper<PeizhendengjiEntity>().eq("peizhendengji", peizhendengji.getPeizhendengji()))>0) {
            return R.error("陪诊等级已存在");
        }
    	peizhendengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peizhendengji);
        peizhendengjiService.insert(peizhendengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeizhendengjiEntity peizhendengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peizhendengji);
        peizhendengjiService.updateById(peizhendengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peizhendengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
