package Pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aBean {  
    private String name,password,age,gender,bio;  
    private ArrayList<String[]> accounts = new ArrayList<String[]>();
    private ArrayList<String[]> info = new ArrayList<String[]>();  
    private int index;
    public String getName() {  
        return name;  
    }  
    public void setNamePassword(String name, String password ) {  
        this.name = name;
        this.password = password;

    }
    public boolean setNewAccount(String name, String password ) {  
        this.name = name;
        this.password = password;
        		
        		if (deepContains(accounts,new String[] {name,password,})) {
        			return false;
        		}else {
        			 accounts.add(new String[] {name,password});
        			 return true;
        		}
        		
    }
    public void setInfo(String age, String gender, String bio, int i) {
    	this.setAge(age);
    	this.setGender(gender);
    	this.setBio(bio);
    	info.set(i, new String[] {age,gender,bio});
    	
    }
    public String[] getInfo(int i) {
    	return info.get(i);
    }
    public String getPassword() {  
        return password;  
    }  
    public int getIndex() {
    	return index;
    }
    public String getAccount(int i) {
		return Arrays.toString(accounts.get(i));
    }
    public ArrayList<String[]> getAllAccounts() {
    		return accounts;
		
    }
   
    public static boolean deepContains(List<String[]> accounts, String[] probe) {
        for (String[] element : accounts) {
          if (Arrays.deepEquals(element, probe)) {
            return true;
          }
        }
        return false;
      }
    
    
    public boolean validate(String name,String pass){ 
    	if(name.equals("admin")&&pass.equals("admin")) {
        //if(deepContains(accounts,new String[] {name,password})){
        //	index = accounts.indexOf(new String[] {name,password}); 
        return true;  
            
        }  
        else{  
            return false;  
        }  
        
    }
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}  
}  