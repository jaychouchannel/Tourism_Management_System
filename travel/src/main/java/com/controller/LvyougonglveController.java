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

import com.entity.LvyougonglveEntity;
import com.entity.view.LvyougonglveView;

import com.service.LvyougonglveService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 旅游攻略
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@RestController
@RequestMapping("/lvyougonglve")
public class LvyougonglveController {
    @Autowired
    private LvyougonglveService lvyougonglveService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LvyougonglveEntity lvyougonglve,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lvyougonglve.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();

		PageUtils page = lvyougonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyougonglve), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LvyougonglveEntity lvyougonglve, 
		HttpServletRequest request){
        EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();

		PageUtils page = lvyougonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyougonglve), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LvyougonglveEntity lvyougonglve){
       	EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lvyougonglve, "lvyougonglve")); 
        return R.ok().put("data", lvyougonglveService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LvyougonglveEntity lvyougonglve){
        EntityWrapper< LvyougonglveEntity> ew = new EntityWrapper< LvyougonglveEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lvyougonglve, "lvyougonglve")); 
		LvyougonglveView lvyougonglveView =  lvyougonglveService.selectView(ew);
		return R.ok("查询旅游攻略成功").put("data", lvyougonglveView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LvyougonglveEntity lvyougonglve = lvyougonglveService.selectById(id);
        return R.ok().put("data", lvyougonglve);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LvyougonglveEntity lvyougonglve = lvyougonglveService.selectById(id);
        return R.ok().put("data", lvyougonglve);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        LvyougonglveEntity lvyougonglve = lvyougonglveService.selectById(id);
        if(type.equals("1")) {
        	lvyougonglve.setThumbsupnum(lvyougonglve.getThumbsupnum()+1);
        } else {
        	lvyougonglve.setCrazilynum(lvyougonglve.getCrazilynum()+1);
        }
        lvyougonglveService.updateById(lvyougonglve);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.insert(lvyougonglve);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.insert(lvyougonglve);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.updateById(lvyougonglve);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lvyougonglveService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
