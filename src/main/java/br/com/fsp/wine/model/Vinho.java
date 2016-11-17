package br.com.fsp.wine.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="vinho")
public class Vinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "O nome do vinho deve ser informado.")
	@Size(min = 3, max = 45, message = "O nome do vinho deve ter no minimo {min} e no máximo {max} caracteres.")
	private String nome;
	
	@NotNull(message = "Tipo do vinho deve ser escolhido.")
	@Enumerated(EnumType.STRING)
	private TipoVinho tipo;
	
	@NotNull(message = "A safra do vinho deve ser informada.")
	@Min(value = 1, message = "A safra do vinho deve ser no mínimo {value}.")
	@Max(value = 2016, message = "A safra do vinho deve ser no máximo {value}.")
	private Integer safra;
	
	@NotNull(message = "O volume do vinho deve ser informado.")
	@Min(value = 50, message = "O volume do vinho deve ser no mínimo {value}.")
	@Max(value = 20000, message = "O volume do vinho deve ser no máximo {value}.")
	private Integer volume;
	
	@NotNull(message = "O valor do vinho deve ser informado.")
	@DecimalMin(value = "0.00", message = "O valor do vinho deve ser no mínimo {value}.")
	private BigDecimal valor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoVinho getTipo() {
		return tipo;
	}
	public void setTipo(TipoVinho tipo) {
		this.tipo = tipo;
	}
	public Integer getSafra() {
		return safra;
	}
	public void setSafra(Integer safra) {
		this.safra = safra;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinho other = (Vinho) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
