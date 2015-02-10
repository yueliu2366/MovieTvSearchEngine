package neu.cs5200.movieTv.movie;
//package neu.cs5200.movieTv;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//
//public class MovieDao {
//	//Read configuration info from persistence.xml
//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("assignment");	
//	EntityManager ma = null;
//	
//	//constructor
//	public MovieDao() {
//		ma = factory.createEntityManager();
//	}
//	
//	public Movie findMovie(int movieId) {
//		ma.getTransaction().begin();
//		Movie movie = ma.find(Movie.class, movieId);
//		ma.getTransaction().commit();
//		return movie;
//	}
//	
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		MovieDao dao = new MovieDao();
//		System.out.println(dao.findMovie(1));
//		
//	}
//
//}
