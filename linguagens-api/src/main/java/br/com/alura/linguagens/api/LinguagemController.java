package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Para reconhecer que é uma controller
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

//    @GetMapping(value="/linguagens")
    @GetMapping("/linguagens") // Retorna Todos
    public List<Linguagem> obterLinguagens() {
        return  repository.findAll();
    }

    // Coloca @RequestBody, porque eu mando pelo body, se
    // fosse por parâmetro na url seria @RequestParam
    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repository.save(linguagem);
        return linguagemSalva;
    }

    /*
        - Terminar o CRUD;
        - Quando inserir retornou como 200 esse não seria o ideal, então o melhor seira
        retorna status 201 que é o status que diz que foi criado/inserido;
        - Fazer um método path para esse ranking vir de votações a cada vez que alguem
        acessar esse método ele ir incrementando, não se um ranking fixo de 1, 2, 3, isso
        vir a cada path que fizermos métodos path do http
        - Ordenar o retorno pelo ranquing

     */

}
