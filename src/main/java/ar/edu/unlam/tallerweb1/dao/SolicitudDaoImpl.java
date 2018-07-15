package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cupo;
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

	@Override
	public boolean buscarSolicitudDeUsuario(Long cupo, Long uid) {
		
		Solicitud s = (Solicitud)sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
				.add(Restrictions.eq("cupo.id",cupo))
				.add(Restrictions.eq("usuario.id",uid))
			    .uniqueResult();
		return (s != null);
	}

	@Override
	public void quitarSolicitud(Long idUsuario, Long idCupo) {
		Solicitud s = (Solicitud)sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
				.add(Restrictions.eq("cupo.id",idCupo))
				.add(Restrictions.eq("usuario.id",idUsuario))
			    .uniqueResult();
		sessionFactory.getCurrentSession().delete(s);
	}

	@Override
	public List<Solicitud> buscarSolicitudPartido(Long idPartido) {
		return sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
				.createAlias("cupo.partido", "p")
				.createAlias("cupo", "c")
				.add(Restrictions.eq("p.id",idPartido))
				.add(Restrictions.isNull("c.usuario"))
			    .list();
	}

	@Override
	public void aceptarSolicitud(Long solicitud) {
		Solicitud s = (Solicitud)sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
				.add(Restrictions.eq("id",solicitud))
			    .uniqueResult();
		Cupo c = (Cupo)sessionFactory.getCurrentSession().createCriteria(Cupo.class)
				.add(Restrictions.eq("id",s.getCupo().getId()))
			    .uniqueResult();
		c.setUsuario(s.getUsuario());
		sessionFactory.getCurrentSession().update(c);
	}
	
}
