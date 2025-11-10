package com.example.pf_profsoftware.Curso;

import com.example.pf_profsoftware.Curso.CursoRequest;
import com.example.pf_profsoftware.Curso.CursoResponse;
import com.example.pf_profsoftware.Curso.Curso;
import com.example.pf_profsoftware.Curso.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CursoResponse> criar(@Valid @RequestBody CursoRequest req) {
        Curso curso = new Curso(req.getNome(), req.getDescricao(), req.getNota(), req.getNomeProfessor());
        Curso salvo = service.salvar(curso);
        CursoResponse resp = new CursoResponse(salvo.getId(), salvo.getNome(), salvo.getDescricao(), salvo.getNota(), salvo.getNomeProfessor());
        return ResponseEntity.created(URI.create("/cursos/" + salvo.getId())).body(resp);
    }

    @GetMapping
    public List<CursoResponse> listar() {
        return service.listarTodos().stream()
                .map(c -> new CursoResponse(c.getId(), c.getNome(), c.getDescricao(), c.getNota(), c.getNomeProfessor()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(c -> ResponseEntity.ok(new CursoResponse(c.getId(), c.getNome(), c.getDescricao(), c.getNota(), c.getNomeProfessor())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CursoRequest req) {
        return service.buscarPorId(id).map(existente -> {
            existente.setNome(req.getNome());
            existente.setDescricao(req.getDescricao());
            existente.setNota(req.getNota());
            existente.setNomeProfessor(req.getNomeProfessor());
            Curso atualizado = service.salvar(existente);
            CursoResponse resp = new CursoResponse(atualizado.getId(), atualizado.getNome(), atualizado.getDescricao(), atualizado.getNota(), atualizado.getNomeProfessor());
            return ResponseEntity.ok(resp);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(c -> {
            service.deletar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
