package demo;

import java.time.LocalDate;
import java.util.List;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

public class AdministrativoApp {

    public static void main(String[] args) {

        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        produtoModel.create(p1);

        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtd Produtos: " + produtos.size());

        Long idProduto = produtos.get(0).getId();
        Produto produtoEncontrado = produtoModel.findById(idProduto);
        System.out.println("\nProduto encontrado por ID:");
        System.out.println(produtoEncontrado.getNome() + " - R$ " + produtoEncontrado.getPreco());
        
        
        produtoEncontrado.setPreco(5200.00);
        produtoEncontrado.setQuantidade(15);
        produtoModel.update(produtoEncontrado);
        
        Produto produtoAtualizado = produtoModel.findById(idProduto);
        System.out.println("\nProduto atualizado:");
        System.out.println(produtoAtualizado.getNome() + " - R$ " + produtoAtualizado.getPreco());
        
        produtoModel.delete(produtoAtualizado);

        System.out.println("\nProduto removido com sucesso!");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João Silva");
        pessoa.setEmail("joao@email.com");
        pessoa.setCpf("12345678900");
        pessoa.setIdade(40);
        pessoa.setDataNascimento(LocalDate.of(1981, 11, 10));

        pessoaModel.create(pessoa);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtd Pessoas: " + pessoas.size());
        
        Long idPessoa = pessoas.get(0).getId();
        Pessoa pessoaEncontrada = pessoaModel.findById(idPessoa);

        System.out.println("\nPessoa encontrada por ID:");
        System.out.println(pessoaEncontrada.getNome() + " - " + pessoaEncontrada.getEmail());
        
        pessoaEncontrada.setNome("Maria Atualizada");
        pessoaEncontrada.setIdade(30);
        pessoaModel.update(pessoaEncontrada);
        
        Pessoa pessoaAtualizada = pessoaModel.findById(idPessoa);
        System.out.println("\nPessoa atualizada:");
        System.out.println(pessoaAtualizada.getNome() + " - Idade: " + pessoaAtualizada.getIdade());
        
        pessoaModel.delete(pessoaAtualizada);

        System.out.println("\nPessoa removida com sucesso!");
    }
}