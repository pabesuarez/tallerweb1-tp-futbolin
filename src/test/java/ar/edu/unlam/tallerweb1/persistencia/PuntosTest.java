package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Puntos;

public class PuntosTest extends SpringTest{

	@Transactional @Rollback(true)
	@Test
	public void testPuntos() {
	
		
		Puntos p1=new Puntos();
		
p1.setGolesComoArquero(0);
p1.setGolesComoDefensor(6);
p1.setGolesComoDelantero(0);
p1.setGolesComoVolante(0);
p1.setGolesDePenal(2);
p1.setGolesEnContra(-2);
p1.setGolesRecibidos(0);
p1.setPenalesAtajados(0);
p1.setPenalesErrados(-2);
p1.setTarjetaRoja(0);
p1.setTarjetasAmarillas(-2);

		
		
getSession().save(p1);

Integer puntajeTotal = p1.puntajeTotal();

assertThat(puntajeTotal).isEqualTo(2);
		
		
	
	}

}
