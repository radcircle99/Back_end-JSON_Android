package org.gseii.ressources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gseii.capteurs.BaseCapteur;
import org.gseii.capteurs.Capteurs;


public class CapService {
	
private Map<Integer, Capteurs> caps = BaseCapteur.getCapteurs();
	
	public CapService() {
	
	}
	
	
	public List<Capteurs> getAllCapteurs() {
		return new ArrayList<Capteurs>(caps.values()); 
	}
	
	public Capteurs getCapteurs(int id) {
		return caps.get(id);
	}
	
	public Capteurs addCapteurs(Capteurs capteur) {
		capteur.setIdCapteur(caps.size()+1);
		caps.put(capteur.getIdCapteur(), capteur);
		return capteur;
	}
	
	public Capteurs updateCapteurs(Capteurs capteur) {
		if (capteur.getIdCapteur() <= 0) {
			return null;
		}
		caps.put(capteur.getIdCapteur(), capteur);
		return capteur;
	}
	
	public Capteurs removeCapteurs(int id) {
		return caps.remove(id);
	}
	

}
