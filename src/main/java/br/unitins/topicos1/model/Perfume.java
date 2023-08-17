package br.unitins.topicos1.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;



@Entity
public class Perfume extends PanacheEntity {
    private String nome;
    private String fragrancia;
    private String pais;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFragancia() {
        return fragrancia;
    }
    public void setFragancia(String fragancia) {
        this.fragrancia = fragancia;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    

}
