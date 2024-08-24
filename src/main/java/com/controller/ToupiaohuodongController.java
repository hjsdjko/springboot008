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

import com.entity.ToupiaohuodongEntity;
import com.entity.view.ToupiaohuodongView;

import com.service.ToupiaohuodongService;
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
 * 投票活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@RestController
@RequestMapping("/toupiaohuodong")
public class ToupiaohuodongController {
    @Autowired
    private ToupiaohuodongService toupiaohuodongService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ToupiaohuodongEntity toupiaohuodong,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = toupiaohuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toupiaohuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ToupiaohuodongEntity toupiaohuodong, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = toupiaohuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toupiaohuodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ToupiaohuodongEntity toupiaohuodong){
       	EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( toupiaohuodong, "toupiaohuodong")); 
        return R.ok().put("data", toupiaohuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToupiaohuodongEntity toupiaohuodong){
        EntityWrapper< ToupiaohuodongEntity> ew = new EntityWrapper< ToupiaohuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( toupiaohuodong, "toupiaohuodong")); 
		ToupiaohuodongView toupiaohuodongView =  toupiaohuodongService.selectView(ew);
		return R.ok("查询投票活动成功").put("data", toupiaohuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ToupiaohuodongEntity toupiaohuodong = toupiaohuodongService.selectById(id);
		toupiaohuodong.setClicknum(toupiaohuodong.getClicknum()+1);
		toupiaohuodongService.updateById(toupiaohuodong);
        toupiaohuodong = toupiaohuodongService.selectView(new EntityWrapper<ToupiaohuodongEntity>().eq("id", id));
        return R.ok().put("data", toupiaohuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ToupiaohuodongEntity toupiaohuodong = toupiaohuodongService.selectById(id);
		toupiaohuodong.setClicknum(toupiaohuodong.getClicknum()+1);
		toupiaohuodongService.updateById(toupiaohuodong);
        toupiaohuodong = toupiaohuodongService.selectView(new EntityWrapper<ToupiaohuodongEntity>().eq("id", id));
        return R.ok().put("data", toupiaohuodong);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ToupiaohuodongEntity toupiaohuodong = toupiaohuodongService.selectById(id);
        if(type.equals("1")) {
        	toupiaohuodong.setThumbsupnum(toupiaohuodong.getThumbsupnum()+1);
        } else {
        	toupiaohuodong.setCrazilynum(toupiaohuodong.getCrazilynum()+1);
        }
        toupiaohuodongService.updateById(toupiaohuodong);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToupiaohuodongEntity toupiaohuodong, HttpServletRequest request){
        if(toupiaohuodongService.selectCount(new EntityWrapper<ToupiaohuodongEntity>().eq("toupiaomingcheng", toupiaohuodong.getToupiaomingcheng()))>0) {
            return R.error("投票名称已存在");
        }
    	//ValidatorUtils.validateEntity(toupiaohuodong);
        toupiaohuodongService.insert(toupiaohuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToupiaohuodongEntity toupiaohuodong, HttpServletRequest request){
        if(toupiaohuodongService.selectCount(new EntityWrapper<ToupiaohuodongEntity>().eq("toupiaomingcheng", toupiaohuodong.getToupiaomingcheng()))>0) {
            return R.error("投票名称已存在");
        }
    	//ValidatorUtils.validateEntity(toupiaohuodong);
        toupiaohuodongService.insert(toupiaohuodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToupiaohuodongEntity toupiaohuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(toupiaohuodong);
        if(toupiaohuodongService.selectCount(new EntityWrapper<ToupiaohuodongEntity>().ne("id", toupiaohuodong.getId()).eq("toupiaomingcheng", toupiaohuodong.getToupiaomingcheng()))>0) {
            return R.error("投票名称已存在");
        }
        toupiaohuodongService.updateById(toupiaohuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        toupiaohuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        List<Map<String, Object>> result = toupiaohuodongService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = toupiaohuodongService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        List<Map<String, Object>> result = toupiaohuodongService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = toupiaohuodongService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        List<Map<String, Object>> result = toupiaohuodongService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ToupiaohuodongEntity toupiaohuodong, HttpServletRequest request){
        EntityWrapper<ToupiaohuodongEntity> ew = new EntityWrapper<ToupiaohuodongEntity>();
        int count = toupiaohuodongService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toupiaohuodong), params), params));
        return R.ok().put("data", count);
    }



}
