package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " com ID: " + novoNinja.getId());

    }
    // Mostrar todos os ninjas(read)

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    // Mostrar ninja por id (read)
    @GetMapping("/listarID/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    // Exemplo: /listarID/1
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {// @PathVariable indica que o parâmetro id é uma variável de rota
        NinjaDTO ninjaPorId = ninjaService.listarNinjaPorId(id);
        if (ninjaPorId != null) {
            return ResponseEntity.ok(ninjaPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }

    //Alterar dados do ninja (update)

    @PutMapping("/alterar/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja) ;
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }
    }
    // Deletar ninja (delete)
    @DeleteMapping("/deletar/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        }


    }

}

