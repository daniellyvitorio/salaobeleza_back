package br.com.senai.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="agendamento")
@EqualsAndHashCode(of="id")
public class Agendamento  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String servico;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data_agendamento;

//    @Column(nullable = false)
//    private Double hora;

//    @OneToOne
//    @JoinColumn(name="manutencao_id", nullable = true)
//    private Manutencao manutencao;
}