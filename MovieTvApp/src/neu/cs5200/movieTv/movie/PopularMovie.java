package neu.cs5200.movieTv.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery (name="popMovie.findByMovieId", query="select m from PopularMovie m where m.movieId = :movieId")

@Entity
public class PopularMovie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private long movieId;
	private String title;
		
	public PopularMovie() {
		super();
	}

	public PopularMovie(long movieId, String title) {
		super();
		this.movieId = movieId;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	
}
