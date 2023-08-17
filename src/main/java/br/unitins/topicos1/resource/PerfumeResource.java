package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Perfume;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/perfumes")

public class PerfumeResource {
    

    
@GET
@Produces(MediaType.APPLICATION_JSON)
    public List<Perfume> todosPerfumes(){
        return Perfume.listAll();
    }


}
