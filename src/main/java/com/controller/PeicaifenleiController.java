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

import com.entity.PeicaifenleiEntity;
import com.entity.view.PeicaifenleiView;

import com.service.PeicaifenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配菜分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 06:47:15
 */
@RestController
@RequestMapping("/peicaifenlei")
public class PeicaifenleiController {
    @Autowired
    private PeicaifenleiService peicaifenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeicaifenleiEntity peicaifenlei,
		HttpServletRequest request){
        EntityWrapper<PeicaifenleiEntity> ew = new EntityWrapper<PeicaifenleiEntity>();

		PageUtils page = peicaifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peicaifenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeicaifenleiEntity peicaifenlei, 
		HttpServletRequest request){
        EntityWrapper<PeicaifenleiEntity> ew = new EntityWrapper<PeicaifenleiEntity>();

		PageUtils page = peicaifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peicaifenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeicaifenleiEntity peicaifenlei){
       	EntityWrapper<PeicaifenleiEntity> ew = new EntityWrapper<PeicaifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peicaifenlei, "peicaifenlei")); 
        return R.ok().put("data", peicaifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeicaifenleiEntity peicaifenlei){
        EntityWrapper< PeicaifenleiEntity> ew = new EntityWrapper< PeicaifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peicaifenlei, "peicaifenlei")); 
		PeicaifenleiView peicaifenleiView =  peicaifenleiService.selectView(ew);
		return R.ok("查询配菜分类成功").put("data", peicaifenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeicaifenleiEntity peicaifenlei = peicaifenleiService.selectById(id);
        return R.ok().put("data", peicaifenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeicaifenleiEntity peicaifenlei = peicaifenleiService.selectById(id);
        return R.ok().put("data", peicaifenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeicaifenleiEntity peicaifenlei, HttpServletRequest request){
        if(peicaifenleiService.selectCount(new EntityWrapper<PeicaifenleiEntity>().eq("peicaifenlei", peicaifenlei.getPeicaifenlei()))>0) {
            return R.error("配菜分类已存在");
        }
    	//ValidatorUtils.validateEntity(peicaifenlei);
        peicaifenleiService.insert(peicaifenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeicaifenleiEntity peicaifenlei, HttpServletRequest request){
        if(peicaifenleiService.selectCount(new EntityWrapper<PeicaifenleiEntity>().eq("peicaifenlei", peicaifenlei.getPeicaifenlei()))>0) {
            return R.error("配菜分类已存在");
        }
    	//ValidatorUtils.validateEntity(peicaifenlei);
        peicaifenleiService.insert(peicaifenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeicaifenleiEntity peicaifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peicaifenlei);
        if(peicaifenleiService.selectCount(new EntityWrapper<PeicaifenleiEntity>().ne("id", peicaifenlei.getId()).eq("peicaifenlei", peicaifenlei.getPeicaifenlei()))>0) {
            return R.error("配菜分类已存在");
        }
        peicaifenleiService.updateById(peicaifenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peicaifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
