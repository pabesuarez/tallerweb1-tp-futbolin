package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CupoDao;
import ar.edu.unlam.tallerweb1.dao.SolicitudDao;
import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioCupo")
@Transactional
public class ServicioCupoImpl implements ServicioCupo {

	@Inject
	private CupoDao servicioCupoDao;
	
	@Inject
	private SolicitudDao servicioSolicitudDao;


	@Override
	public List<Cupo> listarCuposPorPartido(Long IdPartido) {
		return servicioCupoDao.listarCuposPorPartido(IdPartido);
	}


	@Override
	public Usuario buscarJugadorPorId(Long idUsuario) {
		return servicioCupoDao.buscarJugadorPorId(idUsuario);
	}
	
	public boolean tieneSolicitudDePartido(Long cupo,Long uid) {
		return servicioSolicitudDao.buscarSolicitudDeUsuario(cupo,uid);
	}


	@Override
	public Cupo buscarPorId(Long IdCupo) {
		return null;
	}
	

}
