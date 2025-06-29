package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// JPA = Java Persistence API
@Entity //mostra q a classe é uma entidade do Banco de Dados
@Table(name = "tb_cadastro") // trasforma em tabela

public class NinjaModel {

    @Id //id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia para id
    private long id;
    private String nome;
    private String email;
    private int idade;
    private List<MissoesModel> missoes;


    // no args constructor
    public NinjaModel() {

    }
    //all args contructor
    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
