package ar.edu.unlam.srcTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.srcCode.Admin;
import ar.edu.unlam.srcCode.BaseDeDatos;
import ar.edu.unlam.srcCode.Basico;
import ar.edu.unlam.srcCode.ClassCastException;
import ar.edu.unlam.srcCode.InvalidPassword;
import ar.edu.unlam.srcCode.UserNotFound;
import ar.edu.unlam.srcCode.Usuario;

public class TestSoftware {

	@Test
	public void testCrearUnUsuarioBasico() {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
		
		Usuario basico1 = new Basico("Maia Britez", "1aam56jku", false); 
		
		software.agregarUsuario(basico1);
		
		assertEquals((Integer)1, software.numeroUsuarios()); 
		
	}

	
	@Test
	public void testCrearUnUsuarioAdmin() {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
		
		Usuario admin1 = new Admin("Maia Britez", "1aam56jku", true); 
		
		software.agregarUsuario(admin1);
		
		assertEquals((Integer)1, software.numeroUsuarios()); 
		
	}

	
	@Test
	public void testQueNoPuedaHaberDosOMasUsuariosConElMismoNombre() {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
		
		Usuario basico1 = new Basico("Maia Britez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 
		Usuario basico4 = new Basico("Martin Gomez", "1aam095", false); 
		
		software.agregarUsuario(basico1);
		software.agregarUsuario(basico2);
		software.agregarUsuario(admin1);
		software.agregarUsuario(basico4);
		
		//aunque agregue a usuarios al usuario basico4 y al usuario admin1, solo me toma uno solo en el hashset
		//porque el user es el mismo
		assertEquals((Integer)3, software.numeroUsuarios()); 
		
	}
	
	@Test
	public void testQueSePuedaBloquearUnUsuarioBasico() {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
		
		Usuario basico1 = new Basico("Carla Perez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		
		
		software.agregarUsuario(basico1);
		software.agregarUsuario(basico2);
		software.agregarUsuario(basico3);
		
		software.bloquear(((Basico)basico1));
		software.bloquear(((Basico)basico2));
		software.bloquear(((Basico)basico3));
		
		assertEquals((Integer)3, software.numeroUsuariosBloqueados()); 
		
	}
	
	
	@Test
	public void testQueSePuedaEliminarUnUsuarioBasico() throws ClassCastException {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
		
		Usuario basico1 = new Basico("Carla Perez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 
		
		software.agregarUsuario(basico1);
		software.agregarUsuario(basico2);
		software.agregarUsuario(basico3);
		
		software.eliminar(basico1); 
		software.eliminar(basico2); 
		software.eliminar(basico3); 
		
		assertEquals((Integer)3, software.numeroUsuariosEliminados()); 
	
	}
	
	

	@Test
	public void testQueNoSePuedaEliminarUnUsuarioAdmin() throws ClassCastException {
		
		BaseDeDatos software = new BaseDeDatos("System"); 
	
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 

		software.agregarUsuario(basico3);
		software.agregarUsuario(admin1);
		
		assertFalse(software.eliminar(admin1)); 
	
	}
	
	
	@Test
	public void testQueUnaVezEliminadosLosUsuariosSeBorrenDeLaBaseDeDatos() throws ClassCastException{
		
		BaseDeDatos software = new BaseDeDatos("System"); 
	
		Usuario basico1 = new Basico("Carla Perez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 

		//agrego 4 usuarios
		
		software.agregarUsuario(basico3);
		software.agregarUsuario(admin1);
		software.agregarUsuario(basico2);
		software.agregarUsuario(basico1);
		
		//elimino un usuario
		software.eliminar(((Basico)basico3));  
		
		//espero que de los 4 se elimine de la lista el que elimine
		assertEquals((Integer)3, software.numeroUsuarios()); 
	
	}
	
	
	@Test
	public void testQueUnUsuarioQueNoExisteNoSePuedaLoguear() throws UserNotFound{
		
		BaseDeDatos software = new BaseDeDatos("System"); 
	
		Usuario basico1 = new Basico("Carla Perez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 

		//agrego 4 usuarios
		
		software.agregarUsuario(basico3);
		software.agregarUsuario(admin1);
		software.agregarUsuario(basico2);
		
		((Basico)basico1).logueoExitoso(software, basico1); 
        
	
	}
	
	@Test
	public void testQueSeDevuelvanLosUsuariosOrdenadosPorNombre(){
		
		BaseDeDatos software = new BaseDeDatos("System"); 
	
		Usuario basico1 = new Basico("Carla Perez", "1aam56jku", false); 
		Usuario basico2 = new Basico("Jose Perez", "13am56jku", false); 
		Usuario basico3 = new Basico("Marcos Perez", "13am56jku", false); 
		Usuario admin1 = new Basico("Martin Gomez", "880m56jku", true); 
		Usuario basico4 = new Basico("Adela Perez", "1aam56jku", false); 
		Usuario basico5 = new Basico("Zaira Perez", "13am56jku", false); 
		Usuario basico6 = new Basico("Florencia Perez", "13am56jku", false); 
		Usuario admin2= new Basico("Wanda Gomez", "880m56jku", true); 

		//agrego 4 usuarios
		
		software.agregarUsuario(basico1);
		software.agregarUsuario(admin2);
		software.agregarUsuario(basico2);
		software.agregarUsuario(basico3);
		software.agregarUsuario(admin1);
		software.agregarUsuario(basico4);
		software.agregarUsuario(basico5);
		software.agregarUsuario(basico6);

		
		software.ordenarPorNombreDeUsuario();
        
	
	}
	
	
	@Test
	public void testQueUnaContraseniaInvalidaGenereExcepcion() throws InvalidPassword{
		
		BaseDeDatos software = new BaseDeDatos("System"); 
	
		Usuario basico1 = new Basico("Carla Perez", "100aaa", false); 
		
		software.agregarUsuario(basico1);
	
		assertFalse(((Basico)basico1).contraseniaCorrecta(software, basico1)); 
        
	
	}
	
}
