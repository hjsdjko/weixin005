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

import com.cl.entity.MenzhenyishengEntity;
import com.cl.entity.view.MenzhenyishengView;

import com.cl.service.MenzhenyishengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 门诊医生
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-28 14:57:02
 */
@RestController
@RequestMapping("/menzhenyisheng")
public class MenzhenyishengController {
    @Autowired
    private MenzhenyishengService menzhenyishengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MenzhenyishengEntity menzhenyisheng,
                @RequestParam(required = false) Double renshustart,
                @RequestParam(required = false) Double renshuend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		menzhenyisheng.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			menzhenyisheng.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MenzhenyishengEntity> ew = new EntityWrapper<MenzhenyishengEntity>();
                if(renshustart!=null) ew.ge("renshu", renshustart);
                if(renshuend!=null) ew.le("renshu", renshuend);

		PageUtils page = menzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menzhenyisheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MenzhenyishengEntity menzhenyisheng, 
                @RequestParam(required = false) Double renshustart,
                @RequestParam(required = false) Double renshuend,
		HttpServletRequest request){
        EntityWrapper<MenzhenyishengEntity> ew = new EntityWrapper<MenzhenyishengEntity>();
                if(renshustart!=null) ew.ge("renshu", renshustart);
                if(renshuend!=null) ew.le("renshu", renshuend);

		PageUtils page = menzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menzhenyisheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MenzhenyishengEntity menzhenyisheng){
       	EntityWrapper<MenzhenyishengEntity> ew = new EntityWrapper<MenzhenyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( menzhenyisheng, "menzhenyisheng")); 
        return R.ok().put("data", menzhenyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MenzhenyishengEntity menzhenyisheng){
        EntityWrapper< MenzhenyishengEntity> ew = new EntityWrapper< MenzhenyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( menzhenyisheng, "menzhenyisheng")); 
		MenzhenyishengView menzhenyishengView =  menzhenyishengService.selectView(ew);
		return R.ok("查询门诊医生成功").put("data", menzhenyishengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MenzhenyishengEntity menzhenyisheng = menzhenyishengService.selectById(id);
		menzhenyisheng = menzhenyishengService.selectView(new EntityWrapper<MenzhenyishengEntity>().eq("id", id));
        return R.ok().put("data", menzhenyisheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MenzhenyishengEntity menzhenyisheng = menzhenyishengService.selectById(id);
		menzhenyisheng = menzhenyishengService.selectView(new EntityWrapper<MenzhenyishengEntity>().eq("id", id));
        return R.ok().put("data", menzhenyisheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MenzhenyishengEntity menzhenyisheng, HttpServletRequest request){
    	menzhenyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(menzhenyisheng);
    	menzhenyisheng.setUserid((Long)request.getSession().getAttribute("userId"));
        menzhenyishengService.insert(menzhenyisheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MenzhenyishengEntity menzhenyisheng, HttpServletRequest request){
    	menzhenyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(menzhenyisheng);
        menzhenyishengService.insert(menzhenyisheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MenzhenyishengEntity menzhenyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(menzhenyisheng);
        menzhenyishengService.updateById(menzhenyisheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        menzhenyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
