package ar.edu.unlam.srcCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BaseDeDatos {

	
	protected String nombre; 
	protected HashSet<Usuario> usuarios; 
	protected HashSet<Usuario> usuariosBloqueados; 
	protected HashSet<Usuario> usuariosEliminados;
	
	
	public BaseDeDatos(String nombre) {
		this.nombre = nombre;
		this.usuariosBloqueados = new HashSet<>();
		this.usuariosEliminados = new HashSet<>();
		this.usuarios = new HashSet<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario); 
	}
	
	
	public Integer numeroUsuarios() {
		return usuarios.size();  
	}
	
	
	public Integer numeroUsuariosBloqueados() {
		return usuariosBloqueados.size();  
	}
	
	
	public Integer numeroUsuariosEliminados() {
		return usuariosEliminados.size();  
	}
	
	public void bloquear(Basico basico) {
			if(usuarios.contains(basico)) {
				usuariosBloqueados.add(basico); 
			}
	}
	
	
	public boolean eliminar(Usuario usuario) throws ClassCastException{
	  try {
		  if(usuario.esAdmin==false && usuarios.contains(usuario)) {
			  usuariosEliminados.add(usuario);
			  usuarios.remove(usuario); 
			  return true; 
		  }
		  else {throw new ClassCastException ("este usuario no es eliminable porque es administrador"); }
	  }
	  catch(ClassCastException e) {
		  System.out.println(e.getMessage()); 
		  return false; 
	  }
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public HashSet<Usuario> getUsuariosBloqueados() {
		return usuariosBloqueados;
	}


	public void setUsuariosBloqueados(HashSet<Usuario> usuariosBloqueados) {
		this.usuariosBloqueados = usuariosBloqueados;
	}


	public HashSet<Usuario> getUsuariosEliminados() {
		return usuariosEliminados;
	}


	public void setUsuariosEliminados(HashSet<Usuario> usuariosEliminados) {
		this.usuariosEliminados = usuariosEliminados;
	} 


	
	
	public void ordenarPorNombreDeUsuario() {
		
		if(!this.usuarios.isEmpty()) {
		
			ArrayList<Usuario> listaUsuarios= new ArrayList<>(usuarios);  
			
			Collections.sort(listaUsuarios, new Ordenamiento());
			
			for(Usuario u: listaUsuarios) {
				System.out.println(u.getUsuario()); 
			}
		}
		
	}
	
	
	
	
}
