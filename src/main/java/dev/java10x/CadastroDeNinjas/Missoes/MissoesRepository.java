package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository: ajuda a trabalhar com o banco de dados
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}