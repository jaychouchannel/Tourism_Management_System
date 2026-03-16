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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.MeishicantingEntity;
import com.entity.view.MeishicantingView;

import com.service.MeishicantingService;
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
 * 美食餐厅
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@RestController
@RequestMapping("/meishicanting")
public class MeishicantingController {
    @Autowired
    private MeishicantingService meishicantingService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishicantingEntity meishicanting,
		HttpServletRequest request){
        EntityWrapper<MeishicantingEntity> ew = new EntityWrapper<MeishicantingEntity>();

		PageUtils page = meishicantingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicanting), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishicantingEntity meishicanting, 
		HttpServletRequest request){
        EntityWrapper<MeishicantingEntity> ew = new EntityWrapper<MeishicantingEntity>();

		PageUtils page = meishicantingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicanting), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishicantingEntity meishicanting){
       	EntityWrapper<MeishicantingEntity> ew = new EntityWrapper<MeishicantingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishicanting, "meishicanting")); 
        return R.ok().put("data", meishicantingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishicantingEntity meishicanting){
        EntityWrapper< MeishicantingEntity> ew = new EntityWrapper< MeishicantingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishicanting, "meishicanting")); 
		MeishicantingView meishicantingView =  meishicantingService.selectView(ew);
		return R.ok("查询美食餐厅成功").put("data", meishicantingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishicantingEntity meishicanting = meishicantingService.selectById(id);
		meishicanting.setClicknum(meishicanting.getClicknum()+1);
		meishicantingService.updateById(meishicanting);
        meishicanting = meishicantingService.selectView(new EntityWrapper<MeishicantingEntity>().eq("id", id));
        return R.ok().put("data", meishicanting);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishicantingEntity meishicanting = meishicantingService.selectById(id);
		meishicanting.setClicknum(meishicanting.getClicknum()+1);
		meishicantingService.updateById(meishicanting);
        meishicanting = meishicantingService.selectView(new EntityWrapper<MeishicantingEntity>().eq("id", id));
        return R.ok().put("data", meishicanting);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        MeishicantingEntity meishicanting = meishicantingService.selectById(id);
        if(type.equals("1")) {
        	meishicanting.setThumbsupnum(meishicanting.getThumbsupnum()+1);
        } else {
        	meishicanting.setCrazilynum(meishicanting.getCrazilynum()+1);
        }
        meishicantingService.updateById(meishicanting);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishicantingEntity meishicanting, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(meishicanting);
        meishicantingService.insert(meishicanting);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishicantingEntity meishicanting, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(meishicanting);
        meishicantingService.insert(meishicanting);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MeishicantingEntity meishicanting, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishicanting);
        meishicantingService.updateById(meishicanting);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishicantingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MeishicantingEntity meishicanting, HttpServletRequest request,String pre){
        EntityWrapper<MeishicantingEntity> ew = new EntityWrapper<MeishicantingEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = meishicantingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicanting), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MeishicantingEntity meishicanting, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "meishicanting"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<MeishicantingEntity> ew = new EntityWrapper<MeishicantingEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = meishicantingService.queryPage(params, ew);
        List<MeishicantingEntity> pageList = (List<MeishicantingEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<MeishicantingEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(meishicantingService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}
