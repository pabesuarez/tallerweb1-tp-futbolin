package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cupo;

public interface CupoDao {

	public List<Cupo> buscar();
	public void nuevoPartido(Cupo cupo);
	public void actualizar(Cupo cupo);
	public void eliminar(Cupo cupo);
}
