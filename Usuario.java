package application;


public class Usuario {
	public static final String ROL_USUARIO = "usuario";
	public static final String ROL_ADMIN = "admin";
	
	protected String Nickname;
	protected String Password;
	protected String Rol;
	protected String Genero;
	
	public Usuario( String Nickname, String Password, String Rol, String Genero) {
		super();
		
		this.Nickname = Nickname;
		this.Password = Password;
		this.Rol = Rol;
		this.Genero= Genero;
	
	}
	
	public String toString() {
		return "Usuario [ Nickname=" + Nickname + ", Password=" + Password + ",Rol=" + Rol+ "+Genero=" + Genero+ "]";
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
	public String getRol() {
		return Rol;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public void setRol(String rol) {
		Rol = rol;
	}


}

