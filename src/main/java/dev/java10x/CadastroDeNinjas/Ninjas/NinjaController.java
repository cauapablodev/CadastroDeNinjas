package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// mapeia o arquivo e avisa que é um controller
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira msg na rota";
    }
}
