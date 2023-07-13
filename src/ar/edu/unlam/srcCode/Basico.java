package ar.edu.unlam.srcCode;

public class Basico extends Usuario implements InterfazUsuarios{

	
	 protected Integer numeroDeLogueos; 
	 
	public Basico(String usuario, String contrasenia, boolean esAdmin) {
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
	public boolean logueoExitoso(BaseDeDatos bd, Usuario usuario) throws UserNotFound{
		try{
			if(!usuario.getUsuario().isEmpty() && usuario.getContrasenia().length()==8 
				&& bd.usuarios.contains(usuario)) {
			return true; 
		}
			else {throw new UserNotFound ("usuario no encontrado"); }
	}
		
	catch (UserNotFound e) {
		System.out.println(e.getMessage()); 
		return false; 
	}	
	}


	
	public boolean contraseniaCorrecta(BaseDeDatos bd, Usuario usuario) throws  InvalidPassword{
		try{
			if(bd.usuarios.contains(usuario) && usuario.getContrasenia().length()>=8) {
			return true; 
		}
			else {throw new InvalidPassword ("contrasenia Invalida"); }
	}
		
	catch (InvalidPassword e) {
		System.out.println(e.getMessage()); 
		return false; 
	}	
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
