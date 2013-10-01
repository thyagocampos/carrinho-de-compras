package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        
        //--caso de teste inserido na aula de 17/09/2013
        Produto head_first = new Produto("Java: como programar", 50.00);
        carrinho.add(head_first);
        
        Produto menor;
        menor = carrinho.menorProduto();
                
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }
    
    //Caso de teste criado em 17/09/2013
    @Test
    public void exibeDescricaoDeProdutos() {
        Produto teste = new Produto("Use a cabeça", 70.00);
        assertArrayEquals(new Object[]{teste.getDescricao()}, new Object[]{"Use a cabeça"});
                    
     }
    //adicionar novos tipos de produto no carrinho
    @Test
    public void addNovosTiposProdutosCarrinho(){
        String tipoProduto = "Produtos Eróticos";
        assertArrayEquals(new Object[]{tipoProduto},new Object[]{"Produtos Eróticos"} );
    }
    
    //Listar todos os produtos do carrinho
    @Test
    public void listarTodosProdutosDoCarrinho(){
        
        List<String> listaProdutos = new ArrayList<>();
        
        listaProdutos.add("Shampoo");
        listaProdutos.add("Sabonete");
        listaProdutos.add("Camisinha");
        
        assertArrayEquals(new Object[]{listaProdutos.get(0)}, new Object[]{"Shampoo"});
        assertArrayEquals(new Object[]{listaProdutos.get(1)}, new Object[]{"Sabonete"});
        assertArrayEquals(new Object[]{listaProdutos.get(2)}, new Object[]{"Camisinha"});
        
    }
    
    //remover 1 produto do carrinho
    @Test
    public void removerUmProdutoCarrinho(){
        
        List<String> listaProdutos = new ArrayList<>();
        
        //add 3 itens
        listaProdutos.add("Shampoo");
        listaProdutos.add("Camisinha");
        listaProdutos.add("Sabonete");
        
        //remove 1 item
        listaProdutos.remove("Sabonete");
        
        //espera obeter uma lista com 2 itens
        assertArrayEquals(new Object[]{listaProdutos.size()}, new Object[]{2});
        
    }
    
    //Calcular o total que deve ser pago pelos produtos no carrinho
    @Test
    public void totalASerPagoNoCarrinho(){
        
        List<Double> listaProdutosPreco = new ArrayList<>();
        
        double total = 0.0;
        
        listaProdutosPreco.add(20.00);
        listaProdutosPreco.add(5.00);
        listaProdutosPreco.add(4.00);
        
        //calcula o total de valores dentro da lista
        for(Double x : listaProdutosPreco){
            total = total + x.doubleValue();
        }
        
        assertArrayEquals(new Object[]{total}, new Object[]{29.00});
        
    }
    
}