import java.util.HashMap;
import java.util.Map;

public class SingletonMap {
	public static SingletonMap instance = null;
	public static Map<String, QInfo> map = new HashMap<String, QInfo>();
	
	
	public static synchronized SingletonMap getInstance() {
		if(instance == null ) {
			instance = new SingletonMap();
		}
		return instance;
	}
	
	public static Map<String, QInfo> getMap() {
		return map;
	}
	
	public static void setMap(Map<String, QInfo> map) {
		SingletonMap.map = map;
	}	

}
