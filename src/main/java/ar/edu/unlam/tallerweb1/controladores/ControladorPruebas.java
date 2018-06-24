package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPruebas;

@Controller
public class ControladorPruebas {
	
	@Inject
	private ServicioPruebas servicioPruebas;
	
	@RequestMapping("/loginprueba")
	public ModelAndView p_login() {
		ModelMap modelo = new ModelMap();
		List<Usuario> lista = servicioPruebas.listarUsuarios();
		modelo.put("lista",lista);
		return new ModelAndView ("Pruebas/login",modelo);
	}
	
	
	@RequestMapping("/loginid/{id}")
	public String p_loginporid(@PathVariable("id") Long uid, HttpServletRequest request) {
		Usuario u = servicioPruebas.Buscar(uid);
		request.getSession().setAttribute("uid", u.getId());
		request.getSession().setAttribute("email", u.getEmail());
		return "redirect:/loginprueba";
	}
}
