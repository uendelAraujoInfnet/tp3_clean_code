package com.uendel;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public final class WorkLog {

    private final String id;
    private final User usuario;
    private final double horas;
    private final LocalDate data;
    private final String descricao;

    public WorkLog(User usuario, double horas, LocalDate data, String descricao) {
        if (usuario == null) throw new IllegalArgumentException("Usuário não pode ser nulo.");
        if (horas <= 0) throw new IllegalArgumentException("Horas devem ser positivas.");
        if (data == null) throw new IllegalArgumentException("Data não pode ser nula.");
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição é obrigatória.");

        this.id = UUID.randomUUID().toString(); // Geração automática de identificador
        this.usuario = usuario;
        this.horas = horas;
        this.data = data;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public User getUsuario() {
        return usuario;
    }

    public double getHoras() {
        return horas;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para atualizar número de horas - retorna nova instância
    public WorkLog atualizarHoras(double novasHoras) {
        return new WorkLog(this.usuario, novasHoras, this.data, this.descricao);
    }

    // Método para atualizar descrição - retorna nova instância
    public WorkLog atualizarDescricao(String novaDescricao) {
        return new WorkLog(this.usuario, this.horas, this.data, novaDescricao);
    }

    @Override
    public String toString() {
        return "WorkLog{" +
                "id='" + id + '\'' +
                ", usuario=" + usuario +
                ", horas=" + horas +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkLog workLog)) return false;
        return id.equals(workLog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

