package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grado")
	private String idGrado;

	@Column(name="descr_gr")
	private String descrGr;

	@Column(name="nombre_gr")
	private String nombreGr;

	//bi-directional many-to-one association to Existencia
	@OneToMany(mappedBy="grado")
	private List<Existencia> existencias;

	public Grado() {
	}

	public String getIdGrado() {
		return this.idGrado;
	}

	public void setIdGrado(String idGrado) {
		this.idGrado = idGrado;
	}

	public String getDescrGr() {
		return this.descrGr;
	}

	public void setDescrGr(String descrGr) {
		this.descrGr = descrGr;
	}

	public String getNombreGr() {
		return this.nombreGr;
	}

	public void setNombreGr(String nombreGr) {
		this.nombreGr = nombreGr;
	}

	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setGrado(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setGrado(null);

		return existencia;
	}

}