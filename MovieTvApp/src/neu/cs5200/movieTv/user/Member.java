package neu.cs5200.movieTv.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import neu.cs5200.movieTv.group.DisGroup;

@NamedQueries({
	@NamedQuery(name = "mb.findById", 
				query="select m from Member m where m.id = :userId"),
	@NamedQuery(name = "mb.findAll", 
				query="select m from Member m")
})

@Entity
public class Member extends User{
	private String nikeName;
	
	@ManyToMany
	@JoinTable(name="GROUP2MEMBER", 
			   joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
		       inverseJoinColumns={@JoinColumn(name="GROUP_ID", referencedColumnName="ID")})
	private List<DisGroup> groups;

	
	public Member() {
		super();
	}
	
	
//	public Member(List<DisGroup> groups) {
//		super();
//		this.groups = groups;
//	}


	public Member(String nikeName) {
		super();
		this.nikeName = nikeName;
	}


	public String getNikeName() {
		return nikeName;
	}


	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	
}
