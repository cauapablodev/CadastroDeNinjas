package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @DeleteMapping("/deletarPorId/{id}") // {id} é um parâmetro de rota, que o usuário pode passar na URL
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }

    //mostrar todas as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }
}
