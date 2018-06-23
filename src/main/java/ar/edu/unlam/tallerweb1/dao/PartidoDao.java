package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface PartidoDao {
	
	public List<Partido> buscar();
	public void nuevoPartido(Partido partido);
	public void actualizar(Partido partido);
	public void eliminar(Partido partido);
}
