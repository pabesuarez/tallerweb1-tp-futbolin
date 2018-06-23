package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Cupo;

public class CupoDaoImpl implements CupoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Cupo> buscar() {
		return sessionFactory.getCurrentSession()
			.createCriteria(Cupo.class)
			.list();
	}

	@Override
	public void nuevoPartido(Cupo cupo) {
		sessionFactory.getCurrentSession()
		.save(cupo);
		
	}

	@Override
	public void actualizar(Cupo cupo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cupo cupo) {
		sessionFactory.getCurrentSession()
		.delete(cupo);
	}

}
