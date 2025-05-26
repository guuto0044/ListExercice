package Generics.MapExercicies.Ex1.entities;

import java.util.Objects;

public class Candidates {

    private String name;
    private Integer votos;

    public Candidates(){

    }

    public Candidates(String name, Integer votos) {
        this.name = name;
        this.votos = votos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidates that = (Candidates) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
