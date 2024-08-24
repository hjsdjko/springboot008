package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 投票记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
@TableName("toupiaojilu")
public class ToupiaojiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ToupiaojiluEntity() {
		
	}
	
	public ToupiaojiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 投票名称
	 */
					
	private String toupiaomingcheng;
	
	/**
	 * 投票图片
	 */
					
	private String toupiaotupian;
	
	/**
	 * 投票票数
	 */
					
	private Integer toupiaopiaoshu;
	
	/**
	 * 投票时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date toupiaoshijian;
	
	/**
	 * 信息备注
	 */
					
	private String xinxibeizhu;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：投票名称
	 */
	public void setToupiaomingcheng(String toupiaomingcheng) {
		this.toupiaomingcheng = toupiaomingcheng;
	}
	/**
	 * 获取：投票名称
	 */
	public String getToupiaomingcheng() {
		return toupiaomingcheng;
	}
	/**
	 * 设置：投票图片
	 */
	public void setToupiaotupian(String toupiaotupian) {
		this.toupiaotupian = toupiaotupian;
	}
	/**
	 * 获取：投票图片
	 */
	public String getToupiaotupian() {
		return toupiaotupian;
	}
	/**
	 * 设置：投票票数
	 */
	public void setToupiaopiaoshu(Integer toupiaopiaoshu) {
		this.toupiaopiaoshu = toupiaopiaoshu;
	}
	/**
	 * 获取：投票票数
	 */
	public Integer getToupiaopiaoshu() {
		return toupiaopiaoshu;
	}
	/**
	 * 设置：投票时间
	 */
	public void setToupiaoshijian(Date toupiaoshijian) {
		this.toupiaoshijian = toupiaoshijian;
	}
	/**
	 * 获取：投票时间
	 */
	public Date getToupiaoshijian() {
		return toupiaoshijian;
	}
	/**
	 * 设置：信息备注
	 */
	public void setXinxibeizhu(String xinxibeizhu) {
		this.xinxibeizhu = xinxibeizhu;
	}
	/**
	 * 获取：信息备注
	 */
	public String getXinxibeizhu() {
		return xinxibeizhu;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
