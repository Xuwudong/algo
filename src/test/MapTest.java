package test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,Boolean> map =new HashMap<>();
		map.put("test", true);
		System.out.println(map.get("test"));
		map.put("test", false);
		System.out.println(map.get("test"));
	}
}
