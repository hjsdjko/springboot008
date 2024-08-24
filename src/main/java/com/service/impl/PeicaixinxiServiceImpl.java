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


import com.dao.PeicaixinxiDao;
import com.entity.PeicaixinxiEntity;
import com.service.PeicaixinxiService;
import com.entity.vo.PeicaixinxiVO;
import com.entity.view.PeicaixinxiView;

@Service("peicaixinxiService")
public class PeicaixinxiServiceImpl extends ServiceImpl<PeicaixinxiDao, PeicaixinxiEntity> implements PeicaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeicaixinxiEntity> page = this.selectPage(
                new Query<PeicaixinxiEntity>(params).getPage(),
                new EntityWrapper<PeicaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeicaixinxiEntity> wrapper) {
		  Page<PeicaixinxiView> page =new Query<PeicaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PeicaixinxiVO> selectListVO(Wrapper<PeicaixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeicaixinxiVO selectVO(Wrapper<PeicaixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeicaixinxiView> selectListView(Wrapper<PeicaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeicaixinxiView selectView(Wrapper<PeicaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<PeicaixinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<PeicaixinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<PeicaixinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
