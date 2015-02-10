//package neu.cs5200.movieTv.user;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
//import neu.cs5200.movieTv.movie.Movie;
//
//import java.util.List;
//
//
///**
// * The persistent class for the USER database table.
// * 
// */
//@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//public class User implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="USER_ID")
//	private long id;
//
//	private String password;
//
//	private String username;
//
//	//bi-directional many-to-many association to Movie
//	@ManyToMany
//	@JoinTable(
//		name="USER_MOVIE"
//		, joinColumns={
//			@JoinColumn(name="USER_ID")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="MOVIE_ID")
//			}
//		)
//	private List<Movie> movies;
//
//	public User() {
//	}
//	
//
//	public User(String password, String username) {
//		super();
//		this.password = password;
//		this.username = username;
//	}
//
//
//
//	public long getId() {
//		return this.id;
//	}
//
//	public void setId(int userId) {
//		this.id = userId;
//	}
//
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getUsername() {
//		return this.username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public List<Movie> getMovies() {
//		return this.movies;
//	}
//
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}
//
//}
package neu.cs5200.movieTv.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import neu.cs5200.movieTv.group.DisGroup;


@NamedQueries({	
	@NamedQuery(name = "User.findByUsernameAndPassword", 
				query="select u from User u where u.username = :username and u.password = :password"),
	@NamedQuery(name = "User.findByUsername", 
				query="select u from User u where u.username = :username"),
	@NamedQuery(name = "User.findAll", 
				query="select u from User u")
	})

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<User2Movie> user2movies;
	
	@OneToMany(mappedBy="user")
	private List<DisGroup> groups;

	
	public User() {
		super();
	}


	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<User2Movie> getUser2movies() {
		return user2movies;
	}


	public void setUser2movies(List<User2Movie> user2movies) {
		this.user2movies = user2movies;
	}
	
	
}