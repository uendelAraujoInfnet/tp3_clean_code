package com.uendel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class RegistroAtividade {

    private final String id;
    private final TipoAcao tipo;
    private final LocalDateTime dataHora;
    private final String usuarioResponsavel;
    private final String descricao;
    private final BigDecimal impactoEstimado;

    public RegistroAtividade(TipoAcao tipo, String usuarioResponsavel, String descricao, BigDecimal impactoEstimado) {
        if (tipo == null) throw new IllegalArgumentException("Tipo de ação é obrigatório.");
        if (usuarioResponsavel == null || usuarioResponsavel.isBlank())
            throw new IllegalArgumentException("Usuário responsável é obrigatório.");
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição é obrigatória.");
        if (impactoEstimado == null || impactoEstimado.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Impacto estimado deve ser zero ou positivo.");

        this.id = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
        this.usuarioResponsavel = usuarioResponsavel;
        this.descricao = descricao;
        this.impactoEstimado = impactoEstimado;
    }

    public String getId() {
        return id;
    }

    public TipoAcao getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getImpactoEstimado() {
        return impactoEstimado;
    }

    @Override
    public String toString() {
        return "RegistroAtividade{" +
                "id='" + id + '\'' +
                ", tipo=" + tipo +
                ", dataHora=" + dataHora +
                ", usuarioResponsavel='" + usuarioResponsavel + '\'' +
                ", descricao='" + descricao + '\'' +
                ", impactoEstimado=" + impactoEstimado +
                '}';
    }

    public enum TipoAcao {
        CRIACAO,
        ATUALIZACAO,
        DELECAO,
        COMENTARIO,
        ALTERACAO_STATUS
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistroAtividade that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

