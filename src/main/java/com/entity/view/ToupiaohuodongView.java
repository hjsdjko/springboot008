package com.entity.view;

import com.entity.ToupiaohuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 投票活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@TableName("toupiaohuodong")
public class ToupiaohuodongView  extends ToupiaohuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ToupiaohuodongView(){
	}
 
 	public ToupiaohuodongView(ToupiaohuodongEntity toupiaohuodongEntity){
 	try {
			BeanUtils.copyProperties(this, toupiaohuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
