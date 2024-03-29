package com.Respuesta.Foro.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="Respuestas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	private Long topicoId;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private Long autorId;
	private Boolean solucion = false;
}
