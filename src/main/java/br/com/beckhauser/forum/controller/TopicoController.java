package br.com.beckhauser.forum.controller;

import br.com.beckhauser.forum.DTO.TopicoDTO;
import br.com.beckhauser.forum.modelo.Curso;
import br.com.beckhauser.forum.modelo.Topico;
import br.com.beckhauser.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

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
}
