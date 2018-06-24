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
		// TODO Auto-generated method stub
		return servicioPartidoDao.buscar();
	}

	@Override
	public void nuevoPartido(Partido partido) {
		servicioPartidoDao.nuevoPartido(partido);
		
	}

	@Override
	public void actualizar(Partido partido) {
		servicioPartidoDao.actualizar(partido);
		
	}

	@Override
	public void eliminar(Partido partido) {
		servicioPartidoDao.eliminar(partido);
		
	}

	

}