package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface ServicioPartido {
	
	List<Partido> buscar();
	List<Partido> buscarPorUsuario(long uid);
	Partido buscarId(long id);
	boolean nuevoPartido(Partido partido,long uid);
	void actualizar(Partido partido);
	void eliminar(Partido partido);
	
}
