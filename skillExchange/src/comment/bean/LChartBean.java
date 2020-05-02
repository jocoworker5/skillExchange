package comment.bean;

import java.math.BigDecimal;

public class LChartBean {
	private Integer mon;
	private Double webgrading;
	private Double webFluency;
	private Double webSatis;
	private Double webRecommend;
	public LChartBean(Integer mon, Double webgrading, Double webFluency, Double webSatis, Double webRecommend) {
		super();
		this.mon = mon;
		this.webgrading = webgrading;
		this.webFluency = webFluency;
		this.webSatis = webSatis;
		this.webRecommend = webRecommend;
	}
	public Integer getMon() {
		return mon;
	}
	public void setMon(Integer mon) {
		this.mon = mon;
	}
	public Double getWebgrading() {
		return webgrading;
	}
	public void setWebgrading(Double webgrading) {
		this.webgrading = webgrading;
	}
	public Double getWebFluency() {
		return webFluency;
	}
	public void setWebFluency(Double webFluency) {
		this.webFluency = webFluency;
	}
	public Double getWebSatis() {
		return webSatis;
	}
	public void setWebSatis(Double webSatis) {
		this.webSatis = webSatis;
	}
	public Double getWebRecommend() {
		return webRecommend;
	}
	public void setWebRecommend(Double webRecommend) {
		this.webRecommend = webRecommend;
	}
	


	
}
