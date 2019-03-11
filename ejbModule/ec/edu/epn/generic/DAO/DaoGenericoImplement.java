package ec.edu.epn.generic.DAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBMetaData;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoGenericoImplement<E> implements DaoGenerico<E>{

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	private EntityManager entityManager;
	
	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;
	
	@Resource
	private SessionContext sessionContext;	

	public EntityManager getEntityManager() {
		return entityManager;
	}
		

	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Override
	public void cerrarConexion(Connection con, PreparedStatement ps) {		
		try {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(E objeto) throws Exception {
		
		entityManager.persist(objeto);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(E objeto) throws Exception {
		entityManager.merge(objeto);		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(E objeto) throws Exception {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(objeto));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll(Class<E> classe) throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery(
				" select o from " + classe.getSimpleName() + " o ")
				.getResultList();
	}

	@Override
	public Object getById(Class<E> classe, Object pk) {
		try {
			return entityManager.find(classe, pk);
		} catch (Exception exception) {
			return null;
		}

	}


	@Override
	public EJBMetaData getEJBMetaData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HomeHandle getHomeHandle() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void remove(Handle arg0) throws RemoteException, RemoveException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remove(Object arg0) throws RemoteException, RemoveException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Integer generarId(String entidad, String id){ //Paciente //numerohclPac
		Query q = getEntityManager().createQuery("select max(e." + id + ") from " + entidad + " e");
		Integer numero = null;
		try {
			numero =(Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			numero = null;
		}
		if (numero==null)
			numero = 1;
		else
			++numero;
		return numero;
	}

	@Override
	public Connection conexionDocenteReporte(){
		try {
			Connection con = null;				
			con = dataSource.getConnection();
			return con;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@Override
	public void eliminar(String entidad, String idCampo,Integer valor) {


		Query query = getEntityManager().createQuery("Delete From "+ entidad + " e where e."+idCampo+" = ?1  " );
		query.setParameter(1, valor);

		 query.executeUpdate();
		
		
		
	}


}
