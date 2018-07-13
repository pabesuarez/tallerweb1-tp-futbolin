package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoCupo;

public interface CupoDao {

	public List<Cupo> buscar();
	public Cupo buscarPorId(Long Id);
	public List<Cupo> listarCuposPorPartido(Long idPartido);
	public void nuevoPartido(Cupo cupo);
	public void actualizar(Cupo cupo);
	public void eliminar(Cupo cupo);
	public Usuario buscarJugadorPorId(Long idUsuario);
	public void nuevoCupo(FormNuevoCupo cupo);
}
