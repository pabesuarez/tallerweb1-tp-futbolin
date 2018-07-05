package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Puntos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer golesComoDelantero;
	private Integer golesComoVolante;
	private Integer golesComoDefensor;
	private Integer golesComoArquero;
	private Integer golesDePenal;
	private Integer golesEnContra;
	private Integer golesRecibidos;
	private Integer tarjetasAmarillas;
	private Integer tarjetaRoja;
	private Integer penalesErrados;
	private Integer penalesAtajados;
	
	@OneToOne
	private Cupo cupo;
	
	public Cupo getCupo() {
		return cupo;
	}
	public void setCupo(Cupo cupo) {
		this.cupo = cupo;
	}



	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getGolesComoDelantero() {
		return golesComoDelantero;
	}
	public void setGolesComoDelantero(Integer golesComoDelantero) {
		this.golesComoDelantero = golesComoDelantero;
	}
	public Integer getGolesComoVolante() {
		return golesComoVolante;
	}
	public void setGolesComoVolante(Integer golesComoVolante) {
		this.golesComoVolante = golesComoVolante;
	}
	public Integer getGolesComoDefensor() {
		return golesComoDefensor;
	}
	public void setGolesComoDefensor(Integer golesComoDefensor) {
		this.golesComoDefensor = golesComoDefensor;
	}
	public Integer getGolesComoArquero() {
		return golesComoArquero;
	}
	public void setGolesComoArquero(Integer golesComoArquero) {
		this.golesComoArquero = golesComoArquero;
	}
	public Integer getGolesDePenal() {
		return golesDePenal;
	}
	public void setGolesDePenal(Integer golesDePenal) {
		this.golesDePenal = golesDePenal;
	}
	public Integer getGolesEnContra() {
		return golesEnContra;
	}
	public void setGolesEnContra(Integer golesEnContra) {
		this.golesEnContra = golesEnContra;
	}
	public Integer getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos(Integer golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	public Integer getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}
	public void setTarjetasAmarillas(Integer tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}
	public Integer getTarjetaRoja() {
		return tarjetaRoja;
	}
	public void setTarjetaRoja(Integer tarjetaRoja) {
		this.tarjetaRoja = tarjetaRoja;
	}
	public Integer getPenalesErrados() {
		return penalesErrados;
	}
	public void setPenalesErrados(Integer penalesErrados) {
		this.penalesErrados = penalesErrados;
	}
	public Integer getPenalesAtajados() {
		return penalesAtajados;
	}
	public void setPenalesAtajados(Integer penalesAtajados) {
		this.penalesAtajados = penalesAtajados;
	}
	

	   public  Integer puntajeTotal(){
		   
	 Integer puntosTotales;
	 puntosTotales=this.golesComoArquero+this.golesComoDefensor+this.golesComoDelantero+this.golesComoVolante+this.golesDePenal+this.golesEnContra+this.golesRecibidos+this.penalesAtajados+this.penalesErrados+this.tarjetaRoja+this.tarjetasAmarillas;	 
	 
	 
	return puntosTotales;
	 
	    }
}

