package ar.edu.unlam.srcCode;

public class Admin extends Usuario implements InterfazUsuarios{

	public Admin(String usuario, String contrasenia, boolean esAdmin) {
		super(usuario, contrasenia, esAdmin);
		
	}

	@Override
	public String getUsuario() {
		return usuario;
	}

	@Override
	public void setUsuario(String usuario) {
		this.usuario= usuario; 
	}

	@Override
	public String getContrasenia() {
		return contrasenia;
	}

	@Override
	public void setContrasenia(String contrasenia) {
		this.contrasenia= contrasenia;  
		
	}

	@Override
	public boolean logueoExitoso(BaseDeDatos bd, Usuario usuario) {
		if(!usuario.getUsuario().isEmpty() && usuario.getContrasenia().length()==8  && 
				 usuario.getContrasenia().contains(".") &&  usuario.getContrasenia().contains("-") &&
				!usuario.getContrasenia().contentEquals("abcd") && !usuario.getContrasenia().contentEquals("1234")) {
			return true; 
		}
		return false;
	}

	@Override
	public boolean getEsAdmin() {
		return false;
	}

	@Override
	public boolean setEsAdmin() {
		return true;
	}

	
	
}
