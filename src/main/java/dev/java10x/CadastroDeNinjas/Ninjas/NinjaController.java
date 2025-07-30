package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// mapeia o arquivo e avisa que é um controller
@RequestMapping("/ninjas") // mapeia a rota /ninjas
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira msg na rota";
    }

    // Adicionar ninja (create)

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso!";
    }
    // Mostrar todos os ninjas(read)

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }
    // Mostrar ninja por id (read)

    @GetMapping("/listarID")
    public String mostrarNinjaPorId() {
        return "Mostrar ninja por ID";
    }

    //Alterar dados do ninja (update)

    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja alterado com sucesso!";
    }
    // Deletar ninja (delete)
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Ninja deletado com sucesso!";
    }

}

