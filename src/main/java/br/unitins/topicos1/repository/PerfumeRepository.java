package br.unitins.topicos1.repository;


import java.util.List;

import br.unitins.topicos1.model.Perfume;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PerfumeRepository implements PanacheRepository<Perfume> {
    public List<Perfume> findBynome(String nome){
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }
}
