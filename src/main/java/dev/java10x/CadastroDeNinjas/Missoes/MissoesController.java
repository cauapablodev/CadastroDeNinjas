package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

//mostra q isso é uma rota de controller
@RestController
// para falar que vai mapear a rota
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService; // Serviço para acessar os dados das missões

    public MissoesController(MissoesService missoesService) { // Construtor que recebe o serviço de missões
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        // @RequestBody indica que o corpo da requisição contém os dados da missão
        // O Spring vai converter o JSON enviado na requisição para um objeto MissoesModel
        return missoesService.criarMissao(missao);
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
    @GetMapping("/listaMissoes")
    public String mostrarTodasMissoes() {
        return "Lista de todas as missões";
    }
}
