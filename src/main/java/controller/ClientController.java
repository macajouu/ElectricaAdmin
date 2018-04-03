package controller;

import java.util.ArrayList;

import repository.DataManager;
import model.*;

public class ClientController {
	private DataManager _dataManager;
    
    public ClientController(DataManager dataManager){
        _dataManager = dataManager;
    }
    
    private String ValidateClient(String name, String address, String id){
        if(!name.equals("") && !address.equals("") && !id.equals("")){
            for(int i=0;i<name.length();i++){
                if((!Character.isUpperCase(name.charAt(i))) && (!Character.isLowerCase(name.charAt(i))) && (!Character.isSpaceChar(name.charAt(i)))){
                    return "Invalid character: " + name.charAt(i);
                }
            }
            return null;
        }else{
            return "Name or address cannot be empty!";
        }
    }
    
    public String AddClient(String name, String address, String id){
        //validation
        String valid;
        if((valid = ValidateClient(name, address,id)) != null){
            return valid;
        }
        Client c = new Client(name, address,id);
        //uniqueness
        for(int j=0; j<_dataManager.getClients().size(); j++){
            if(_dataManager.getClients().get(j).equals(c)){
                return "Client already exists!";
            }
        }
        try{
            _dataManager.getClients().add(c);
            //_dataManager.SaveChanges();
            return null;
        }catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public String AddClientIndex(Client c, int year, int month, float toPay){
        if(year > 0){
            if(month > 0){
                if(toPay >= 0){
                    //validate client attributes
                    String valid;
                    if((valid = ValidateClient(c.Name, c.Address, c.idClient)) == null){
                        //check if client exist
                        Boolean exist = false;
                        for(int i=0; i<_dataManager.getClients().size(); i++){
                            if(_dataManager.getClients().get(i).equals(c)){
                                exist = true;
                                break;
                            }
                        }
                        if(exist){
                            Issue i = new Issue(c, year, month, toPay, 0);
                            //uniqueness
                            for(int j=0; j<_dataManager.getInvoices().size(); j++){
                                if(_dataManager.getInvoices().get(j).equals(i)){
                                    return "Monthly index already exists!";
                                }
                            }
                        
                            _dataManager.getInvoices().add(i);
                            _dataManager.SaveChanges();
                            return null;
                        }else{
                            return "Client does not exist!";
                        }
                    }else{
                        return valid;
                    }
                }else{
                    return "Money to pay can't be less than 0!";
                }
            }else{
                return "Month can't be 0 or less!";
            }
        }else{
            return "Year can't be 0 or less!";
        }
    }
    
    public String ListIssue(Client c){
        String s = "";
        String pen = "";
        Double total = 0.0;
        Issue last = null, beforeLast;       
        for(int i=0; i<_dataManager.getInvoices().size(); i++){
            Issue issue = _dataManager.getInvoices().get(i);
        	if(issue.Client.equals(c)){
            	 pen += String.format("Year: %d, Month: %d, Penalty: %2.0f\n", issue.Year, issue.Month, issue.ToPay);
            	 s += pen;
        	}            
        }  
        return s;
    }
    
}
