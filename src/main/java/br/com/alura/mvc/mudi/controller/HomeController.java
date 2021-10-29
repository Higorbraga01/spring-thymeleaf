package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

	private PedidoRepository repository;

	public HomeController(PedidoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/home")
	public ModelAndView home() {
		List<Pedido> pedidos = repository.findAll();
		ModelAndView mv  = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
}
