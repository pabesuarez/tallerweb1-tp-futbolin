package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cupo;
import ar.edu.unlam.tallerweb1.modelo.Puntos;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCupo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;


@Controller
public class ControladorPartido {
	
	@Inject
	private ServicioPartido servicioPartido;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioCupo servicioCupo;

	@RequestMapping("/crearPartido")
	public ModelAndView CrearPartido() {
		ModelMap model = new ModelMap();
		return new ModelAndView("crearPartido", model);
	}
	
	@RequestMapping("/buscarPartidos")
	public ModelAndView buscarPartidos() {
		ModelMap model = new ModelMap();
		model.put("resultado", servicioPartido.buscar());
		return new ModelAndView("buscarPartidos", model);
	}
	
	@RequestMapping(path = "/detallePartido/{idPartido}")
		public ModelAndView detallePartido(@PathVariable long idPartido) {
			ModelMap model = new ModelMap();
			model.put("partido", servicioPartido.buscarId(idPartido));
			return new ModelAndView("detallePartido",model);
			
		}
	
	

		@RequestMapping(path = "/finalizarPartido/{idPartido}")
	public ModelAndView finalizarPartido(@PathVariable long idPartido) {
			
		ModelMap model = new ModelMap();
		
		
		
		List<Cupo> listaDeCuposPorPartido = servicioCupo.listarCuposPorPartido(idPartido);
		
		
		
		model.put("cupoClave",listaDeCuposPorPartido);
			return  new ModelAndView("calificarJugadores",model);

	}
		
	
		//le paso asigno el idcupo a un objeto puntaje,ese puntaje me va a guardar los campos de puntos para ese idcupo 
		
	@RequestMapping(path = "/calificarJugador/{idCupo}/{nombre}/{apellido}")
	public ModelAndView calificarJugador(@PathVariable long idCupo,@PathVariable String nombre,@PathVariable String apellido) {
			
		ModelMap model = new ModelMap();
		
		//Usuario usuario=servicioUsuario.buscarUsuarioPorId(idUsuario);
		
		Puntos puntos = new Puntos();


		model.put("claveIdCupo", idCupo);

		model.put("claveNombre", nombre);

		model.put("claveApellido", apellido);
		
		
		model.put("objetoPuntos", puntos);
		
		
		/*model.put("jugador",usuario);*/
			return  new ModelAndView("Puntuacion",model);


		}

	@RequestMapping(path = "/PuntajeGuardado", method = RequestMethod.POST)
	public ModelAndView CalificacionGuardada(@ModelAttribute("objetoPuntos") Puntos puntaje, HttpServletRequest request) {
		ModelMap model = new ModelMap();
	
		
		model.put("puntajeJugador", puntaje);

		return new ModelAndView("PuntajeGuardado", model);
	}
	
	}
