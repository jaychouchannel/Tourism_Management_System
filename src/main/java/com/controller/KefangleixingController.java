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

import com.entity.KefangleixingEntity;
import com.entity.view.KefangleixingView;

import com.service.KefangleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 客房类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:55
 */
@RestController
@RequestMapping("/kefangleixing")
public class KefangleixingController {
    @Autowired
    private KefangleixingService kefangleixingService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KefangleixingEntity kefangleixing,
		HttpServletRequest request){
        EntityWrapper<KefangleixingEntity> ew = new EntityWrapper<KefangleixingEntity>();

		PageUtils page = kefangleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KefangleixingEntity kefangleixing, 
		HttpServletRequest request){
        EntityWrapper<KefangleixingEntity> ew = new EntityWrapper<KefangleixingEntity>();

		PageUtils page = kefangleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KefangleixingEntity kefangleixing){
       	EntityWrapper<KefangleixingEntity> ew = new EntityWrapper<KefangleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kefangleixing, "kefangleixing")); 
        return R.ok().put("data", kefangleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KefangleixingEntity kefangleixing){
        EntityWrapper< KefangleixingEntity> ew = new EntityWrapper< KefangleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kefangleixing, "kefangleixing")); 
		KefangleixingView kefangleixingView =  kefangleixingService.selectView(ew);
		return R.ok("查询客房类型成功").put("data", kefangleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KefangleixingEntity kefangleixing = kefangleixingService.selectById(id);
        return R.ok().put("data", kefangleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KefangleixingEntity kefangleixing = kefangleixingService.selectById(id);
        return R.ok().put("data", kefangleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KefangleixingEntity kefangleixing, HttpServletRequest request){
        if(kefangleixingService.selectCount(new EntityWrapper<KefangleixingEntity>().eq("kefangleixing", kefangleixing.getKefangleixing()))>0) {
            return R.error("客房类型已存在");
        }
    	//ValidatorUtils.validateEntity(kefangleixing);
        kefangleixingService.insert(kefangleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KefangleixingEntity kefangleixing, HttpServletRequest request){
        if(kefangleixingService.selectCount(new EntityWrapper<KefangleixingEntity>().eq("kefangleixing", kefangleixing.getKefangleixing()))>0) {
            return R.error("客房类型已存在");
        }
    	//ValidatorUtils.validateEntity(kefangleixing);
        kefangleixingService.insert(kefangleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KefangleixingEntity kefangleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kefangleixing);
        if(kefangleixingService.selectCount(new EntityWrapper<KefangleixingEntity>().ne("id", kefangleixing.getId()).eq("kefangleixing", kefangleixing.getKefangleixing()))>0) {
            return R.error("客房类型已存在");
        }
        kefangleixingService.updateById(kefangleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kefangleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
