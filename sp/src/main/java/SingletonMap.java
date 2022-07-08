import java.util.HashMap;
import java.util.Map;

public class SingletonMap {
	public static SingletonMap instance = null;
	public static Map<String, String> map = new HashMap<String, String>();
	
	
	public static synchronized SingletonMap getInstance() {
		if(instance == null ) {
			instance = new SingletonMap();
		}
		return instance;
	}
	
	public static Map<String, String> getMap() {
		return map;
	}
	
	public static void setMap(Map<String, String> map) {
		SingletonMap.map = map;
	}	

}
