package comment.bean;

import java.math.BigDecimal;

import com.github.abel533.echarts.Option;

public class BarcharBean {
	private Double avgwebGrading;
	private Double avgFluency;
	private Double webSatis;
	private Double webRecommend;
	private Double dataNum;
	private Integer memCommented;
	private Long exGrading;
	public BarcharBean(Integer memCommented, Long exGrading) {
		super();
		this.memCommented = memCommented;
		this.exGrading = exGrading;
	}

	public Integer getMemCommented() {
		return memCommented;
	}

	public void setMemCommented(Integer memCommented) {
		this.memCommented = memCommented;
	}

	public Long getExGrading() {
		return exGrading;
	}

	public void setExGrading(Long exGrading) {
		this.exGrading = exGrading;
	}

	private Option option;

    

	public BarcharBean(Double avgwebGrading, Double avgFluency, Double webSatis, Double webRecommend, Double dataNum,
			Option option) {
		super();
		this.avgwebGrading = avgwebGrading;
		this.avgFluency = avgFluency;
		this.webSatis = webSatis;
		this.webRecommend = webRecommend;
		this.dataNum = dataNum;
		this.option = option;
	}

	public Double getAvgwebGrading() {
		return avgwebGrading;
	}

	public void setAvgwebGrading(Double avgwebGrading) {
		this.avgwebGrading = avgwebGrading;
	}

	public Double getAvgFluency() {
		return avgFluency;
	}

	public void setAvgFluency(Double avgFluency) {
		this.avgFluency = avgFluency;
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

	public Double getDataNum() {
		return dataNum;
	}

	public void setDataNum(Double dataNum) {
		this.dataNum = dataNum;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}
