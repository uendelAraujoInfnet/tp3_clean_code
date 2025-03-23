package com.uendel;

import java.util.Objects;

public final class Task {

  private final String titulo;
  private final String descricao;
  private final Status status;
  private final User responsavel;
 
  public Task(String titulo, String descricao, Status status, User responsavel) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.responsavel = responsavel;
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

  // Método alterador de status 
  public Task alterarStatus(Status novoStatus){
    return new Task(this.titulo, this.descricao, novoStatus, this.responsavel);
  }

  // Método atribuidor de novos responsáveis 
  public Task atribuirResponsavel( User novoResponsavel ){
    return new Task(this.titulo, this.descricao, this.status, novoResponsavel);
  }

  @Override
    public String toString() {
        return "Task{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", responsavel=" + responsavel +
                '}';
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if(!(o instanceof Task task)) return false;

    return titulo.equals(task.titulo) &&
           descricao.equals(task.descricao) &&
           status == task.status &&
           Objects.equals(responsavel, task.responsavel);
  }

  @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, status, responsavel);
    }

    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }
}
