package comment.bean;

import java.math.BigDecimal;

public class LChartBean {
	private int mon;
	private BigDecimal webgrading;
	private BigDecimal webFluency;
	private BigDecimal webSatis;
	private BigDecimal webRecommend;
	
	public LChartBean(int mon, BigDecimal webgrading, BigDecimal webFluency, BigDecimal webSatis,
			BigDecimal webRecommend) {
		super();
		this.mon = mon;
		this.webgrading = webgrading;
		this.webFluency = webFluency;
		this.webSatis = webSatis;
		this.webRecommend = webRecommend;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public BigDecimal getWebgrading() {
		return webgrading;
	}
	public void setWebgrading(BigDecimal webgrading) {
		this.webgrading = webgrading;
	}
	public BigDecimal getWebFluency() {
		return webFluency;
	}
	public void setWebFluency(BigDecimal webFluency) {
		this.webFluency = webFluency;
	}
	public BigDecimal getWebSatis() {
		return webSatis;
	}
	public void setWebSatis(BigDecimal webSatis) {
		this.webSatis = webSatis;
	}
	public BigDecimal getWebRecommend() {
		return webRecommend;
	}
	public void setWebRecommend(BigDecimal webRecommend) {
		this.webRecommend = webRecommend;
	}
	
}
