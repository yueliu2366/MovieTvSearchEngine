package neu.cs5200.movieTv.comment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Comment2TvDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("movieTvApp");
	EntityManager ma = null;

	public Comment2TvDao() {
		ma = factory.createEntityManager();
	}
	public void createComment2Tv(Comment2Tv c2t) {
		ma.getTransaction().begin();
		ma.persist(c2t);
		ma.getTransaction().commit();    	
	}
	

	public List<Comment> findCommentsByTid(String tId) {
		ma.getTransaction().begin();
		
		Query q = ma.createNamedQuery("ct.findCommentsBytid");
		q.setParameter("tId", tId);
		List<Comment> cms = q.getResultList();
		
		ma.getTransaction().commit();
		
		return cms;
	}
}
