package neu.cs5200.movieTv.movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PopularMovieDao {
	//Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movieTvApp");	
	EntityManager ma = null;
	
	//constructor
	public PopularMovieDao() {
		ma = factory.createEntityManager();
	}
	
	public void createPopMovie(PopularMovie movie) {
		ma.getTransaction().begin();
		ma.persist(movie);
		ma.getTransaction().commit();
	}
	
	public void createTop10PopMovies(List<Movie> movies) {
		ma.getTransaction().begin();
		for(int index = 0; index < 10; index++) {
			Movie m = movies.get(index);
			PopularMovie popMovie = new PopularMovie(m.getId(), m.getTitle());
			createPopMovie(popMovie);
		}
		ma.getTransaction().commit();
	}
	
	public PopularMovie findPopMovieByIndex(int index) {
		ma.getTransaction().begin();
		PopularMovie popMovie = ma.find(PopularMovie.class, index);
		ma.getTransaction().commit();	
		return popMovie;
	}
	
	
	public PopularMovie findPopMovieByMovieId(long movieId) {
		ma.getTransaction().begin();
		Query q = ma.createNamedQuery("popMovie.findByMovieId");
		q.setParameter("movieId", movieId);	
		PopularMovie popMovie = (PopularMovie) q.getSingleResult() ;
		ma.getTransaction().commit();	
		return popMovie;
	}
	
	public static void main(String[] args) {
//		Movie m1 = new Movie(111111, "11111111");
//		Movie m2 = new Movie(222222, "222222");
//		List<Movie> mlist = new ArrayList<Movie> ();
//		mlist.add(m1);
//		mlist.add(m2);
//		
//		PopularMovieDao dao = new PopularMovieDao();
//		dao.createPopMovies(mlist);
		
//		System.out.println(dao.findPopMovieByIndex(1).getMovieId());
	}

}
