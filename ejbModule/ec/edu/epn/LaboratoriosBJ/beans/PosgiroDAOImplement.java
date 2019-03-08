package ec.edu.epn.LaboratoriosBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Posgiro;

/**
 * Session Bean implementation class PosgiroDAOImplement
 */
@Stateless
@LocalBean
public class PosgiroDAOImplement extends DaoGenericoImplement<Posgiro> implements PosgiroDAO {

    /**
     * Default constructor. 
     */
    public PosgiroDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
