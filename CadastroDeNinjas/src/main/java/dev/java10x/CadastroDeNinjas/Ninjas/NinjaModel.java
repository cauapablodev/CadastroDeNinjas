package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// JPA = Java Persistence API
@Entity //mostra q a classe é uma entidade do Banco de Dados
@Table(name = "tb_cadastro") // trasforma em tabela
@Data //cria todos os Getters and Settes
@NoArgsConstructor //construtor vazio automatico
@AllArgsConstructor //adiciona todos os construtores necessarios

public class NinjaModel {

    @Id //id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia para id gera o id automatico
    @Column(name = "id")
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)// deixa o email unico
    private String email;
    @Column(name = "idade")
    private int idade;

    @ManyToOne //@ManyToOne um ninja tem apenas uma unica missão
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}
