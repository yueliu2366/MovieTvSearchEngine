package neu.cs5200.movieTv.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User2MovieDao {

	//Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movieTvApp");	
	EntityManager ma = null;
	
	//constructor
	public User2MovieDao() {
		ma = factory.createEntityManager();
	}
	
	public void markMovie(User2Movie um) {
		ma.getTransaction().begin();
		ma.persist(um);
		ma.getTransaction().commit();
	}
	
	public List<Long> findMovieIdByUserId(long userId) {
		ma.getTransaction().begin();
		
		Query q = ma.createNamedQuery("um.findByUserId");
		q.setParameter("userId", userId);
		List<Long> movieIdList = q.getResultList();
		
		ma.getTransaction().commit();
		
		return movieIdList;
	}
	
	public static void main(String[] args) {
		User2MovieDao dao = new User2MovieDao();
		System.out.println(dao.findMovieIdByUserId(1));
	}
}
