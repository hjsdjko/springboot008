package com.entity.view;

import com.entity.DiscusspeicaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 配菜信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:17
 */
@TableName("discusspeicaixinxi")
public class DiscusspeicaixinxiView  extends DiscusspeicaixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusspeicaixinxiView(){
	}
 
 	public DiscusspeicaixinxiView(DiscusspeicaixinxiEntity discusspeicaixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusspeicaixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
