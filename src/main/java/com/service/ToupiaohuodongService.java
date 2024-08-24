package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ToupiaohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ToupiaohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ToupiaohuodongView;


/**
 * 投票活动
 *
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
public interface ToupiaohuodongService extends IService<ToupiaohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToupiaohuodongVO> selectListVO(Wrapper<ToupiaohuodongEntity> wrapper);
   	
   	ToupiaohuodongVO selectVO(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);
   	
   	List<ToupiaohuodongView> selectListView(Wrapper<ToupiaohuodongEntity> wrapper);
   	
   	ToupiaohuodongView selectView(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToupiaohuodongEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ToupiaohuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ToupiaohuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ToupiaohuodongEntity> wrapper);



}

