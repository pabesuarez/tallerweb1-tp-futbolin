package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface PartidoDao {
	
	public List<Partido> buscar();
	public List<Partido> buscarPorUsuario(long uid);
	public Partido buscarId(long id);
	public boolean nuevoPartido(Partido partido,long uid);
	public void actualizar(Partido partido);
	public void eliminar(Partido partido);
}
