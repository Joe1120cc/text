package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import entity.CloudFactory;
import entity.CloudFactoryManager;
import entity.Dealer;
import entity.Equipment;
import entity.EquipmentType;
import entity.Product;
import entity.ProductType;

public class Tool {
	public static boolean isIDExisted(String userID) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(userID.equals(cfm.getUserID())) {
				return true;
			}
		}
		for(Object o : dList) {
			Dealer d = (Dealer)o;
			if(userID.equals(d.getUserID())) {
				return true;
			}
		}
		return false;
	}
	
	public static CloudFactory getCloudFactoryByID(String userID) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(userID.equals(cfm.getUserID())) {
				return cfm.getMyCloudFactory();
			}
		}
		return null;
	}
	
	 public static void clearInfoForFile(String filename) {
		 String fileName = "data/" + filename;   
		 File file =new File(fileName);
	        try {
	            if(!file.exists()) {
	                file.createNewFile();
	            }
	            FileWriter fileWriter =new FileWriter(file);
	            fileWriter.write("");
	            fileWriter.flush();
	            fileWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 public static boolean isProductTypeContained(String productType) {
		 List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);
		 for(Object o : pList) {
			 ProductType pt = (ProductType)o;
			 if(pt.getProductType().contains(productType)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 public static boolean isProductTypeExisted(String productType) {
		 List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);
		 for(Object o : pList) {
			 ProductType pt = (ProductType)o;
			 if(pt.getProductType().equals(productType)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isProductIDExisted(String productID) {
		 List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		 for(Object o : pList) {
			 Product p = (Product)o;
			 if(p.getProductID().equals(productID)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isProductDataContained(String data) {
		 List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		 for(Object o : pList) {
			 Product p = (Product)o;
			 if(p.getProductID().contains(data)||p.getProductName().contains(data)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isEquipmentDataContained(String data) {
		 List<Object> pList = FileUtils.getData("Equipments.txt", Equipment.class);
		 for(Object o : pList) {
			 Equipment e = (Equipment)o;
			 if(e.getEquipmentID().contains(data)||e.getEquipmentName().contains(data)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isEquipmentIDExisted(String equipmentID) {
		 List<Object> pList = FileUtils.getData("Equipments.txt", Equipment.class);
		 for(Object o : pList) {
			 Equipment p = (Equipment)o;
			 if(p.getEquipmentID().equals(equipmentID)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isEquipmentTypeContained(String equipmentType) {
		 List<Object> eList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		 for(Object o : eList) {
			 EquipmentType et = (EquipmentType)o;
			 if(et.getEquipmentType().contains(equipmentType)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isEquipmentTypeExisted(String equipmentType) {
		 List<Object> pList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		 for(Object o : pList) {
			 EquipmentType et = (EquipmentType)o;
			 if(et.getEquipmentType().equals(equipmentType)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean isCloudFactoryNameContained(String name) {
			List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
			for(Object o : mList) {
				CloudFactoryManager cfm = (CloudFactoryManager)o;
				if(cfm.getMyCloudFactory().getName().contains(name)) {
					return true;
				}
			}
			return false;
		}
	 
	 public static boolean isCloudFactoryNameExisted(String name) {
			List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
			for(Object o : mList) {
				CloudFactoryManager cfm = (CloudFactoryManager)o;
				if(cfm.getMyCloudFactory().getName().equals(name)) {
					return true;
				}
			}
			return false;
		}
	 
	 public static ArrayList<CloudFactoryManager> getContainedCloudFactory(String name){
		 List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		 ArrayList<CloudFactoryManager> list = new ArrayList<CloudFactoryManager>();
		 for(Object o : mList) {
			 CloudFactoryManager cfm = (CloudFactoryManager)o;
			 if(cfm.getMyCloudFactory().getName().contains(name)) {
				 list.add(cfm);
			 }
		 }
		 return list;
	 }
	 
	 public static String getCloudFactoryStateByName(String name) {
		 List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		 for(Object o : mList) {
				CloudFactoryManager cfm = (CloudFactoryManager)o;
				if(cfm.getMyCloudFactory().getName().equals(name)) {
					return cfm.getMyCloudFactory().getLoginState();
				}
			}
		 return null;
	 }
	 
	 public static void updateCloudFactoryState(String name,String message) {
		 int i=1;
		 List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		 ArrayList<CloudFactoryManager> list = new ArrayList<CloudFactoryManager>();
		 for(Object o : mList) {
			 CloudFactoryManager cfm = (CloudFactoryManager)o;
			 if(cfm.getMyCloudFactory().getName().contains(name)) {
				 cfm.getMyCloudFactory().setLoginState(message);
				 list.add(cfm);
				 continue;
			 }
			 list.add(cfm);
		 }
		 try {
			 for(CloudFactoryManager cfm : list) {
				 String data = GsonUtils.toJson(cfm);
				 if(i==1) {
					 FileUtils.writeData(data, "CloudFactoryManagers.txt", false);
					 i++;
				 }else {
					 FileUtils.writeData(data, "CloudFactoryManagers.txt", true);
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	 }
	 
	 public static boolean rentEquipment(String etID,String userID) {
		 int i=1;
		 List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		 ArrayList<Equipment> list = new ArrayList<Equipment>();
		 for(Object o : eList) {
			 Equipment e = (Equipment)o;
			 if(e.getEquipmentID().equals(etID)) {
				 e.setRentState(userID);
				 list.add(e);
				 continue;
			 }
			 list.add(e);
		 }
		 try {
			 for(Equipment E : list) {
				 String data = GsonUtils.toJson(E);
				 if(i==1) {
					 FileUtils.writeData(data, "Equipments.txt", false);
					 i++;
				 }else {
					 FileUtils.writeData(data, "Equipments.txt", true);
				 }
			 }
		} catch (Exception e) {
			return false;
		}
		 return true;
	 }
	 
	 public static void updateEquipmentState(String eId,String message) {
		 int i=1;
		 List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		 ArrayList<Equipment> list = new ArrayList<Equipment>();
		 for(Object o : eList) {
			 Equipment e = (Equipment)o;
			 if(e.getEquipmentID().equals(eId)) {
				 e.setEquipmentState(message);
				 list.add(e);
				 continue;
			 }
			 list.add(e);
		 }
		 try {
			 for(Equipment e : list) {
				 String data = GsonUtils.toJson(e);
				 if(i==1) {
					 FileUtils.writeData(data, "Equipments.txt", false);
					 i++;
				 }else {
					 FileUtils.writeData(data, "Equipments.txt", true);
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	 }
	 
	 public static String getEquipmentStateByID(String eid) {
		 List<Object> mList = FileUtils.getData("Equipments.txt", Equipment.class);
		 for(Object o : mList) {
			 Equipment e = (Equipment)o;
				if(e.getEquipmentID().equals(eid)) {
					return e.getEquipmentState();
				}
			}
		 return null;
	 }

}
