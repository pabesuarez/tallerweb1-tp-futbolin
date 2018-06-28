package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Puntos;

@Repository("puntosRepository")
public class PuntosDaoImpl implements PuntosDao{

	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void Alta(Puntos puntos) {
		sessionFactory.getCurrentSession()
		.save(puntos);
		
	}
}
