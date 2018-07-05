package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioUsuario {
	
	Usuario buscarUsuarioPorId(Long idUsuario);
	boolean nuevoUsuario(Usuario usuario);
}
