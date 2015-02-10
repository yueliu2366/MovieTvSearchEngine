package neu.cs5200.movieTv.comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import neu.cs5200.movieTv.user.User;

public class CommentDao {

	// Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("movieTvApp");
	EntityManager ma = null;

	public CommentDao() {
		ma = factory.createEntityManager();
	}
	public int createComment(Comment comment) {
		ma.getTransaction().begin();
		ma.persist(comment);
		ma.flush();
		int cid = comment.getcId();
		ma.getTransaction().commit();
        return cid;		
	}

	public Comment findCommentById(int cId) {
		ma.getTransaction().begin();
		Comment comment = ma.find(Comment.class, cId);
		ma.getTransaction().commit();
		return comment;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
