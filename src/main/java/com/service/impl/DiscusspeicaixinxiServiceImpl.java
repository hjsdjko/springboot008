package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusspeicaixinxiDao;
import com.entity.DiscusspeicaixinxiEntity;
import com.service.DiscusspeicaixinxiService;
import com.entity.vo.DiscusspeicaixinxiVO;
import com.entity.view.DiscusspeicaixinxiView;

@Service("discusspeicaixinxiService")
public class DiscusspeicaixinxiServiceImpl extends ServiceImpl<DiscusspeicaixinxiDao, DiscusspeicaixinxiEntity> implements DiscusspeicaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspeicaixinxiEntity> page = this.selectPage(
                new Query<DiscusspeicaixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusspeicaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspeicaixinxiEntity> wrapper) {
		  Page<DiscusspeicaixinxiView> page =new Query<DiscusspeicaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusspeicaixinxiVO> selectListVO(Wrapper<DiscusspeicaixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusspeicaixinxiVO selectVO(Wrapper<DiscusspeicaixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusspeicaixinxiView> selectListView(Wrapper<DiscusspeicaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspeicaixinxiView selectView(Wrapper<DiscusspeicaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
