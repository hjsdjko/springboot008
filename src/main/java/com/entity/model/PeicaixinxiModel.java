package com.entity.model;

import com.entity.PeicaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 配菜信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-09 06:47:16
 */
public class PeicaixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 配菜分类
	 */
	
	private String peicaifenlei;
		
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 商品规格
	 */
	
	private String shangpinguige;
		
	/**
	 * 商品品牌
	 */
	
	private String shangpinpinpai;
		
	/**
	 * 食材来源
	 */
	
	private String shicailaiyuan;
		
	/**
	 * 营养成分
	 */
	
	private String yingyangchengfen;
		
	/**
	 * 视频信息
	 */
	
	private String shipinxinxi;
		
	/**
	 * 单次限购
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 商品库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 食用说明
	 */
	
	private String shiyongshuoming;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：配菜分类
	 */
	 
	public void setPeicaifenlei(String peicaifenlei) {
		this.peicaifenlei = peicaifenlei;
	}
	
	/**
	 * 获取：配菜分类
	 */
	public String getPeicaifenlei() {
		return peicaifenlei;
	}
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：商品规格
	 */
	 
	public void setShangpinguige(String shangpinguige) {
		this.shangpinguige = shangpinguige;
	}
	
	/**
	 * 获取：商品规格
	 */
	public String getShangpinguige() {
		return shangpinguige;
	}
				
	
	/**
	 * 设置：商品品牌
	 */
	 
	public void setShangpinpinpai(String shangpinpinpai) {
		this.shangpinpinpai = shangpinpinpai;
	}
	
	/**
	 * 获取：商品品牌
	 */
	public String getShangpinpinpai() {
		return shangpinpinpai;
	}
				
	
	/**
	 * 设置：食材来源
	 */
	 
	public void setShicailaiyuan(String shicailaiyuan) {
		this.shicailaiyuan = shicailaiyuan;
	}
	
	/**
	 * 获取：食材来源
	 */
	public String getShicailaiyuan() {
		return shicailaiyuan;
	}
				
	
	/**
	 * 设置：营养成分
	 */
	 
	public void setYingyangchengfen(String yingyangchengfen) {
		this.yingyangchengfen = yingyangchengfen;
	}
	
	/**
	 * 获取：营养成分
	 */
	public String getYingyangchengfen() {
		return yingyangchengfen;
	}
				
	
	/**
	 * 设置：视频信息
	 */
	 
	public void setShipinxinxi(String shipinxinxi) {
		this.shipinxinxi = shipinxinxi;
	}
	
	/**
	 * 获取：视频信息
	 */
	public String getShipinxinxi() {
		return shipinxinxi;
	}
				
	
	/**
	 * 设置：单次限购
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单次限购
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：商品库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：商品库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：食用说明
	 */
	 
	public void setShiyongshuoming(String shiyongshuoming) {
		this.shiyongshuoming = shiyongshuoming;
	}
	
	/**
	 * 获取：食用说明
	 */
	public String getShiyongshuoming() {
		return shiyongshuoming;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
