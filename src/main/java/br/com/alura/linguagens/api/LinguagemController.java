package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Para reconhecer que é uma controller
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

//    @GetMapping(value="/linguagens")
    @GetMapping("/linguagens") // Retorna Todos
    public List<Linguagem> obterLinguagens() {
        return  repositorio.findAll();
    }

    // Coloca @RequestBody, porque eu mando pelo body, se
    // fosse por parâmetro na url seria @RequestParam
    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        if(linguagem.getTitle() != null && linguagem.getImage() != null) {
            Linguagem linguagemSalva = repositorio.save(linguagem);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/linguagens/{id}")
    public Linguagem modificarLinguagem(@PathVariable String id, @RequestBody Linguagem novaLinguagem) {
        var linguagem = repositorio.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado - " + id));

        linguagem.setRanking(novaLinguagem.getRanking());
        linguagem.setTitle(novaLinguagem.getTitle());
        linguagem.setImage(novaLinguagem.getImage());

        return repositorio.save(linguagem);
    }

    @DeleteMapping("/linguagens/{id}")
    public void deletarLinguagen(@PathVariable String id) {
        repositorio.deleteById(id);
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
