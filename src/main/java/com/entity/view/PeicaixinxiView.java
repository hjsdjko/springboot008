package com.entity.view;

import com.entity.PeicaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 配菜信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@TableName("peicaixinxi")
public class PeicaixinxiView  extends PeicaixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeicaixinxiView(){
	}
 
 	public PeicaixinxiView(PeicaixinxiEntity peicaixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, peicaixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}