package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("formulario")
    public ModelAndView formulario(PedidoDTO pedidoDTO){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @PostMapping("novo")
    public String novo(@Valid PedidoDTO pedidoDTO, BindingResult result) {
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        Pedido pedido = pedidoDTO.toPedido(pedidoDTO);
        Pedido save = repository.save(pedido);
        return "pedido/formulario";
    }

}
