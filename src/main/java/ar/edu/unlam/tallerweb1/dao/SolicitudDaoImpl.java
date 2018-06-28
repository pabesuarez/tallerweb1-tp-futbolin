package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Solicitud;

@Repository("solicitudDao")
public class SolicitudDaoImpl implements SolicitudDao{
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Solicitud> buscarSolicitudPorPartido(long partido) {
		final Session session = sessionFactory.getCurrentSession();
		return  session
				.createCriteria(Solicitud.class)
				.add(Restrictions.eq("partido.id", partido))
				.list();
	}

	@Override
	public void nuevaSolicitud(Solicitud solicitud) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(solicitud);
	}
	
}
