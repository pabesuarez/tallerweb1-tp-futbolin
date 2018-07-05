package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class UsuariosTest extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void cargarUsuarios() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("juan");
		usuario1.setApellido("sanchez");
		usuario1.setEmail("juansanchez@gmail.com");
		usuario1.setPassword("aA12345");
		usuario1.setRol(null);
		
		Usuario usuario2 = new Usuario();
		usuario1.setNombre("mario");
		usuario1.setApellido("bros");
		usuario1.setEmail("mariobros@gmail.com");
		usuario1.setPassword("aA12345");
		usuario1.setRol(null);
		
		getSession().save(usuario1);
		getSession().save(usuario2);
		
		
		List<Usuario> usuarios = getSession()
				.createCriteria(Usuario.class)
				.list();
		
		assertThat(usuarios.size()).isEqualTo(2);
	}
	
	@Test
	@Transactional @Rollback(true)
	public void buscarPartidos() {
		
		Usuario usuario1 = new Usuario();
		Partido partido1 = new Partido();
	//	Direccion direccion1= new Direccion("buenos aires", "San justo", "arieta", 111);
		

		partido1.setOrganizador(usuario1);
		
		Partido partido2 = new Partido();
		Usuario usuario2 = new Usuario();
	//	Direccion direccion2= new Direccion("capital federal", "capital federal", "triunvirato", 5400);
		partido1.setOrganizador(usuario2);
		
		getSession().save(usuario1);
		getSession().save(usuario2);
		
		
		getSession().save(partido1);
		getSession().save(partido2);
		
		List<Partido> resultadoPartidos = getSession()
				.createCriteria(Partido.class)
				.createAlias("direccion", "dir")
				.add(Restrictions.eq("dir.calle", "triunvirato"))
				.list();
		
		assertThat(resultadoPartidos.size()).isEqualTo(1);
		getSession().close();
				
	}
}
