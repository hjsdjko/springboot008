package com.dao;

import com.entity.PeicaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeicaixinxiVO;
import com.entity.view.PeicaixinxiView;


/**
 * 配菜信息
 * 
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
public interface PeicaixinxiDao extends BaseMapper<PeicaixinxiEntity> {
	
	List<PeicaixinxiVO> selectListVO(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);
	
	PeicaixinxiVO selectVO(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);
	
	List<PeicaixinxiView> selectListView(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);

	List<PeicaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);

	
	PeicaixinxiView selectView(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);



}
