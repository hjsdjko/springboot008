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

import com.entity.ToupiaojiluEntity;
import com.entity.view.ToupiaojiluView;

import com.service.ToupiaojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投票记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@RestController
@RequestMapping("/toupiaojilu")
public class ToupiaojiluController {
    @Autowired
    private ToupiaojiluService toupiaojiluService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ToupiaojiluEntity toupiaojilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toupiaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toupiaoshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			toupiaojilu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ToupiaojiluEntity> ew = new EntityWrapper<ToupiaojiluEntity>();
                if(toupiaoshijianstart!=null) ew.ge("toupiaoshijian", toupiaoshijianstart);
                if(toupiaoshijianend!=null) ew.le("toupiaoshijian", toupiaoshijianend);

		PageUtils page = toupiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toupiaojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ToupiaojiluEntity toupiaojilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toupiaoshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toupiaoshijianend,
		HttpServletRequest request){
        EntityWrapper<ToupiaojiluEntity> ew = new EntityWrapper<ToupiaojiluEntity>();
                if(toupiaoshijianstart!=null) ew.ge("toupiaoshijian", toupiaoshijianstart);
                if(toupiaoshijianend!=null) ew.le("toupiaoshijian", toupiaoshijianend);

		PageUtils page = toupiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toupiaojilu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ToupiaojiluEntity toupiaojilu){
       	EntityWrapper<ToupiaojiluEntity> ew = new EntityWrapper<ToupiaojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( toupiaojilu, "toupiaojilu")); 
        return R.ok().put("data", toupiaojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToupiaojiluEntity toupiaojilu){
        EntityWrapper< ToupiaojiluEntity> ew = new EntityWrapper< ToupiaojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( toupiaojilu, "toupiaojilu")); 
		ToupiaojiluView toupiaojiluView =  toupiaojiluService.selectView(ew);
		return R.ok("查询投票记录成功").put("data", toupiaojiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ToupiaojiluEntity toupiaojilu = toupiaojiluService.selectById(id);
        return R.ok().put("data", toupiaojilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ToupiaojiluEntity toupiaojilu = toupiaojiluService.selectById(id);
        return R.ok().put("data", toupiaojilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToupiaojiluEntity toupiaojilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(toupiaojilu);
        toupiaojiluService.insert(toupiaojilu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToupiaojiluEntity toupiaojilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(toupiaojilu);
        toupiaojiluService.insert(toupiaojilu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToupiaojiluEntity toupiaojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(toupiaojilu);
        toupiaojiluService.updateById(toupiaojilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        toupiaojiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
