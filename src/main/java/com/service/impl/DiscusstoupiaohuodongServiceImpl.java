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


import com.dao.DiscusstoupiaohuodongDao;
import com.entity.DiscusstoupiaohuodongEntity;
import com.service.DiscusstoupiaohuodongService;
import com.entity.vo.DiscusstoupiaohuodongVO;
import com.entity.view.DiscusstoupiaohuodongView;

@Service("discusstoupiaohuodongService")
public class DiscusstoupiaohuodongServiceImpl extends ServiceImpl<DiscusstoupiaohuodongDao, DiscusstoupiaohuodongEntity> implements DiscusstoupiaohuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstoupiaohuodongEntity> page = this.selectPage(
                new Query<DiscusstoupiaohuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusstoupiaohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstoupiaohuodongEntity> wrapper) {
		  Page<DiscusstoupiaohuodongView> page =new Query<DiscusstoupiaohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusstoupiaohuodongVO> selectListVO(Wrapper<DiscusstoupiaohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstoupiaohuodongVO selectVO(Wrapper<DiscusstoupiaohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstoupiaohuodongView> selectListView(Wrapper<DiscusstoupiaohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstoupiaohuodongView selectView(Wrapper<DiscusstoupiaohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
