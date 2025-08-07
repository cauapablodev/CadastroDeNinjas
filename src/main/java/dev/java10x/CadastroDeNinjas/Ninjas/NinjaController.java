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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }
    // Mostrar todos os ninjas(read)

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id (read)
    @GetMapping("/listarID/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    // Exemplo: /listarID/1
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {// @PathVariable indica que o parâmetro id é uma variável de rota
        return ninjaService.listarNinjaPorId(id);
    }

    //Alterar dados do ninja (update)

    @PutMapping("/alterar/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }
    // Deletar ninja (delete)
    @DeleteMapping("/deletar/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }

}

