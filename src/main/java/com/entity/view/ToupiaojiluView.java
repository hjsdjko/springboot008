package com.entity.view;

import com.entity.ToupiaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 投票记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@TableName("toupiaojilu")
public class ToupiaojiluView  extends ToupiaojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ToupiaojiluView(){
	}
 
 	public ToupiaojiluView(ToupiaojiluEntity toupiaojiluEntity){
 	try {
			BeanUtils.copyProperties(this, toupiaojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
