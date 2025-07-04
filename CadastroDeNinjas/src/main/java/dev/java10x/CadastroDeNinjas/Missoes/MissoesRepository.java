package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
                                        //ajuda a navegar pelo banco de dados(uma abstração) um simplificador
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
