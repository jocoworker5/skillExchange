package comment.bean;

import java.math.BigDecimal;

import com.github.abel533.echarts.Option;

public class BarcharBean {
   private BigDecimal avgwebGrading;
   private BigDecimal avgFluency;
   private BigDecimal webSatis;
   private BigDecimal webRecommend;
   private int dataNum;
   private Option option;
   
   
public BarcharBean(BigDecimal avgwebGrading, BigDecimal avgFluency, BigDecimal webSatis, BigDecimal webRecommend,
		int dataNum, Option option) {
	super();
	this.avgwebGrading = avgwebGrading;
	this.avgFluency = avgFluency;
	this.webSatis = webSatis;
	this.webRecommend = webRecommend;
	this.dataNum = dataNum;
	this.option = option;
}
public BigDecimal getAvgwebGrading() {
	return avgwebGrading;
}
public void setAvgwebGrading(BigDecimal avgwebGrading) {
	this.avgwebGrading = avgwebGrading;
}
public BigDecimal getAvgFluency() {
	return avgFluency;
}
public void setAvgFluency(BigDecimal avgFluency) {
	this.avgFluency = avgFluency;
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
public int getDataNum() {
	return dataNum;
}
public void setDataNum(int dataNum) {
	this.dataNum = dataNum;
}
public Option getOption() {
	return option;
}
public void setOption(Option option) {
	this.option = option;
}
   

   
   
}
