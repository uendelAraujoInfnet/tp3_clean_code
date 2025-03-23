package com.uendel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando usuários
        User dev = new User("Uendel Ives", "uendel@empresa.com", "Desenvolvedor Backend");
        User qa = new User("Larissa Souza", "larissa@empresa.com", "Analista de Testes");

        // Criando tarefas
        Task tarefa1 = new Task("Criar endpoint de login", "Implementar autenticação via token", Task.Status.TODO, dev);
        Task tarefa2 = new Task("Criar testes de integração", "Cobrir cenário de autenticação", Task.Status.TODO, qa);

        // Criando sprint com tarefas
        List<Task> listaTarefasSprint1 = new ArrayList<>();
        listaTarefasSprint1.add(tarefa1);
        listaTarefasSprint1.add(tarefa2);

        Sprint sprint1 = new Sprint("Sprint 1", LocalDate.of(2025, 3, 25), LocalDate.of(2025, 4, 5), listaTarefasSprint1);

        // Criando projeto com sprint
        List<Sprint> listaSprints = new ArrayList<>();
        listaSprints.add(sprint1);

        Project projetoAgil = new Project("Sistema de Gestão Ágil", "Projeto para organização de equipes ágeis", listaSprints);

        // Exibindo dados
        System.out.println("==== Projeto ====");
        System.out.println("Nome: " + projetoAgil.getNome());
        System.out.println("Descrição: " + projetoAgil.getDescricao());

        System.out.println("\n==== Sprints ====");
        projetoAgil.listarSprints();

        System.out.println("\n==== Tarefas da Sprint 1 ====");
        sprint1.listarTarefas();
    }
}
