package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Partido;

@Service("partidoLogin")
@Transactional

public class ServicioPartidoImpl implements ServicioPartido{
	
	@Inject
	private PartidoDao servicioPartidoDao;

	@Override
	public List<Partido> buscar() {
		return servicioPartidoDao.buscar();
	}

	@Override
	public boolean nuevoPartido(Partido partido,long uid) {
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

	

}
