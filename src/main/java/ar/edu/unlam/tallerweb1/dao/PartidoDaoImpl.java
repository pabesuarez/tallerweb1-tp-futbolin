package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Partido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public Partido buscarId(long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Partido) session
				.createCriteria(Partido.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Partido> buscarPorUsuario(long uid) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Partido.class)
				.add(Restrictions.eq("organizador.id", uid ))
				.list();
	}

}
