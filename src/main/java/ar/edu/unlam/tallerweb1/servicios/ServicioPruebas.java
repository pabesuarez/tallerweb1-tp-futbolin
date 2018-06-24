package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioPruebas {
	
	List<Usuario> listarUsuarios();	
	Usuario Buscar(Long uid);
}
