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

	@Override
	public Integer PuntajeResultado(Puntos puntos) {
		int p1 = puntos.getGolesComoArquero()*10;
		int p2=puntos.getGolesComoDefensor()*8;
		int p3=puntos.getGolesComoDelantero()*4;
		int p4=puntos.getGolesComoVolante()*5;
		int p5=puntos.getGolesDePenal()*3;
		int p6=puntos.getGolesEnContra()*-2;
		int p7=puntos.getGolesRecibidos()*-1;
		int p8=puntos.getPenalesAtajados()*4;
		int p9=puntos.getPenalesErrados()*-4;
		int p10=puntos.getTarjetaRoja()*-4;
		int p11=puntos.getTarjetasAmarillas()*-2;
		
		int puntajeTotal=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11;

		
		
		return puntajeTotal;

	}

}
