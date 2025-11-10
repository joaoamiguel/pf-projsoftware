package com.example.pf_profsoftware.Curso;

import com.example.pf_profsoftware.Curso.Curso;
import com.example.pf_profsoftware.Curso.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public Curso salvar(Curso curso) {
        return repo.save(curso);
    }

    public List<Curso> listarTodos() {
        return repo.findAll();
    }

    public Optional<Curso> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
