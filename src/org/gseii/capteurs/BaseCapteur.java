package org.gseii.capteurs;

import java.util.HashMap;
import java.util.Map;

public class BaseCapteur {

	private static Map<Integer, Capteurs> capteurs = new HashMap<>();

	
	public static Map<Integer, Capteurs> getCapteurs() {
		return capteurs;
	}
}
