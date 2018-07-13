package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Solicitud;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoCupo;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoPartido;

public interface ServicioPartido {
	
	List<Partido> buscar();
	List<Partido> buscarPorUsuario(long uid);
	Partido buscarId(long id);
	boolean nuevoPartido(FormNuevoPartido partido,long uid);
	void nuevoCupo(FormNuevoCupo cupo);
	void actualizar(Partido partido);
	void eliminar(Partido partido);
	boolean buscarSolicitudDeUsuario(Long cupo,Long uid);
	public void solicitar(Long idUsuario, Long idCupo);
	public void quitarSolicitud(Long idUsuario, Long idCupo);
	public void aceptarSolicitud(Long solicitud);
	public List<Solicitud> buscarSolicitudPartido(Long idPartido);
}
