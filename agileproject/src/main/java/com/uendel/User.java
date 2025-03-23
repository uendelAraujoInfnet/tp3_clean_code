package com.uendel;

import java.util.Objects;

public final class User {

  private final String nome;
  private final String email;
  private final String cargo;

  public User(String nome, String email, String cargo) {
      this.nome = nome;
      this.email = email;
      this.cargo = cargo;
  }

  public String getNome() {
      return nome;
  }

  public String getEmail() {
      return email;
  }

  public String getCargo() {
      return cargo;
  }

  // Método para atualizar email 
  public User atualizarEmail(String novoEmail) {
      return new User(this.nome, novoEmail, this.cargo);
  }

  // Método para definir novo cargo 
  public User definirCargo(String novoCargo) {
      return new User(this.nome, this.email, novoCargo);
  }

  @Override
  public String toString() {
      return "User{" +
              "nome='" + nome + '\'' +
              ", email='" + email + '\'' +
              ", cargo='" + cargo + '\'' +
              '}';
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User user)) return false;
      return nome.equals(user.nome) &&
             email.equals(user.email) &&
             cargo.equals(user.cargo);
  }

  @Override
  public int hashCode() {
      return Objects.hash(nome, email, cargo);
  }
}
