package ar.edu.unlam.srcCode;

import java.util.Comparator;

public class Ordenamiento implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return (o1.getUsuario().compareTo(o2.getUsuario()));
	}


}
