package br.com.senai.controllers;

import br.com.senai.models.Agendamento;
import br.com.senai.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@CrossOrigin(origins = "http://localhost:5173")
public class AgendamentoController {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agendamento> getAllAgendamento(){
        return agendamentoRepository.findAll();
    }
//       /agendamento/createAgendamento
    //metodo para salvar no banco de dados
    @PostMapping(value="/createAgendamento",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agendamento createAgendamento(@RequestBody Agendamento agendamento){
        //Cria um novo objeto Product
        System.out.println(agendamento);
        Agendamento newAgendamento = new Agendamento();
        //Seta as propriedades do Product
        newAgendamento.setServico(agendamento.getServico());
        newAgendamento.setDescricao(agendamento.getDescricao());
        newAgendamento.setData_agendamento(agendamento.getData_agendamento());
//        newAgendamento.setHora(agendamento.getHora());
        //Chama o método save para salvar o objeto no banco de dados
        return agendamentoRepository.save(newAgendamento);
    }

    //atualizar cafe
    @PutMapping(value="/updateAgendamento/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agendamento updateAgendamento(@RequestBody Agendamento agendamento, @PathVariable long id){
        Agendamento getAgendamento = agendamentoRepository.findById(id).orElseThrow();
        Agendamento updateAgendamento = new Agendamento();

        updateAgendamento.setId(id);
        updateAgendamento.setServico(agendamento.getServico());
        updateAgendamento.setDescricao(getAgendamento.getDescricao());
        updateAgendamento.setData_agendamento(getAgendamento.getData_agendamento());
//

        return  agendamentoRepository.save(updateAgendamento);
    }
    // Metodo deletar product
    @DeleteMapping(value="/deleteAgendamento/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    //@PathVariable pega um valor passado junto a barra de endereço
    public Agendamento deleteAgendamento(@PathVariable Long id){
        //Verifica se existe o café no bando de dados procurando id
        Agendamento getAgendamento = agendamentoRepository.findById(id).orElseThrow();
        //chamamos p método .delete e passamos o café a ser deletado
        agendamentoRepository.delete(getAgendamento);
        return getAgendamento;
    }
}
