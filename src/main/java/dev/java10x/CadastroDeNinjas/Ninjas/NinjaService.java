package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninja por id
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

    //Criar novo ninja //metodo
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //Deletar ninja - tem que ser um metodo void, pois não retorna nada
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id); // Define o ID do ninja atualizado para o ID fornecido
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null; // Retorna null se o ninja com o ID fornecido não existir

    }
}
