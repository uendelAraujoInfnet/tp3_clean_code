package com.uendel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Sprint {

    private final String nome;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
    private final List<Task> tarefas;

    public Sprint(String nome, LocalDate dataInicio, LocalDate dataFim, List<Task> tarefas) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tarefas = new ArrayList<>(tarefas); // Cópia defensiva
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public List<Task> getTarefas() {
        return Collections.unmodifiableList(tarefas);
    }

    public Sprint adicionarTarefa(Task novaTarefa) {
        List<Task> novaLista = new ArrayList<>(this.tarefas);
        novaLista.add(novaTarefa);
        return new Sprint(this.nome, this.dataInicio, this.dataFim, novaLista);
    }

    public Sprint removerTarefa(Task tarefa) {
        List<Task> novaLista = new ArrayList<>(this.tarefas);
        novaLista.remove(tarefa);
        return new Sprint(this.nome, this.dataInicio, this.dataFim, novaLista);
    }

    public void listarTarefas() {
        tarefas.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", tarefas=" + tarefas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sprint sprint)) return false;
        return nome.equals(sprint.nome) &&
               dataInicio.equals(sprint.dataInicio) &&
               dataFim.equals(sprint.dataFim) &&
               tarefas.equals(sprint.tarefas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicio, dataFim, tarefas);
    }
}

