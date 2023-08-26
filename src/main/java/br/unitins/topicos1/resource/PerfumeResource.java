package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Perfume;
import br.unitins.topicos1.repository.PerfumeRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/perfumes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfumeResource {
    

    @Inject
    PerfumeRepository repository;


    @POST
    @Transactional
    public Perfume insert(Perfume perfume){
        Perfume novoPerfume = new Perfume();
        novoPerfume.setNome(perfume.getNome());
        novoPerfume.setFragrancia(perfume.getFragrancia());
        novoPerfume.setPais(perfume.getPais());

        repository.persist(novoPerfume);

        return novoPerfume;
    }
    
    @PUT
    @Path("/replace")
    @Transactional
    public Perfume replace(Perfume perfume) {
        Perfume p = repository.findById(perfume.getId());
        if(perfume.getNome() != null) p.setNome(perfume.getNome());
        if(perfume.getFragrancia()!= null) p.setFragrancia(perfume.getFragrancia());
        if(perfume.getPais() != null) p.setPais(perfume.getPais());
        repository.persist(p);
        return p;
        }
    

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        if(repository.deleteById(id)){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
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
