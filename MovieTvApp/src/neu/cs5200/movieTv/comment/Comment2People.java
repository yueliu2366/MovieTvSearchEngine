package neu.cs5200.movieTv.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name = "cp.findCommentsByPid", 
query="select cp.comment from Comment2People cp where cp.pId = :pId"),
})


@Entity
public class Comment2People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="CID")
	private Comment comment;
	private String pId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Comment2People(Comment comment, String pId) {
		super();
		this.comment = comment;
		this.pId = pId;
	}
	public Comment2People() {
		super();
	}
}
