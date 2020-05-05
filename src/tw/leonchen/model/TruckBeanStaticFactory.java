package tw.leonchen.model;

import java.util.HashMap;

public class TruckBeanStaticFactory {
   private static HashMap<Integer, TruckBean> map = new HashMap<Integer, TruckBean>();
   
   static {
	   map.put(1, new TruckBean(3, "Tesla"));
	   map.put(2, new TruckBean(4, "Apple"));
   }
   
   public static TruckBean getTruckBean(int id) {
	   return map.get(id);
   }
}
