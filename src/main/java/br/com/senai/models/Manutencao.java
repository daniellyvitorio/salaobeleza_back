package br.com.senai.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name="manutencao_agendamento")
@EqualsAndHashCode(of="id")
public class Manutencao implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name="agendamento_id", nullable = false)
        private Agendamento agendamento;
}

