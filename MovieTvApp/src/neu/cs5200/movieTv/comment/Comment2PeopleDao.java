package neu.cs5200.movieTv.comment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import neu.cs5200.movieTv.user.User;

public class Comment2PeopleDao {
	// Read configuration info from persistence.xml
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("movieTvApp");
		EntityManager ma = null;

		public Comment2PeopleDao() {
			ma = factory.createEntityManager();
		}
		public void createComment2People(Comment2People c2p) {
			ma.getTransaction().begin();
			ma.persist(c2p);
			ma.getTransaction().commit();    	
		}
		

		public List<Comment> findCommentsByPid(String pId) {
			ma.getTransaction().begin();
			
			Query q = ma.createNamedQuery("cp.findCommentsByPid");
			q.setParameter("pId", pId);
			List<Comment> cms = q.getResultList();
			
			ma.getTransaction().commit();
			
			return cms;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}
