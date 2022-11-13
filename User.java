public class User{
	private String username;
	private String name;
	private int password;
    private int tk;
    public void setUsername(String username) {
	this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPassword(int password){
		this.password = password;
	}

	public int getPassword(){
		return password;
	}

	public void setTK(int tk){
		this.tk = tk;
	}
	public int getTK(){
		return tk;
	}
}