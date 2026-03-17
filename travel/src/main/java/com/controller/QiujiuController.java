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

import com.entity.QiujiuEntity;
import com.entity.view.QiujiuView;

import com.service.QiujiuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 求救信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 14:46:56
 */
@RestController
@RequestMapping("/qiujiu")
public class QiujiuController {
    @Autowired
    private QiujiuService qiujiuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiujiuEntity qiujiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			qiujiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daoyou")) {
			qiujiu.setDaoyougonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QiujiuEntity> ew = new EntityWrapper<QiujiuEntity>();

		PageUtils page = qiujiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiujiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiujiuEntity qiujiu, 
		HttpServletRequest request){
        EntityWrapper<QiujiuEntity> ew = new EntityWrapper<QiujiuEntity>();

		PageUtils page = qiujiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiujiu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiujiuEntity qiujiu){
       	EntityWrapper<QiujiuEntity> ew = new EntityWrapper<QiujiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiujiu, "qiujiu")); 
        return R.ok().put("data", qiujiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiujiuEntity qiujiu){
        EntityWrapper< QiujiuEntity> ew = new EntityWrapper< QiujiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiujiu, "qiujiu")); 
		QiujiuView qiujiuView =  qiujiuService.selectView(ew);
		return R.ok("查询求救信息成功").put("data", qiujiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiujiuEntity qiujiu = qiujiuService.selectById(id);
        return R.ok().put("data", qiujiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiujiuEntity qiujiu = qiujiuService.selectById(id);
        return R.ok().put("data", qiujiu);
    }
    


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiujiuEntity qiujiu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiujiu);
        qiujiuService.insert(qiujiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiujiuEntity qiujiu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiujiu);
        qiujiuService.insert(qiujiu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QiujiuEntity qiujiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiujiu);
        qiujiuService.updateById(qiujiu);//全部更新
        return R.ok();
    }

    /**
     * 响应（处理求救）
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R shBatch(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String huifuneirong){
        List<QiujiuEntity> list = new ArrayList<QiujiuEntity>();
        for(Long id : ids) {
            QiujiuEntity qiujiu = qiujiuService.selectById(id);
            qiujiu.setSfsh(sfsh);
            qiujiu.setHuifuneirong(huifuneirong);
            list.add(qiujiu);
        }
        qiujiuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiujiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,QiujiuEntity qiujiu, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            qiujiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("daoyou")) {
            qiujiu.setDaoyougonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<QiujiuEntity> ew = new EntityWrapper<QiujiuEntity>();
        int count = qiujiuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiujiu), params), params));
        return R.ok().put("data", count);
    }



}
