package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstoupiaohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstoupiaohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstoupiaohuodongView;


/**
 * 投票活动评论表
 *
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
public interface DiscusstoupiaohuodongService extends IService<DiscusstoupiaohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstoupiaohuodongVO> selectListVO(Wrapper<DiscusstoupiaohuodongEntity> wrapper);
   	
   	DiscusstoupiaohuodongVO selectVO(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);
   	
   	List<DiscusstoupiaohuodongView> selectListView(Wrapper<DiscusstoupiaohuodongEntity> wrapper);
   	
   	DiscusstoupiaohuodongView selectView(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstoupiaohuodongEntity> wrapper);

   	

}

