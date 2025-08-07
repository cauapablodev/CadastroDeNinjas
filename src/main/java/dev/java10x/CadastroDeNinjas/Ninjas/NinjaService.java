package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = new NinjaMapper(); // Inicializa o ninjaMapper
    }


    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {
       List<NinjaModel> ninjas = ninjaRepository.findAll(); // Busca todos os ninjas do repositório
        return ninjas.stream()
                .map(ninjaMapper::map) // Mapeia cada NinjaModel para NinjaDTO usando o ninjaMapper
                .collect(Collectors.toList()); // Mapeia cada NinjaModel para NinjaDTO e coleta em uma lista
    }

    //Listar ninja por id
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); // Busca o ninja pelo ID no repositório
        return ninjaPorId.map(ninjaMapper::map).orElse(null);

    }

    //Criar novo ninja //metodo
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);// Mapeia o NinjaDTO para NinjaModel
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja); // Mapeia o NinjaModel salvo de volta para NinjaDTO
    }

    //Deletar ninja - tem que ser um metodo void, pois não retorna nada
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo); // Mapeia o NinjaModel salvo de volta para NinjaDTO
        }
        return null;
    }
}
