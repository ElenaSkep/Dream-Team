import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User{
	@NotBlank(message = "Username may not be blank")
	private String username;
	@NotBlank(message = "Name may not be blank")
	private String name;
	@Size(min = 8, max = 64, message = "Password must be 8-64 char long")
	private String password;
	@NotBlank(message = "Postal code may not be blank")
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
