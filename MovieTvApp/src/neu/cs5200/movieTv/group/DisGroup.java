package neu.cs5200.movieTv.group;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import neu.cs5200.movieTv.user.Member;
import neu.cs5200.movieTv.user.User;

@NamedQueries({
	@NamedQuery(name = "group.findAll", 
	query="select g from DisGroup g"),			
	
	@NamedQuery(name = "group.findByCreator", 
	query="select g from DisGroup g inner join g.user u where u.id = :userId"),
	
	@NamedQuery(name = "group.findByMovie", 
	query="select g from DisGroup g where g.movieId = :movieId")
})


@Entity
public class DisGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private long movieId;

	@ManyToOne
	@JoinColumn(name="CREATED")
	private User user;

	@ManyToMany
	@JoinTable(name="GROUP2MEMBER", 
			   joinColumns={@JoinColumn(name="GROUP_ID", referencedColumnName="ID")},
		       inverseJoinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")})
	private List<Member> members;
	

	public DisGroup() {
		super();
	}


	public DisGroup(String name, long movieId, User user) {
		super();
		this.name = name;
		this.movieId = movieId;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public long getMovieId() {
		return movieId;
	}


	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}

	
}
