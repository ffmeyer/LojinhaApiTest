package dataFactory;

import modulos.pojo.ComponentePojo;
import modulos.pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarProdutoComunComValorIgualA(double valor){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Play 6");
        produto.setProdutoValor(valor);
        List<String> cores = new ArrayList<>();
        cores.add("Preto");
        cores.add("Branco");
        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();
        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("controle");
        componente.setComponenteQuantidade("2");

        ComponentePojo componente2 = new ComponentePojo();
        componente2.setComponenteNome("controle");
        componente2.setComponenteQuantidade("2");

        componentes.add(componente);
        componentes.add(componente2);

        produto.setComponentes(componentes);

        return produto;
    }

}
