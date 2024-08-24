package com.entity.view;

import com.entity.DiscusstoupiaohuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 投票活动评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
@TableName("discusstoupiaohuodong")
public class DiscusstoupiaohuodongView  extends DiscusstoupiaohuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstoupiaohuodongView(){
	}
 
 	public DiscusstoupiaohuodongView(DiscusstoupiaohuodongEntity discusstoupiaohuodongEntity){
 	try {
			BeanUtils.copyProperties(this, discusstoupiaohuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}