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

    public Perfume replacePerfume(Long id, Perfume replacePerfume) {
        Perfume perfume = findById(id);
        if (perfume != null) {
            perfume.setNome(replacePerfume.getNome());
            perfume.setFragrancia(replacePerfume.getFragrancia());
            perfume.setPais(replacePerfume.getPais());
            return perfume;
        }
        return null;
    }


    public boolean deletePerfume(Long id) {
        Perfume perfume = findById(id);
        if (perfume != null) {
            delete(perfume);
            return true;
        }
        return false;
    }

}
