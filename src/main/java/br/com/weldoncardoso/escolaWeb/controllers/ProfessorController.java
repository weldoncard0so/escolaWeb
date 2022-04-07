package br.com.weldoncardoso.escolaWeb.controllers;

import br.com.weldoncardoso.escolaWeb.dto.RequisicaoNovoProfessor;
import br.com.weldoncardoso.escolaWeb.models.Professor;
import br.com.weldoncardoso.escolaWeb.models.StatusProfessor;
import br.com.weldoncardoso.escolaWeb.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("")
    public ModelAndView index(){
        List<Professor> professores = this.professorRepository.findAll();

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("professores/novo");
        mv.addObject("statusProfessor", StatusProfessor.values());

        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult){

        System.out.println(requisicao);
        if(bindingResult.hasErrors()){
            System.out.println("\n******************** TEM ERROS ********************\n");

            ModelAndView mv = new ModelAndView("professores/novo");
            mv.addObject("statusProfessor", StatusProfessor.values());
            return mv;

        } else {
            Professor professor = requisicao.toProfessor();
            this.professorRepository.save(professor);
            return new ModelAndView("redirect:/professores");
        }
    }
}