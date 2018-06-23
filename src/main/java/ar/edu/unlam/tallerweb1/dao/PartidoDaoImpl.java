package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.inject.Inject;

@Repository("partidoDao")
public class PartidoDaoImpl implements PartidoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Partido> buscar() {
		return sessionFactory.getCurrentSession()
			.createCriteria(Partido.class)
			.list();
	}

	@Override
	public void nuevoPartido(Partido partido) {
		sessionFactory.getCurrentSession()
		.save(partido);
	}

	@Override
	public void actualizar(Partido partido) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(Partido partido) {
		sessionFactory.getCurrentSession()
		.delete(partido);
	}

}
