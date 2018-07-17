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
	
}
