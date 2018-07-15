package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CupoDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.dao.SolicitudDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Solicitud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoCupo;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoPartido;

@Service("partidoLogin")
@Transactional

public class ServicioPartidoImpl implements ServicioPartido{
	
	@Inject
	private PartidoDao servicioPartidoDao;
	@Inject
	private SolicitudDao servicioSolicitudDao;
	@Inject
	private UsuarioDao servicioUsuarioDao;
	@Inject
	private CupoDao servicioCupoDao;

	@Override
	public List<Partido> buscar() {
		return servicioPartidoDao.buscar();
	}

	@Override
	public boolean nuevoPartido(FormNuevoPartido partido,long uid) {
		return servicioPartidoDao.nuevoPartido(partido, uid);
		
	}

	@Override
	public void actualizar(Partido partido) {
		servicioPartidoDao.actualizar(partido);
		
	}

	@Override
	public void eliminar(Partido partido) {
		servicioPartidoDao.eliminar(partido);
		
	}

	@Override
	public Partido buscarId(long id) {	
		return servicioPartidoDao.buscarId(id);
	}

	@Override
	public List<Partido> buscarPorUsuario(long uid) {
		return servicioPartidoDao.buscarPorUsuario(uid);
	}

	@Override
	public boolean buscarSolicitudDeUsuario(Long cupo, Long uid) {
		return servicioSolicitudDao.buscarSolicitudDeUsuario(cupo, uid);
	}

	@Override
	public void solicitar(Long idUsuario, Long idCupo) {
		Usuario solicitante = servicioUsuarioDao.buscarUsuarioPorId(idUsuario);
		Cupo cupo = servicioCupoDao.buscarPorId(idCupo);
		Solicitud solicitud = new Solicitud();
		solicitud.setCupo(cupo);
		solicitud.setUsuario(solicitante);
		servicioSolicitudDao.nuevaSolicitud(solicitud);
	}
	
	@Override
	public void quitarSolicitud(Long idUsuario, Long idCupo) {
		servicioSolicitudDao.quitarSolicitud(idUsuario,idCupo);
	}

	@Override
	public List<Solicitud> buscarSolicitudPartido(Long idPartido) {
		return servicioSolicitudDao.buscarSolicitudPartido(idPartido);
	}

	@Override
	public void nuevoCupo(FormNuevoCupo cupo) {
		servicioCupoDao.nuevoCupo(cupo);
	}

	@Override
	public void aceptarSolicitud(Long solicitud) {
		servicioSolicitudDao.aceptarSolicitud(solicitud);
		
	}

	@Override
	public void cancelarCupo(Long idCupo) {
		servicioCupoDao.cancelarCupo(idCupo);
		
	}


	
	

}
