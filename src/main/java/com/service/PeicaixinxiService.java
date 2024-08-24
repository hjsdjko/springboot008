package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeicaixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeicaixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeicaixinxiView;


/**
 * 配菜信息
 *
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
public interface PeicaixinxiService extends IService<PeicaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeicaixinxiVO> selectListVO(Wrapper<PeicaixinxiEntity> wrapper);
   	
   	PeicaixinxiVO selectVO(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);
   	
   	List<PeicaixinxiView> selectListView(Wrapper<PeicaixinxiEntity> wrapper);
   	
   	PeicaixinxiView selectView(@Param("ew") Wrapper<PeicaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeicaixinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PeicaixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PeicaixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PeicaixinxiEntity> wrapper);



}

