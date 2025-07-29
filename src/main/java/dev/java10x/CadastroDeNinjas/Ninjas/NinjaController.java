package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController// mapeia o arquivo e avisa que é um controller
@RequestMapping
public class NinjaController {
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

    @GetMapping("/all")
    public String mostrarTodosNinjas() {
        return "Lista de todos os ninjas";
    }
    // Mostrar ninja por id (read)

    @GetMapping("/todosID")
    public String mostrarNinjaPorId() {
        return "Mostrar ninja por ID";
    }

    //Alterar dados do ninja (update)

    @PutMapping("/alterarID")
    public String alterarNinja() {
        return "Ninja alterado com sucesso!";
    }
    // Deletar ninja (delete)
    @DeleteMapping("/deletarID")
    public String deletarNinja() {
        return "Ninja deletado com sucesso!";
    }

}

