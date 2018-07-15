package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {
	

	@Inject
	private ServicioPartido servicioPartido;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private HttpServletRequest request;
	

	
	
	@RequestMapping("/Registro")
	public ModelAndView registro() {
		ModelMap model = new ModelMap();
		Usuario usuario = new Usuario();
		model.put("usuario",usuario);
		return new ModelAndView("registro",model);
	}
	
	@RequestMapping(path = "/nuevo",method=RequestMethod.POST)
	public ModelAndView crear(@ModelAttribute("usuario") Usuario usuario){
		boolean registro = servicioUsuario.nuevoUsuario(usuario);
		if(registro) {
			return new ModelAndView("redirect:/index");
		}else {
			return null;
		}
	}
	
	@RequestMapping("/usercp")
	public ModelAndView panelControl() {
		ModelMap model = new ModelMap();
		return new ModelAndView("usercp",model);
	}
	
}
