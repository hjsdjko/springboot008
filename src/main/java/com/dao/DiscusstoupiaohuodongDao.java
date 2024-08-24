package com.dao;

import com.entity.DiscusstoupiaohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstoupiaohuodongVO;
import com.entity.view.DiscusstoupiaohuodongView;


/**
 * 投票活动评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
public interface DiscusstoupiaohuodongDao extends BaseMapper<DiscusstoupiaohuodongEntity> {
	
	List<DiscusstoupiaohuodongVO> selectListVO(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);
	
	DiscusstoupiaohuodongVO selectVO(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);
	
	List<DiscusstoupiaohuodongView> selectListView(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);

	List<DiscusstoupiaohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);

	
	DiscusstoupiaohuodongView selectView(@Param("ew") Wrapper<DiscusstoupiaohuodongEntity> wrapper);
	

}
