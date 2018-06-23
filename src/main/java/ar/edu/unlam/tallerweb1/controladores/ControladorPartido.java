package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;


@Controller
public class ControladorPartido {
	
	@Inject
	private ServicioPartido servicioPartido;

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
	
	@RequestMapping(path = "/buscarCosas")
		public ModelAndView resultadosBusqueda() {
			ModelMap model = new ModelMap();
			return new ModelAndView("home",model);
			
		}
	}

