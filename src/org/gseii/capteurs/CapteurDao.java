package org.gseii.capteurs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CapteurDao {
	
	public List<Capteurs> getAllCapteurs(){
	      List<Capteurs> capteurList = null;
	      try {
	         File file = new File("Capteurs.dat");
	         if (!file.exists()) {
	        	Capteurs cap= new Capteurs(0, "Temperature", "Cuisine", 27);
	        	Capteurs cap1= new Capteurs(1, "Humidite", "Salon", 10);
	        	Capteurs cap2= new Capteurs(2, "Luminosite", "Terasse", 27);
	        	Capteurs cap3= new Capteurs(3, "fumee", "Cuisine", 0.5);
	            
	        	capteurList = new ArrayList<Capteurs>();
	            capteurList.add(cap);
	            capteurList.add(cap1);
	            capteurList.add(cap2);
	            capteurList.add(cap3);
	            
	            saveCapteursList(capteurList);		
	         }
	         else{
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            capteurList = (List<Capteurs>) ois.readObject();
	            ois.close();
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }		
	      return capteurList;
	   }

	   public Capteurs getCapteur(int id){
	      List<Capteurs> capteurs = getAllCapteurs();

	      for(Capteurs capteur: capteurs){
	         if(capteur.getIdCapteur() == id){
	            return capteur;
	         }
	      }
	      return null;
	   }

	   public int addCapteur(Capteurs pcap){
	      List<Capteurs> capteurList = getAllCapteurs();
	      boolean capteurExists = false;
	      for(Capteurs capteurs: capteurList){
	         if(capteurs.getIdCapteur() == pcap.getIdCapteur()){
	            capteurExists = true;
	            break;
	         }
	      }		
	      if(!capteurExists){
	         capteurList.add(pcap);
	         saveCapteursList(capteurList);
	         return 1;
	      }
	      return 0;
	   }

	   public int updateCapteur(Capteurs pcap){
	      List<Capteurs> capteurList = getAllCapteurs();

	      for(Capteurs capteur: capteurList){
	         if(capteur.getIdCapteur() == pcap.getIdCapteur()){
	            int index = capteurList.indexOf(capteur);			
	            capteurList.set(index, pcap);
	            saveCapteursList(capteurList);
	            return 1;
	         }
	      }		
	      return 0;
	   }

	   public int deleteCapteur(int id){
	      List<Capteurs> capteurList = getAllCapteurs();

	      for(Capteurs capteur: capteurList){
	         if(capteur.getIdCapteur() == id){
	            int index = capteurList.indexOf(capteur);			
	            capteurList.remove(index);
	            saveCapteursList(capteurList);
	            return 1;   
	         }
	      }		
	      return 0;
	   }

	   private void saveCapteursList(List<Capteurs> capteurList){
	      try {
	         File file = new File("Capteurs.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);		
	         oos.writeObject(capteurList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
}
