package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component // Indica que essa classe é um componente do Spring, para ser injetada em outros lugares
public class NinjaMapper {
    // Mapper = mapeia o objeto NinjaModel para NinjaDTO e vice-versa
    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel(); // cria um novo objeto NinjaModel
        ninjaModel.setId(ninjaDTO.getId()); // define o ID do ninjaModel com o ID do ninjaDTO,// copia os outros atributos do ninjaDTO para o ninjaModel
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO(); // cria um novo objeto NinjaDTO
        ninjaDTO.setId(ninjaModel.getId()); // define o ID do ninjaDTO com o ID do ninjaModel
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        return ninjaDTO;
    }
}
