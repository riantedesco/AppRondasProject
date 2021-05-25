package Projetos.proj1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Localizacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocalizacaoId")
	@SequenceGenerator(name = "LocalizacaoId", sequenceName = "LocalizacaoId", allocationSize = 1)	
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHora;
	
	@Column(nullable = false)
	private Float latitude;
	
	@Column(nullable = false)
	private Float longitude;
	
	@ManyToOne(optional = false)
	private Ronda ronda;
	
	
	private static final long serialVersionUID = 1L;
	

	public Localizacao() {
		super();
	}
	

	public Localizacao(Integer id) {
		super();
		this.id = id;
	}
	public Localizacao(Integer id, Date dataHora, Float latitude, Float longitude, Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ronda = ronda;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	

	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	

	public Ronda getRonda() {
		return ronda;
	}
	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
