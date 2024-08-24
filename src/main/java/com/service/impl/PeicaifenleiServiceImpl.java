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


import com.dao.PeicaifenleiDao;
import com.entity.PeicaifenleiEntity;
import com.service.PeicaifenleiService;
import com.entity.vo.PeicaifenleiVO;
import com.entity.view.PeicaifenleiView;

@Service("peicaifenleiService")
public class PeicaifenleiServiceImpl extends ServiceImpl<PeicaifenleiDao, PeicaifenleiEntity> implements PeicaifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeicaifenleiEntity> page = this.selectPage(
                new Query<PeicaifenleiEntity>(params).getPage(),
                new EntityWrapper<PeicaifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeicaifenleiEntity> wrapper) {
		  Page<PeicaifenleiView> page =new Query<PeicaifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PeicaifenleiVO> selectListVO(Wrapper<PeicaifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeicaifenleiVO selectVO(Wrapper<PeicaifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeicaifenleiView> selectListView(Wrapper<PeicaifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeicaifenleiView selectView(Wrapper<PeicaifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
