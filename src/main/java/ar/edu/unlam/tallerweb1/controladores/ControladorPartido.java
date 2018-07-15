package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
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
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Puntos;
import ar.edu.unlam.tallerweb1.modelo.Solicitud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoCupo;
import ar.edu.unlam.tallerweb1.modelo.formularios.FormNuevoPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCupo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntos;
import ar.edu.unlam.tallerweb1.servicios.ServicioSolicitud;



@Controller
public class ControladorPartido {
	
	@Inject
	private ServicioPartido servicioPartido;
	
	@Inject
	private ServicioPuntos servicioPuntos;
	
	@Inject
	private ServicioCupo servicioCupo;
	
	@Inject
	private HttpServletRequest request;

	@RequestMapping("/crearPartido")
	public ModelAndView CrearPartido() {
		Partido partido = new Partido();
		ModelMap model = new ModelMap();
		model.put("partido",partido);
		return new ModelAndView("crearPartido", model);
	}
	
	@RequestMapping("/buscarPartidos")
	public ModelAndView buscarPartidos() {
		ModelMap model = new ModelMap();
		model.put("resultado", servicioPartido.buscar());
		return new ModelAndView("buscarPartidos", model);
	}
	
	@RequestMapping("/misPartidos")
	public ModelAndView mispartidos() {
		ModelMap modelo = new ModelMap();
		if (request.getSession().getAttribute("uid") != null) {	
			long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
			List<Partido> lista = servicioPartido.buscarPorUsuario(uid);
			modelo.put("lista",lista);
			return new ModelAndView ("partidos",modelo);
		} else {
			return new ModelAndView ("redirect:/loginprueba");
		}
	}
	
	@RequestMapping(path = "/detallePartido/{idPartido}")
		public ModelAndView detallePartido(@PathVariable long idPartido) {
			Long uid = (Long)request.getSession().getAttribute("uid");
			ModelMap model = new ModelMap();
			Partido partido =  servicioPartido.buscarId(idPartido);
			List<Cupo> listaCupos = servicioCupo.listarCuposPorPartido(idPartido);
			
			model.put("partido", partido);
			
			if (uid == partido.getOrganizador().getId()) {
				List<Solicitud> solicitudes = servicioPartido.buscarSolicitudPartido(idPartido);
				FormNuevoCupo form = new FormNuevoCupo();
				model.put("FormNuevoCupo",form);
				model.put("solicitudes",solicitudes);
			}else{
				List<Long> cupoConSolicitud = new ArrayList<Long>();
				
				for(int i = 0; i<listaCupos.size(); i+=1){
					if (servicioPartido.buscarSolicitudDeUsuario(listaCupos.get(i).getId(), uid)){
						cupoConSolicitud.add(listaCupos.get(i).getId());
					}
				}
				
				
				
				model.put("cuposConSolicitud", cupoConSolicitud);
			}
			
			model.put("cupos", listaCupos);
			
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
		
	@RequestMapping(path = "/calificarJugador/{idCupo}/{nombre}/{apellido}/{posicion}")
	public ModelAndView calificarJugador(@PathVariable long idCupo,@PathVariable String nombre,@PathVariable String apellido,@PathVariable String posicion) {
			
		ModelMap model = new ModelMap();
		
		//Usuario usuario=servicioUsuario.buscarUsuarioPorId(idUsuario);
		
		Puntos puntos = new Puntos();


		model.put("claveIdCupo", idCupo);
		model.put("claveNombre", nombre);
		model.put("claveApellido", apellido);
		model.put("clavePosicion", posicion);
		model.put("objetoPuntos", puntos);
		
		
		/*model.put("jugador",usuario);*/
			return  new ModelAndView("Puntuacion",model);


		}

	@RequestMapping(path = "/PuntajeGuardado", method = RequestMethod.POST)
	public ModelAndView CalificacionGuardada(@ModelAttribute("objetoPuntos") Puntos puntaje) {
		ModelMap model = new ModelMap();
		
	
	//	model.put("objetoPuntos", puntaje);
		
		
		
		//servicio que haga la conversion a puntos y devuelva un solo valor de puntuacion
		
		servicioPuntos.Alta(puntaje);
		
		int Total=servicioPuntos.PuntajeResultado(puntaje);
			model.put("total", Total);
		

		return new ModelAndView("PuntajeGuardado", model);
	}
	
	@RequestMapping(path = "/nuevoPartido",method=RequestMethod.POST)
	public ModelAndView crear(@ModelAttribute("partido") FormNuevoPartido partido){
		boolean registro = servicioPartido.nuevoPartido(partido,((long)request.getSession().getAttribute("uid")));
		if(registro) {
			return new ModelAndView("redirect:/index");
		}else {
			return new ModelAndView("redirect:/crearPartido");
		}
	}
	
	@RequestMapping(path = "/nuevoCupo",method=RequestMethod.POST)
	public String nuevoCupo(@ModelAttribute("FormNuevoCupo") FormNuevoCupo cupo){
		servicioPartido.nuevoCupo(cupo);
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(path = "/solicitar/{idCupo}")
	public String solicitar(@PathVariable long idCupo) {
		Long uid = (Long)request.getSession().getAttribute("uid");
		servicioPartido.solicitar(uid,idCupo);
		return "redirect:"+request.getHeader("Referer");
		}
	
	@RequestMapping(path = "/quitarSolicitud/{idCupo}")
	public String quitarSolicitud(@PathVariable long idCupo) {
		Long uid = (Long)request.getSession().getAttribute("uid");
		servicioPartido.quitarSolicitud(uid,idCupo);
		return "redirect:"+request.getHeader("Referer");
		}
	
	@RequestMapping(path = "/aceptarSolicitud/{idSolicitud}")
	public String aceptarSolicitud(@PathVariable long idSolicitud) {
		servicioPartido.aceptarSolicitud(idSolicitud);
		return "redirect:"+request.getHeader("Referer");
		}
	
	@RequestMapping(path = "/cancelarCupo/{idCupo}")
	public String cancelarCupo(@PathVariable long idCupo) {
		servicioPartido.cancelarCupo(idCupo);
		return "redirect:"+request.getHeader("Referer");
		}
	
	
}
