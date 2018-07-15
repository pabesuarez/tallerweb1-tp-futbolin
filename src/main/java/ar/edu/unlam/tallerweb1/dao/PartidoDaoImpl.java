package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoPartido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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
	public boolean nuevoPartido(FormNuevoPartido partido,long uid) {
		Usuario organizador = (Usuario)sessionFactory.getCurrentSession().createCriteria(Usuario.class)
							  .add(Restrictions.eq("id",uid))
							  .uniqueResult();
		if (organizador != null) {
			Partido nuevo = new Partido();
			nuevo.setFecha(new Timestamp(System.currentTimeMillis()));
			nuevo.setNombreCancha(partido.getNombreCancha());
			nuevo.setDescripcion(partido.getDescripcion());
			nuevo.setLatitud(partido.getLatitud());
			nuevo.setDireccion(partido.getDireccion());
			nuevo.setLongitud(partido.getLongitud());
			nuevo.setOrganizador(organizador);
			sessionFactory.getCurrentSession()
			.save(nuevo);
		return true;
		}else {
			return false;
		}
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
