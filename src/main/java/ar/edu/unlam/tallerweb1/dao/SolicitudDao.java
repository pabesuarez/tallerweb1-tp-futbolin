package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Solicitud;

public interface SolicitudDao {
	List<Solicitud> buscarSolicitudPorPartido (long partido);
	void nuevaSolicitud(Solicitud solicitud);
}
