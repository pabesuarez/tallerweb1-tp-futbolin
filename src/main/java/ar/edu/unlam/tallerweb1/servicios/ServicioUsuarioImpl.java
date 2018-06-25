package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{
	
	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		return servicioUsuarioDao.buscarUsuarioPorId(idUsuario);
	}

}
