package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Solicitud;

public interface SolicitudDao {
	List<Solicitud> buscarSolicitudPorPartido (long partido);
	void nuevaSolicitud(Solicitud solicitud);
	public boolean buscarSolicitudDeUsuario(Long cupo,Long uid);
	public void quitarSolicitud(Long idUsuario, Long idCupo);
	public void aceptarSolicitud(Long solicitud);
	public List<Solicitud> buscarSolicitudPartido(Long idPartido);
}
