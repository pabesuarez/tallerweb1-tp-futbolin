package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoCupo;


@Repository("cupoDao")
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

	@Override
	public List<Cupo> listarCuposPorPartido(Long idPartido) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Cupo.class)
				.createAlias("partido", "p")
				.add(Restrictions.eq("p.id", idPartido))
				.list();
	}

	@Override
	public Usuario buscarJugadorPorId(Long idUsuario) {
		
		
		Cupo c = (Cupo) sessionFactory.getCurrentSession()
				.createCriteria(Cupo.class)
				.createAlias("usuario", "u")
				.add(Restrictions.eq("u.id", idUsuario))
				.list();
		return c.getUsuario();
	}

	@Override
	public Cupo buscarPorId(Long Id) {
		return (Cupo) sessionFactory.getCurrentSession()
				.createCriteria(Cupo.class)
				.add(Restrictions.eq("id", Id))
				.uniqueResult();
	}

	@Override
	public void nuevoCupo(FormNuevoCupo cupo) {
		Cupo nuevo = new Cupo();
		nuevo.setPosicion(cupo.getPosicion());
		Partido p = (Partido) sessionFactory.getCurrentSession()
				.createCriteria(Partido.class)
				.add(Restrictions.eq("id", cupo.getPartido()))
				.uniqueResult();
		nuevo.setPartido(p);
		nuevo.setEstado(false);
		sessionFactory.getCurrentSession()
		.save(nuevo);
	}
	

	@Override
	public void cancelarCupo(Long idCupo) {
		Cupo c = (Cupo) sessionFactory.getCurrentSession()
				.createCriteria(Cupo.class)
				.add(Restrictions.eq("id", idCupo))
				.uniqueResult();
		c.setUsuario(null);
		sessionFactory.getCurrentSession().update(c);
		
	}

	

}
