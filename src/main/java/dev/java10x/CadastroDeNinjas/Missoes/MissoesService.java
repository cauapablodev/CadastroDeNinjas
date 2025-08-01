package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository; // Repositório para acessar os dados das missões

    public MissoesService(MissoesRepository missoesRepository) { // Construtor que recebe o repositório de missões, inicializa o serviço de missões
        this.missoesRepository = missoesRepository;
    }

    //Criar nova missão
    public MissoesModel criarMissao(MissoesModel missao) { // Método para criar uma nova missão, recebe um objeto do tipo MissoesModel
        return missoesRepository.save(missao); // Salva a missão no repositório e retorna o objeto salvo
    }

    //Alterar missão

    //Deletar missão

    //Listar todas as missões


}
