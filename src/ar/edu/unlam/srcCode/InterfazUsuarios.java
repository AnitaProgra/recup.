package ar.edu.unlam.srcCode;

public interface InterfazUsuarios {

	//este metodo debe ser usuado por cualquier usuario del sistema
	public boolean logueoExitoso(BaseDeDatos bd, Usuario usuario) throws UserNotFound; 
}
