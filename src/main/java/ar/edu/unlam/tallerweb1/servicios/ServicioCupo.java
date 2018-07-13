package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;



public interface ServicioCupo {

	public Cupo buscarPorId(Long IdCupo);
	public List<Cupo> listarCuposPorPartido(Long IdPartido);
	public Usuario buscarJugadorPorId(Long idUsuario);
}
