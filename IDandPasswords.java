import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>(); //Matches key with a value like DB

	//constractor
	IDandPasswords(){
		logininfo.put("Zoi","icecream");//It makes my Hashmap
		logininfo.put("Bro","burger");
		logininfo.put("Loko","pizza");
	}
	protected HashMap getLoginInfo(){//method that returns my Hashmap
		return logininfo;
	}


}



