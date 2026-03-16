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

import com.entity.XianluleixingEntity;
import com.entity.view.XianluleixingView;

import com.service.XianluleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 线路类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@RestController
@RequestMapping("/xianluleixing")
public class XianluleixingController {
    @Autowired
    private XianluleixingService xianluleixingService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianluleixingEntity xianluleixing,
		HttpServletRequest request){
        EntityWrapper<XianluleixingEntity> ew = new EntityWrapper<XianluleixingEntity>();

		PageUtils page = xianluleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianluleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianluleixingEntity xianluleixing, 
		HttpServletRequest request){
        EntityWrapper<XianluleixingEntity> ew = new EntityWrapper<XianluleixingEntity>();

		PageUtils page = xianluleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianluleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianluleixingEntity xianluleixing){
       	EntityWrapper<XianluleixingEntity> ew = new EntityWrapper<XianluleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianluleixing, "xianluleixing")); 
        return R.ok().put("data", xianluleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianluleixingEntity xianluleixing){
        EntityWrapper< XianluleixingEntity> ew = new EntityWrapper< XianluleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianluleixing, "xianluleixing")); 
		XianluleixingView xianluleixingView =  xianluleixingService.selectView(ew);
		return R.ok("查询线路类型成功").put("data", xianluleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianluleixingEntity xianluleixing = xianluleixingService.selectById(id);
        return R.ok().put("data", xianluleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianluleixingEntity xianluleixing = xianluleixingService.selectById(id);
        return R.ok().put("data", xianluleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianluleixingEntity xianluleixing, HttpServletRequest request){
        if(xianluleixingService.selectCount(new EntityWrapper<XianluleixingEntity>().eq("xianluleixing", xianluleixing.getXianluleixing()))>0) {
            return R.error("线路类型已存在");
        }
    	//ValidatorUtils.validateEntity(xianluleixing);
        xianluleixingService.insert(xianluleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianluleixingEntity xianluleixing, HttpServletRequest request){
        if(xianluleixingService.selectCount(new EntityWrapper<XianluleixingEntity>().eq("xianluleixing", xianluleixing.getXianluleixing()))>0) {
            return R.error("线路类型已存在");
        }
    	//ValidatorUtils.validateEntity(xianluleixing);
        xianluleixingService.insert(xianluleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianluleixingEntity xianluleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianluleixing);
        if(xianluleixingService.selectCount(new EntityWrapper<XianluleixingEntity>().ne("id", xianluleixing.getId()).eq("xianluleixing", xianluleixing.getXianluleixing()))>0) {
            return R.error("线路类型已存在");
        }
        xianluleixingService.updateById(xianluleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianluleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
