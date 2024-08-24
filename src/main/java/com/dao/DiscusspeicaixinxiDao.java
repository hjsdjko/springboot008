package com.dao;

import com.entity.DiscusspeicaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusspeicaixinxiVO;
import com.entity.view.DiscusspeicaixinxiView;


/**
 * 配菜信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
public interface DiscusspeicaixinxiDao extends BaseMapper<DiscusspeicaixinxiEntity> {
	
	List<DiscusspeicaixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);
	
	DiscusspeicaixinxiVO selectVO(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);
	
	List<DiscusspeicaixinxiView> selectListView(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);

	List<DiscusspeicaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);

	
	DiscusspeicaixinxiView selectView(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);
	

}
