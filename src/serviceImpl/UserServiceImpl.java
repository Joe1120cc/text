package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.CloudFactoryManager;
import entity.Dealer;
import entity.Equipment;
import entity.User;
import service.UserService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

public class UserServiceImpl implements UserService{

	@Override
	public int verify(String userID, String password) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		for(Object o : mList) {
			CloudFactoryManager user = (CloudFactoryManager)o;
			if(user.getUserID().equals(userID)&&user.getUserPassword().equals(password)) {
				return 1;
			}
		}
		for(Object o : dList) {
			Dealer user = (Dealer)o;
			if(user.getUserID().equals(userID)&&user.getUserPassword().equals(password)) {
				return 2;
			}
		}
		return 0;
	}

	@Override
	public boolean addCloudFactoryManager(CloudFactoryManager cfm) {
		try {
			String data = GsonUtils.toJson(cfm);
			FileUtils.writeData(data, "CloudFactoryManagers.txt", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addDealer(Dealer d) {
		try {
			String data = GsonUtils.toJson(d);
			FileUtils.writeData(data, "Dealers.txt", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String userID) {
		// TODO Auto-generated method stub
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		List<CloudFactoryManager> updatedMList = new ArrayList<CloudFactoryManager>();
		List<Dealer> updatedDList = new ArrayList<Dealer>();
		List<Object> equipments = FileUtils.getData("Equipments.txt", Equipment.class);
		List<Equipment> updatedEquipments = new ArrayList<Equipment>();
		int i=1,j=1,k=1;
		
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(!cfm.getUserID().equals(userID)) {
				updatedMList.add(cfm);
			}
		}
		
		for(Object o : dList) {
			Dealer d = (Dealer)o;
			if(!d.getUserID().equals(userID)) {
				updatedDList.add(d);
			}
		}
		
		for(Object o : equipments) {
			Equipment emt = (Equipment)o;
			if(!emt.getEquipmentOwnedFactory().getMyManagerID().equals(userID)) {
				updatedEquipments.add(emt);
			}
		}
		
		if(updatedMList.isEmpty()) {
			Tool.clearInfoForFile("CloudFactoryManagers.txt");
		}
		if(updatedDList.isEmpty()) {
			Tool.clearInfoForFile("Dealers.txt");
		}
		if(updatedEquipments.isEmpty()) {
			Tool.clearInfoForFile("Equipments.txt");
		}
		for(CloudFactoryManager cfm : updatedMList) {
			String data = GsonUtils.toJson(cfm);
			try {
				if(i==1) {
					FileUtils.writeData(data, "CloudFactoryManagers.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "CloudFactoryManagers.txt", true);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		for(Dealer d : updatedDList) {
			String data = GsonUtils.toJson(d);
			try {
				if(j==1) {
					FileUtils.writeData(data, "Dealers.txt", false);
					j++;
				}else {
					FileUtils.writeData(data, "Dealers.txt", true);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		
		for(Equipment emt : updatedEquipments) {
			String data = GsonUtils.toJson(emt);
			try {
				if(k==1) {
					FileUtils.writeData(data, "Equipments.txt", false);
					k++;
				}else {
					FileUtils.writeData(data, "Equipments.txt", true);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		
		return true;
	}

	@Override
	public User getUserById(String userID) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(cfm.getUserID().equals(userID)) {
				return cfm;
			}
		}
		for(Object o : dList) {
			Dealer d = (Dealer)o;
			if(d.getUserID().equals(userID)) {
				return d;
			}
		}
		return null;
	}

	@Override
	public boolean changeCloudFactoryManager(CloudFactoryManager cfm) {
		int i=1;
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<CloudFactoryManager> cfms = new ArrayList<CloudFactoryManager>();
		for(Object o : mList) {
			CloudFactoryManager CFM = (CloudFactoryManager)o;
			if(CFM.getUserID().equals(cfm.getUserID())) {
				cfms.add(cfm);
				continue;
			}
			cfms.add(CFM);
		}
		for(CloudFactoryManager C : cfms) {
			String data = GsonUtils.toJson(C);
			try {
				if(i==1) {
					FileUtils.writeData(data, "CloudFactoryManagers.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "CloudFactoryManagers.txt", true);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean changeDealer(Dealer d) {
		int i=1;
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		List<Dealer> dls = new ArrayList<Dealer>();
		for(Object o : dList) {
			Dealer D = (Dealer)o;
			if(D.getUserID().equals(d.getUserID())) {
				dls.add(d);
				continue;
			}
			dls.add(D);
		}
		for(Dealer DL : dls) {
			String data = GsonUtils.toJson(DL);
			try {
				if(i==1) {
					FileUtils.writeData(data, "Dealers.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "Dealers.txt", true);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

}
