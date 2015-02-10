package neu.cs5200.movieTv.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name = "um.findByUserId", 
			query="select um.movie from User2Movie um inner join um.user u where u.id = :userId")

@Entity
public class User2Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="USER")
	private User user;
	
	private long movie;
	
	public User2Movie() {
		super();
	}

	public User2Movie(User user, long movie) {
		super();
		this.user = user;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getMovie() {
		return movie;
	}

	public void setMovie(long movie) {
		this.movie = movie;
	}
	
}
