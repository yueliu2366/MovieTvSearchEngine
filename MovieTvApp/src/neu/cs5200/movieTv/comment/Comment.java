package neu.cs5200.movieTv.comment;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import neu.cs5200.movieTv.comment.Comment2User;

@Entity
@Table(name="MYCOMMENT")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	private String content;
	@OneToMany(mappedBy = "comment")
	private List<Comment2User> comment2User;
	
	@OneToMany(mappedBy = "comment")
	private List<Comment2People> comment2People;
	
	@OneToMany(mappedBy = "comment")
	private List<Comment2Tv> comment2Tv;
	

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Comment2User> getComment2User() {
		return comment2User;
	}
	public void setComment2User(List<Comment2User> comment2User) {
		this.comment2User = comment2User;
	}
	public Comment(String content) {
		super();
		this.content = content;
	}
	public Comment() {
		super();
	}
}
