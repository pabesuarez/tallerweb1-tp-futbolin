package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPartido {

	@RequestMapping("/crearPartido")
	public ModelAndView CrearPartido() {
		ModelMap model = new ModelMap();
		return new ModelAndView("crearPartido", model);
	}
	
	@RequestMapping("/buscarPartidos")
	public ModelAndView buscarPartido() {
		ModelMap model = new ModelMap();
		return new ModelAndView("buscarPartidos", model);
	}
}
