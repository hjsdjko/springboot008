package com.dao;

import com.entity.PeicaifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeicaifenleiVO;
import com.entity.view.PeicaifenleiView;


/**
 * 配菜分类
 * 
 * @author 
 * @email 
 * @date 2024-05-09 06:47:15
 */
public interface PeicaifenleiDao extends BaseMapper<PeicaifenleiEntity> {
	
	List<PeicaifenleiVO> selectListVO(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);
	
	PeicaifenleiVO selectVO(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);
	
	List<PeicaifenleiView> selectListView(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);

	List<PeicaifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);

	
	PeicaifenleiView selectView(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);
	

}
