package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

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

    //Listar todas as missões

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Deletar missão
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    //Alterar missão

    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizada) {
        if (missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id); // Define o ID da missão atualizada para o ID fornecido
            return missoesRepository.save(missaoAtualizada); // Salva a missão atualizada no repositório e retorna o objeto salvo
        }
        return null; // Retorna null se a missão com o ID fornecido não existir
    }





}
