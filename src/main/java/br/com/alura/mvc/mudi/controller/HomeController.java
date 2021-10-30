package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {

	private PedidoRepository repository;

	public HomeController(PedidoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ModelAndView home() {
		List<Pedido> pedidos = repository.findAll();
		ModelAndView mv  = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}

	@GetMapping("/{status}")
	public ModelAndView aguardando(@PathVariable("status") String status) {
		List<Pedido> pedidos = repository.findAllByStatusPedido(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
		ModelAndView mv  = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		mv.addObject("status", status);
		return mv;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return  "redirect:/home";
	}
}
