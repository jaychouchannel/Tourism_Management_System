package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.JingdianleixingEntity;
import com.entity.view.JingdianleixingView;

import com.service.JingdianleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 景点类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
@RestController
@RequestMapping("/jingdianleixing")
public class JingdianleixingController {
    @Autowired
    private JingdianleixingService jingdianleixingService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianleixingEntity jingdianleixing,
		HttpServletRequest request){
        EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();

		PageUtils page = jingdianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianleixingEntity jingdianleixing, 
		HttpServletRequest request){
        EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();

		PageUtils page = jingdianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianleixingEntity jingdianleixing){
       	EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianleixing, "jingdianleixing")); 
        return R.ok().put("data", jingdianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianleixingEntity jingdianleixing){
        EntityWrapper< JingdianleixingEntity> ew = new EntityWrapper< JingdianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianleixing, "jingdianleixing")); 
		JingdianleixingView jingdianleixingView =  jingdianleixingService.selectView(ew);
		return R.ok("查询景点类型成功").put("data", jingdianleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianleixingEntity jingdianleixing = jingdianleixingService.selectById(id);
        return R.ok().put("data", jingdianleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianleixingEntity jingdianleixing = jingdianleixingService.selectById(id);
        return R.ok().put("data", jingdianleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
        if(jingdianleixingService.selectCount(new EntityWrapper<JingdianleixingEntity>().eq("jingdianleixing", jingdianleixing.getJingdianleixing()))>0) {
            return R.error("景点类型已存在");
        }
    	//ValidatorUtils.validateEntity(jingdianleixing);
        jingdianleixingService.insert(jingdianleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
        if(jingdianleixingService.selectCount(new EntityWrapper<JingdianleixingEntity>().eq("jingdianleixing", jingdianleixing.getJingdianleixing()))>0) {
            return R.error("景点类型已存在");
        }
    	//ValidatorUtils.validateEntity(jingdianleixing);
        jingdianleixingService.insert(jingdianleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianleixing);
        if(jingdianleixingService.selectCount(new EntityWrapper<JingdianleixingEntity>().ne("id", jingdianleixing.getId()).eq("jingdianleixing", jingdianleixing.getJingdianleixing()))>0) {
            return R.error("景点类型已存在");
        }
        jingdianleixingService.updateById(jingdianleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
