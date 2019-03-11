package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipordeninv database table.
 * 
 */
@Entity
@Table(name = "tipordeninv", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Tipordeninv.findAll", query="SELECT t FROM Tipordeninv t")
public class Tipordeninv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipordeninv")
	private String idTipordeninv;

	@Column(name="descr_toi")
	private String descrToi;

	@Column(name="nombre_toi")
	private String nombreToi;

	//bi-directional many-to-one association to Ordeninventario
	@OneToMany(mappedBy="tipordeninv")
	private List<Ordeninventario> ordeninventarios;

	public Tipordeninv() {
	}

	public String getIdTipordeninv() {
		return this.idTipordeninv;
	}

	public void setIdTipordeninv(String idTipordeninv) {
		this.idTipordeninv = idTipordeninv;
	}

	public String getDescrToi() {
		return this.descrToi;
	}

	public void setDescrToi(String descrToi) {
		this.descrToi = descrToi;
	}

	public String getNombreToi() {
		return this.nombreToi;
	}

	public void setNombreToi(String nombreToi) {
		this.nombreToi = nombreToi;
	}

	public List<Ordeninventario> getOrdeninventarios() {
		return this.ordeninventarios;
	}

	public void setOrdeninventarios(List<Ordeninventario> ordeninventarios) {
		this.ordeninventarios = ordeninventarios;
	}

	public Ordeninventario addOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().add(ordeninventario);
		ordeninventario.setTipordeninv(this);

		return ordeninventario;
	}

	public Ordeninventario removeOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().remove(ordeninventario);
		ordeninventario.setTipordeninv(null);

		return ordeninventario;
	}

}