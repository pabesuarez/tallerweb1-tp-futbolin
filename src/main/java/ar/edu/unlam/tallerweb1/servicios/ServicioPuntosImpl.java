package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PuntosDao;
import ar.edu.unlam.tallerweb1.modelo.Puntos;


@Service("servicioPuntos")
@Transactional
public class ServicioPuntosImpl implements ServicioPuntos{

	@Inject
	private PuntosDao ServicioPuntosDao;
	
	@Override
	public void Alta(Puntos puntos) {
		ServicioPuntosDao.Alta(puntos);
		
	}

}
