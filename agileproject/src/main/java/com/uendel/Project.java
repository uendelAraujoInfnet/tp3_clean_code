package com.uendel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Project {

    private final String nome;
    private final String descricao;
    private final List<Sprint> sprints;

    public Project(String nome, String descricao, List<Sprint> sprints) {
        this.nome = nome;
        this.descricao = descricao;
        this.sprints = new ArrayList<>(sprints); // cópia defensiva
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Sprint> getSprints() {
        return Collections.unmodifiableList(sprints);
    }

    // Adiciona nova sprint (retorna novo Project)
    public Project adicionarSprint(Sprint novaSprint) {
        List<Sprint> novaLista = new ArrayList<>(this.sprints);
        novaLista.add(novaSprint);
        return new Project(this.nome, this.descricao, novaLista);
    }

    // Remove uma sprint (retorna novo Project)
    public Project removerSprint(Sprint sprint) {
        List<Sprint> novaLista = new ArrayList<>(this.sprints);
        novaLista.remove(sprint);
        return new Project(this.nome, this.descricao, novaLista);
    }

    // Lista as sprints no console
    public void listarSprints() {
        sprints.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Project{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sprints=" + sprints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return nome.equals(project.nome) &&
               descricao.equals(project.descricao) &&
               sprints.equals(project.sprints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, sprints);
    }
}
