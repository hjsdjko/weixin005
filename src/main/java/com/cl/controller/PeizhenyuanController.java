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

import com.cl.entity.PeizhenyuanEntity;
import com.cl.entity.view.PeizhenyuanView;

import com.cl.service.PeizhenyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 陪诊员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-28 14:57:03
 */
@RestController
@RequestMapping("/peizhenyuan")
public class PeizhenyuanController {
    @Autowired
    private PeizhenyuanService peizhenyuanService;

    @Autowired
    private StoreupService storeupService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PeizhenyuanEntity u = peizhenyuanService.selectOne(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", username));
        if(u==null || !u.getDenglumima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"peizhenyuan",  "陪诊员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PeizhenyuanEntity peizhenyuan){
    	//ValidatorUtils.validateEntity(peizhenyuan);
    	PeizhenyuanEntity u = peizhenyuanService.selectOne(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", peizhenyuan.getPeizhenyuanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		peizhenyuan.setId(uId);
        peizhenyuanService.insert(peizhenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        PeizhenyuanEntity u = peizhenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PeizhenyuanEntity u = peizhenyuanService.selectOne(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setDenglumima("123456");
        peizhenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeizhenyuanEntity peizhenyuan,
		HttpServletRequest request){
        EntityWrapper<PeizhenyuanEntity> ew = new EntityWrapper<PeizhenyuanEntity>();

		PageUtils page = peizhenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peizhenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeizhenyuanEntity peizhenyuan, 
		HttpServletRequest request){
        EntityWrapper<PeizhenyuanEntity> ew = new EntityWrapper<PeizhenyuanEntity>();

		PageUtils page = peizhenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peizhenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeizhenyuanEntity peizhenyuan){
       	EntityWrapper<PeizhenyuanEntity> ew = new EntityWrapper<PeizhenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peizhenyuan, "peizhenyuan")); 
        return R.ok().put("data", peizhenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeizhenyuanEntity peizhenyuan){
        EntityWrapper< PeizhenyuanEntity> ew = new EntityWrapper< PeizhenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peizhenyuan, "peizhenyuan")); 
		PeizhenyuanView peizhenyuanView =  peizhenyuanService.selectView(ew);
		return R.ok("查询陪诊员成功").put("data", peizhenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeizhenyuanEntity peizhenyuan = peizhenyuanService.selectById(id);
		peizhenyuan = peizhenyuanService.selectView(new EntityWrapper<PeizhenyuanEntity>().eq("id", id));
        return R.ok().put("data", peizhenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeizhenyuanEntity peizhenyuan = peizhenyuanService.selectById(id);
		peizhenyuan = peizhenyuanService.selectView(new EntityWrapper<PeizhenyuanEntity>().eq("id", id));
        return R.ok().put("data", peizhenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeizhenyuanEntity peizhenyuan, HttpServletRequest request){
        if(peizhenyuanService.selectCount(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", peizhenyuan.getPeizhenyuanzhanghao()))>0) {
            return R.error("陪诊员账号已存在");
        }
    	peizhenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peizhenyuan);
    	PeizhenyuanEntity u = peizhenyuanService.selectOne(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", peizhenyuan.getPeizhenyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		peizhenyuan.setId(new Date().getTime());
        peizhenyuanService.insert(peizhenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody PeizhenyuanEntity peizhenyuan, HttpServletRequest request){
        if(peizhenyuanService.selectCount(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", peizhenyuan.getPeizhenyuanzhanghao()))>0) {
            return R.error("陪诊员账号已存在");
        }
    	peizhenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peizhenyuan);
    	PeizhenyuanEntity u = peizhenyuanService.selectOne(new EntityWrapper<PeizhenyuanEntity>().eq("peizhenyuanzhanghao", peizhenyuan.getPeizhenyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		peizhenyuan.setId(new Date().getTime());
        peizhenyuanService.insert(peizhenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeizhenyuanEntity peizhenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peizhenyuan);
        peizhenyuanService.updateById(peizhenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peizhenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
