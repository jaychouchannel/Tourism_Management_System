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

import com.entity.LvyouxianluEntity;
import com.entity.view.LvyouxianluView;

import com.service.LvyouxianluService;
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
 * 旅游线路
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@RestController
@RequestMapping("/lvyouxianlu")
public class LvyouxianluController {
    @Autowired
    private LvyouxianluService lvyouxianluService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LvyouxianluEntity lvyouxianlu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoyou")) {
			lvyouxianlu.setDaoyougonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LvyouxianluEntity> ew = new EntityWrapper<LvyouxianluEntity>();

		PageUtils page = lvyouxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyouxianlu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LvyouxianluEntity lvyouxianlu, 
		HttpServletRequest request){
        EntityWrapper<LvyouxianluEntity> ew = new EntityWrapper<LvyouxianluEntity>();

		PageUtils page = lvyouxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyouxianlu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LvyouxianluEntity lvyouxianlu){
       	EntityWrapper<LvyouxianluEntity> ew = new EntityWrapper<LvyouxianluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lvyouxianlu, "lvyouxianlu")); 
        return R.ok().put("data", lvyouxianluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LvyouxianluEntity lvyouxianlu){
        EntityWrapper< LvyouxianluEntity> ew = new EntityWrapper< LvyouxianluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lvyouxianlu, "lvyouxianlu")); 
		LvyouxianluView lvyouxianluView =  lvyouxianluService.selectView(ew);
		return R.ok("查询旅游线路成功").put("data", lvyouxianluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LvyouxianluEntity lvyouxianlu = lvyouxianluService.selectById(id);
        return R.ok().put("data", lvyouxianlu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LvyouxianluEntity lvyouxianlu = lvyouxianluService.selectById(id);
        return R.ok().put("data", lvyouxianlu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        LvyouxianluEntity lvyouxianlu = lvyouxianluService.selectById(id);
        if(type.equals("1")) {
        	lvyouxianlu.setThumbsupnum(lvyouxianlu.getThumbsupnum()+1);
        } else {
        	lvyouxianlu.setCrazilynum(lvyouxianlu.getCrazilynum()+1);
        }
        lvyouxianluService.updateById(lvyouxianlu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LvyouxianluEntity lvyouxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lvyouxianlu);
        lvyouxianluService.insert(lvyouxianlu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LvyouxianluEntity lvyouxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lvyouxianlu);
        lvyouxianluService.insert(lvyouxianlu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LvyouxianluEntity lvyouxianlu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lvyouxianlu);
        lvyouxianluService.updateById(lvyouxianlu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lvyouxianluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
