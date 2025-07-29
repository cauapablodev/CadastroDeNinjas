package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

//mostra q isso é uma rota de controller
@RestController
// para falar que vai mapear a rota
@RequestMapping("/missoes")
public class MissoesController {
    //Manda
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    }

    //Alterar missao
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso!";
    }

    //deletar missao
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    }

    //mostrar todas as missoes
    @GetMapping("/listaDeNinjas")
    public String mostrarTodasMissoes() {
        return "Lista de todas as missões";
    }
}
