package com.uendel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Task {

  private final String titulo;
  private final String descricao;
  private final Status status;
  private final User responsavel;
  private final List<WorkLog> registrosTrabalho;

  public Task(String titulo, String descricao, Status status, User responsavel) {
    this(titulo, descricao, status, responsavel, new ArrayList<>());
  }
 
  public Task(String titulo, String descricao, Status status, User responsavel, List<WorkLog> registrosTrabalho) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.responsavel = responsavel;
    this.registrosTrabalho = new ArrayList<>(registrosTrabalho);
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public Status getStatus() {
    return status;
  }

  public User getResponsavel() {
    return responsavel;
  }

  public List<WorkLog> getRegistrosTrabalho() {
    return Collections.unmodifiableList(registrosTrabalho);
  }

  // Método alterador de status 
  public Task alterarStatus(Status novoStatus){
    return new Task(this.titulo, this.descricao, novoStatus, this.responsavel, this.registrosTrabalho);
  }

  // Método atribuidor de novos responsáveis 
  public Task atribuirResponsavel( User novoResponsavel ){
    return new Task(this.titulo, this.descricao, this.status, novoResponsavel, this.registrosTrabalho);
  }

  public Task adicionarWorkLog(WorkLog novoLog) {
    List<WorkLog> novaLista = new ArrayList<>(this.registrosTrabalho);
    novaLista.add(novoLog);
    return new Task(this.titulo, this.descricao, this.status, this.responsavel, novaLista);
  }

  @Override
    public String toString() {
        return "Task{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", responsavel=" + responsavel +
                ", registrosTrabalho=" + registrosTrabalho +
                '}';
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if(!(o instanceof Task task)) return false;

    return titulo.equals(task.titulo) &&
           descricao.equals(task.descricao) &&
           status == task.status &&
           Objects.equals(responsavel, task.responsavel) &&
           registrosTrabalho.equals(task.registrosTrabalho);
  }

  @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, status, responsavel, registrosTrabalho);
    }

    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }
}
