package neu.cs5200.movieTv.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import neu.cs5200.movieTv.group.DisGroup;




public class MemberDao {
	//Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movieTvApp");	
	EntityManager ma = null;
	
	//constructor
	public MemberDao() {
		ma = factory.createEntityManager();
	}
	
	public void createMember(Member newMember) {
		ma.getTransaction().begin();
		ma.persist(newMember);
		ma.getTransaction().commit();
	}
	
	public Member findMemberById (long userId) {
		ma.getTransaction().begin();	
		
		Query q = ma.createNamedQuery("mb.findById");
		q.setParameter("userId", userId);
		Member m = (Member) q.getSingleResult();
		
		//Member m = ma.find(Member.class, userId);
		ma.getTransaction().commit();
		return m;
	}
	
	public List<Member> findAll () {
		ma.getTransaction().begin();	
		
		Query q = ma.createNamedQuery("mb.findAll");
		List<Member> ms = q.getResultList();
		
		ma.getTransaction().commit();
		return ms;
	}
	
	
	public static void main(String[] args) {
		MemberDao mdao = new MemberDao();
		System.out.println(mdao.findAll());
	}
}
