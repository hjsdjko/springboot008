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


import com.dao.ToupiaohuodongDao;
import com.entity.ToupiaohuodongEntity;
import com.service.ToupiaohuodongService;
import com.entity.vo.ToupiaohuodongVO;
import com.entity.view.ToupiaohuodongView;

@Service("toupiaohuodongService")
public class ToupiaohuodongServiceImpl extends ServiceImpl<ToupiaohuodongDao, ToupiaohuodongEntity> implements ToupiaohuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToupiaohuodongEntity> page = this.selectPage(
                new Query<ToupiaohuodongEntity>(params).getPage(),
                new EntityWrapper<ToupiaohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToupiaohuodongEntity> wrapper) {
		  Page<ToupiaohuodongView> page =new Query<ToupiaohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ToupiaohuodongVO> selectListVO(Wrapper<ToupiaohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ToupiaohuodongVO selectVO(Wrapper<ToupiaohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ToupiaohuodongView> selectListView(Wrapper<ToupiaohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToupiaohuodongView selectView(Wrapper<ToupiaohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ToupiaohuodongEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ToupiaohuodongEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ToupiaohuodongEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
