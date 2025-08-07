package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository; // Repositório para acessar os dados das missões
    private MissoesMapper missoesMapper; // Mapeador para converter entre MissoesModel e MissoesDTO

    public MissoesService(MissoesRepository missoesRepository) { // Construtor que recebe o repositório de missões, inicializa o serviço de missões
        this.missoesRepository = missoesRepository;
        this.missoesMapper = new MissoesMapper(); // Inicializa o mapeador de missões
    }

    //Criar nova missão
    public MissoesDTO criarMissao(MissoesDTO missaoDTO) { // Método para criar uma nova missão, recebe um objeto do tipo MissoesModel
        MissoesModel missoes = missoesMapper.map(missaoDTO); // Mapeia o MissoesDTO para MissoesModel
        missoesRepository.save(missoes);
        return missoesMapper.map(missoes); // Mapeia o MissoesModel salvo de volta para MissoesDTO
    }

    //Listar todas as missões

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map) // Mapeia cada MissoesModel para MissoesDTO usando o mapeador
                .collect(Collectors.toList()); // Coleta os resultados em uma lista
    }

    //Deletar missão
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    //Alterar missão

    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if (missoesExistente.isPresent()) {
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtualizado);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
}
