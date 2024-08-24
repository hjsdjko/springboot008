package com.dao;

import com.entity.ToupiaohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ToupiaohuodongVO;
import com.entity.view.ToupiaohuodongView;


/**
 * 投票活动
 * 
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
public interface ToupiaohuodongDao extends BaseMapper<ToupiaohuodongEntity> {
	
	List<ToupiaohuodongVO> selectListVO(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);
	
	ToupiaohuodongVO selectVO(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);
	
	List<ToupiaohuodongView> selectListView(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);

	List<ToupiaohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);

	
	ToupiaohuodongView selectView(@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ToupiaohuodongEntity> wrapper);



}
