package ar.edu.unlam.srcCode;

import java.util.Objects;

public abstract class Usuario {

	protected String usuario; 
	protected String contrasenia;
	protected boolean esAdmin; 
	
	
	public Usuario(String usuario, String contrasenia, boolean esAdmin) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.esAdmin= esAdmin; 
	}

    public abstract boolean getEsAdmin(); 
    public abstract boolean setEsAdmin(); 
	
	public abstract String getUsuario();


	public abstract void setUsuario(String usuario);


	public abstract String getContrasenia();


	public abstract void setContrasenia(String contrasenia);


	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
	}
	
	
	
	
	
}
