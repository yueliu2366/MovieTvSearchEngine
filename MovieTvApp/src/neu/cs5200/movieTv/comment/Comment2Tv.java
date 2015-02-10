package neu.cs5200.movieTv.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name = "ct.findCommentsBytid", 
query="select ct.comment from Comment2Tv ct where ct.tId = :tId"),
})

@Entity
public class Comment2Tv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="CID")
	private Comment comment;
	private String tId;
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
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public Comment2Tv(Comment comment, String tId) {
		super();
		this.comment = comment;
		this.tId = tId;
	}
	public Comment2Tv() {
		super();
	}
	
	
	
}
