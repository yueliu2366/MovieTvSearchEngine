package neu.cs5200.movieTv.movie;

//@Entity
//public class Movie {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="MOVIE_ID")
//	private int id;
////	private int budget;	
////	private List<Genre> genres;	
////	private String homepage;
////	private String title;
////	private String overview;
////	private String posterPath;	
////	private List<Company> productionCompanies;
////	private List<Country> productionCountries;	
////	private String releaseDate;
////	private int runtime;	
////	private List<Lan> spokenLanguages;
////	private String status;
////	private String tagline;
////	private double voteAverage;
////	private int voteCount;
//		
//}



import neu.cs5200.movieTv.user.User;

import java.util.List;


public class Movie {

	private long id;
	private List<User> users;
	
	private String title;
	private String overview;
	private String tagline;
	private String releaseDate;
	private double voteAverage;
	private String posterPath;
	
	

	public Movie() {
	}
	
	

	public Movie(long id) {
		super();
		this.id = id;
	}



	public Movie(int movieId, String title) {
		super();
		this.id = movieId;
		this.title = title;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long movieId) {
		this.id = movieId;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}
	
	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
}
