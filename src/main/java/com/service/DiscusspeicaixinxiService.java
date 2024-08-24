package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusspeicaixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusspeicaixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusspeicaixinxiView;


/**
 * 配菜信息评论表
 *
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
public interface DiscusspeicaixinxiService extends IService<DiscusspeicaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspeicaixinxiVO> selectListVO(Wrapper<DiscusspeicaixinxiEntity> wrapper);
   	
   	DiscusspeicaixinxiVO selectVO(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);
   	
   	List<DiscusspeicaixinxiView> selectListView(Wrapper<DiscusspeicaixinxiEntity> wrapper);
   	
   	DiscusspeicaixinxiView selectView(@Param("ew") Wrapper<DiscusspeicaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspeicaixinxiEntity> wrapper);

   	

}

