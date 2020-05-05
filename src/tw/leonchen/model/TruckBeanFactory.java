package tw.leonchen.model;

import java.util.HashMap;

public class TruckBeanFactory {
	private HashMap<Integer, TruckBean> map = new HashMap<Integer, TruckBean>();

	public TruckBeanFactory() {
	}

	public void setMap(HashMap<Integer, TruckBean> map) {
		this.map = map;
	}
	
	public TruckBean getTruckBean(int id) {
		return map.get(id);
	}

}
