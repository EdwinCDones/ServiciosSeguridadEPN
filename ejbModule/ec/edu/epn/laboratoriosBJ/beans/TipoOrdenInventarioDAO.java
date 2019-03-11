package ec.edu.epn.laboratoriosBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;




@Local
public interface TipoOrdenInventarioDAO extends DaoGenerico<Tipordeninv> {

	int consultarId();

	 List<Tipordeninv> listarTipordeninv();

	 List<Tipordeninv> buscarTipordeninv(int alq);

	

}
