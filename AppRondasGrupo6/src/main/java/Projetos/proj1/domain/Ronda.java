package Projetos.proj1.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Ronda implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RondaId")
	@SequenceGenerator(name = "RondaId", sequenceName = "RondaId", allocationSize = 1)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date dataHoraFim;
	
	private Float latUltima;
	private Float lonUltima;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraUltima;
	
	@ManyToOne(optional = false)
	private Locomocao locomocao;
	
	@ManyToMany
	private List<Pessoa> vigilantes;
	
	
	private static final long serialVersionUID = 1L;

	
	public Ronda() {
		super();
	}   
	
	
	public Ronda(Integer id) {
		super();
		this.id = id;
	}
	public Ronda(Integer id, Date dataHoraInicio, Date dataHoraFim, Float latUltima, Float lonUltima, Date dataHoraUltima, Locomocao locomocao, List<Pessoa> vigilantes) {
		super();
		this.id = id;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.latUltima = latUltima;
		this.lonUltima = lonUltima;
		this.dataHoraUltima = dataHoraUltima;
		this.locomocao = locomocao;
		this.vigilantes = vigilantes;
	}

	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}   
	
	
	public Date getDataHoraInicio() {
		return this.dataHoraInicio;
	}
	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}   
	
	
	public Date getDataHoraFim() {
		return this.dataHoraFim;
	}
	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}   
	
	
	public Float getLatUltima() {
		return this.latUltima;
	}
	public void setLatUltima(Float latUltima) {
		this.latUltima = latUltima;
	}  
	
	
	public Float getLonUltima() {
		return this.lonUltima;
	}
	public void setLonUltima(Float lonUltima) {
		this.lonUltima = lonUltima;
	}   
	
	
	public Date getDataHoraUltima() {
		return this.dataHoraUltima;
	}
	public void setDataHoraUltima(Date dataHoraUltima) {
		this.dataHoraUltima = dataHoraUltima;
	}   
	
	
	public Locomocao getLocomocao() {
		return this.locomocao;
	}
	public void setLocomocao(Locomocao locomocao) {
		this.locomocao = locomocao;
	}   
	
	
	public List<Pessoa> getVigilantes() {
		return this.vigilantes;
	}
	public void setVigilantes(List<Pessoa> vigilantes) {
		this.vigilantes = vigilantes;
	}
}
