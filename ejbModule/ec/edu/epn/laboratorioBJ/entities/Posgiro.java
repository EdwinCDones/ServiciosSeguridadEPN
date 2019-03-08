package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posgiro database table.
 * 
 */
@Entity
@Table(name = "posgiro", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Posgiro.findAll", query="SELECT p FROM Posgiro p")
public class Posgiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POSGIRO_IDPOSGIRO_GENERATOR", sequenceName="secuencia_postgiro",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSGIRO_IDPOSGIRO_GENERATOR")
	@Column(name="id_posgiro")
	private String idPosgiro;

	@Column(name="descr_pg")
	private String descrPg;

	@Column(name="nombre_pg")
	private String nombrePg;

	//bi-directional many-to-one association to Existencia
	@OneToMany(mappedBy="posgiro")
	private List<Existencia> existencias;

	public Posgiro() {
	}

	public String getIdPosgiro() {
		return this.idPosgiro;
	}

	public void setIdPosgiro(String idPosgiro) {
		this.idPosgiro = idPosgiro;
	}

	public String getDescrPg() {
		return this.descrPg;
	}

	public void setDescrPg(String descrPg) {
		this.descrPg = descrPg;
	}

	public String getNombrePg() {
		return this.nombrePg;
	}

	public void setNombrePg(String nombrePg) {
		this.nombrePg = nombrePg;
	}

	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setPosgiro(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setPosgiro(null);

		return existencia;
	}

}