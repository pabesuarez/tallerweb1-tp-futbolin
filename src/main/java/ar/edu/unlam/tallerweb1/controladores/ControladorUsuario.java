package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

@Controller
public class ControladorUsuario {
	

	@Inject
	private ServicioPartido servicioPartido;
	
	
	@RequestMapping("/mispartidos")
	public ModelAndView mispartidos(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		
		if (request.getSession().getAttribute("uid") != null) {	
			long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
			List<Partido> lista = servicioPartido.buscarPorUsuario(uid);
			modelo.put("lista",lista);
			return new ModelAndView ("mispartidos",modelo);
		} else {
			return new ModelAndView ("redirect:/loginprueba");
		}
	}
}
