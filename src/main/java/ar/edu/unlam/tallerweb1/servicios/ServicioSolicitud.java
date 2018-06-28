package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Solicitud;

public interface ServicioSolicitud {

	List<Solicitud> buscarSolicitudPorPartido (long partido);
	void nuevaSolicitud(Solicitud solicitud);
}
