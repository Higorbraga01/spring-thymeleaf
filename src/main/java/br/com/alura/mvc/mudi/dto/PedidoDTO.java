package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import javax.validation.constraints.NotBlank;

public class PedidoDTO {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    @NotBlank
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(pedidoDTO.getNomeProduto());
        pedido.setUrlProduto(pedidoDTO.getUrlProduto());
        pedido.setUrlImagem(pedidoDTO.getUrlImagem());
        pedido.setDescricao(pedidoDTO.getDescricao());
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
