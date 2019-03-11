/**
 * 
 */
package ec.edu.epn.laboratoriosBJ.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;

/**
 * @author Administrador
 * 
 */
@Stateless
public class TipoOrdenInventarioDAOImplement extends DaoGenericoImplement<Tipordeninv>
		implements TipoOrdenInventarioDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(alq.id_tipordeninv)FROM tipordeninv alq");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		return idReq;

	}

	@Override
	public List<Tipordeninv> listarTipordeninv() {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Tipordeninv alq");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<Tipordeninv> buscarTipordeninv(int alq) {
		StringBuilder queryString = new StringBuilder(
				"SELECT alq FROM Tipordeninv alq where alq.id_tipordeninv=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, alq);

		return query.getResultList();
	}

	

}
