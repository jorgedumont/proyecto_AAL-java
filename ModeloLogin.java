package application;

public class ModeloLogin {

	
	public String Nickname;
	public String Password;
	
	
	public ModeloLogin(String Nickname, String Password) {
		super();
		this.Nickname = Nickname;
		this.Password = Password;
	}
	
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String Nickname) {
		this.Nickname = Nickname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
}

