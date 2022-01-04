package br.com.beckhauser.forum.controllers;

import br.com.beckhauser.forum.DTO.TopicoDTO;
import br.com.beckhauser.forum.controllers.forms.TopicoForm;
import br.com.beckhauser.forum.models.Topico;
import br.com.beckhauser.forum.repository.CursoRepository;
import br.com.beckhauser.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso) {
        if(nomeCurso == null){
            System.out.println(nomeCurso);
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }
    }

    @PostMapping
    public void cadastrar(@RequestBody TopicoForm form){
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

    }
}
