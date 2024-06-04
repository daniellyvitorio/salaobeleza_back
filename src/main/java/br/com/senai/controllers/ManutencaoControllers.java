package br.com.senai.controllers;


import br.com.senai.models.Manutencao;
import br.com.senai.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ManutencaoControllers {

    @RestController
    @RequestMapping("/manutencao")
    public class ManutencaoController {
        @Autowired
        ManutencaoRepository manutencaoRepository;

        @GetMapping(value = "/all",
                produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Manutencao> getAllManutencao(){
            return manutencaoRepository.findAll();
        }

        //metodo para salvar no banco de dados
        @PostMapping(value="/createManutencao",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Manutencao createManutencao(@RequestBody Manutencao manutencao){
            //Cria um novo objeto Product
            Manutencao newManutencao = new Manutencao();
            //Seta as propriedades do Product
            //Chama o método save para salvar o objeto no banco de dados
            return manutencaoRepository.save(newManutencao);
        }

        //atualizar cafe
        @PutMapping(value="/updateManutencao",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Manutencao updateManutencao(@RequestBody Manutencao manutencao){
            Manutencao getManutencao = (Manutencao) manutencaoRepository.findById(manutencao.getId()).orElseThrow();
            Manutencao updateManutencao = new Manutencao();

            updateManutencao.setId(manutencao.getId());

            return  manutencaoRepository.save(updateManutencao);
        }
        // Metodo deletar product
        @DeleteMapping(value="/deleteManutencao/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
        //@PathVariable pega um valor passado junto a barra de endereço
        public Manutencao deleteManutencao(@PathVariable Long id){
            //Verifica se existe o café no bando de dados procurando id
            Manutencao getManutencao = manutencaoRepository.findById(id).orElseThrow();
            //chamamos p método .delete e passamos o café a ser deletado
            manutencaoRepository.delete(getManutencao);
            return  getManutencao;
        }
    }

}
