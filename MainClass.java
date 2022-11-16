public class MainClass {
	public static void main (String args[]){

		IDandPasswords iDandPasswords = new IDandPasswords();
		iDandPasswords.getLoginInfo();//makes subject to bring my hash map at the main class

		LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());

	}
}