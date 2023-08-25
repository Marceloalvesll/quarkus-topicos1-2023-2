package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Perfume;
import br.unitins.topicos1.repository.PerfumeRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/perfumes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfumeResource {
    

    @Inject
    PerfumeRepository repository;


    @POST
    public Perfume insert(Perfume perfume){
        Perfume novoPerfume = new Perfume();
        novoPerfume.setNome(perfume.getNome());
        novoPerfume.setFragancia(perfume.getFragancia());
        novoPerfume.setPais(perfume.getPais());

        repository.persist(novoPerfume);

        return novoPerfume;
    }
    


    @GET
    public List<Perfume> findAll(){
        return repository.listAll();
    }


    @GET
    @Path("/{id}")
    public Perfume findById(@PathParam("id") Long id){
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Perfume> findByNome(@PathParam("nome") String nome){
        return repository.findBynome(nome);
    }

}
