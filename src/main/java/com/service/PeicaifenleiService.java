package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeicaifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeicaifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeicaifenleiView;


/**
 * 配菜分类
 *
 * @author 
 * @email 
 * @date 2024-05-09 06:47:15
 */
public interface PeicaifenleiService extends IService<PeicaifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeicaifenleiVO> selectListVO(Wrapper<PeicaifenleiEntity> wrapper);
   	
   	PeicaifenleiVO selectVO(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);
   	
   	List<PeicaifenleiView> selectListView(Wrapper<PeicaifenleiEntity> wrapper);
   	
   	PeicaifenleiView selectView(@Param("ew") Wrapper<PeicaifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeicaifenleiEntity> wrapper);

   	

}

