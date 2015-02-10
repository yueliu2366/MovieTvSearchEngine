package neu.cs5200.movieTv.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UserDao {

	//Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movieTvApp");	
	EntityManager ma = null;
	
	//constructor
	public UserDao() {
		ma = factory.createEntityManager();
	}
	
	public void createUser(User user) {
		//ma.getTransaction().begin();
		ma.persist(user);
		ma.getTransaction().commit();
	}
	
	public User findUserById(long userId) {
		ma.getTransaction().begin();
		User user = ma.find(User.class, userId);
		ma.getTransaction().commit();
		return user;
	}
	
	public User findUserByUsername(String username) {
		try {
			ma.getTransaction().begin();
			
			Query q = ma.createNamedQuery("User.findByUsername");
			q.setParameter("username", username);	
			User user = (User) q.getSingleResult();
			
			ma.getTransaction().commit();
			return user;
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public User findUserByUsernameAndPassword(String username, String password){
		try {
			ma.getTransaction().begin();
			
			Query q = ma.createNamedQuery("User.findByUsernameAndPassword");
			q.setParameter("username", username);
			q.setParameter("password", password);	
			User user = (User) q.getSingleResult();
			
			ma.getTransaction().commit();
			return user;
		}
		catch(NoResultException e) {
			return null;
		}				
	}
	
	public static void main(String[] args) {
//		UserDao dao = new UserDao();
//		User u1 = dao.findUserByUsernameAndPassword("test", "test");
//		System.out.println(u1.getId());
//		System.out.println(dao.findUserById(2).getUsername());
		
//		User user = new User("Pan", "pppp");
//		dao.createUser(user);
//		
//		User u = dao.findUserByUsername("Cheer");
//		System.out.println(u.getId());
//		System.out.println(dao.findUserById(1).getUsername());
	}

}
