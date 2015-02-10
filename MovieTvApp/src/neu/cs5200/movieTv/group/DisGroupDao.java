package neu.cs5200.movieTv.group;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import neu.cs5200.movieTv.movie.PopularMovie;
import neu.cs5200.movieTv.user.Member;
import neu.cs5200.movieTv.user.MemberDao;


public class DisGroupDao {
	//Read configuration info from persistence.xml
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movieTvApp");	
	EntityManager ma = null;
	
	//constructor
	public DisGroupDao() {
		ma = factory.createEntityManager();
	}

	public void createGroup(DisGroup newGroup) {
		ma.getTransaction().begin();
		ma.persist(newGroup);
		ma.getTransaction().commit();
	}
	
	public List<DisGroup> findAllGroup() {
		ma.getTransaction().begin();
		
		Query q = ma.createNamedQuery("group.findAll");
		List<DisGroup> groups = q.getResultList();
		
		ma.getTransaction().commit();
		
		return groups;
	}
	
	public List<DisGroup> findGroupByCreator(long userId) {
		ma.getTransaction().begin();
		
		Query q = ma.createNamedQuery("group.findByCreator");
		q.setParameter("userId", userId);
		List<DisGroup> groups = q.getResultList();
		
		ma.getTransaction().commit();
		
		return groups;
	}
	
	public DisGroup findGroupByMovieId (long movieId) {
		ma.getTransaction().begin();
		
		Query q = ma.createNamedQuery("group.findByMovie");
		q.setParameter("movieId", movieId);
		DisGroup group = (DisGroup) q.getSingleResult();	
		ma.getTransaction().commit();
		
		return group;
	}

	public DisGroup findGroupByGroupId (int groupId) {
		ma.getTransaction().begin();	
		DisGroup group = ma.find(DisGroup.class, groupId);
		ma.getTransaction().commit();
		return group;
	}
	
	public void removeGroup(int groupId) {
		DisGroup g = ma.find(DisGroup.class, groupId);
		ma.remove(groupId);			
		ma.getTransaction().commit();		
	}
	
	public void addGroupMember(int groupId, Member m) {
		ma.getTransaction().begin();
		DisGroup group = ma.find(DisGroup.class, groupId);
		List<Member> members = group.getMembers();
		members.add(m);
		group.setMembers(members);
		ma.merge(group);		
		ma.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		DisGroupDao dao = new DisGroupDao();
//		System.out.println(dao.findAllGroup());
//		System.out.println(dao.findGroupByCreator(1));

//		MemberDao mdao = new MemberDao();
//		Member m = mdao.findMemberById(1);
		
//		DisGroup g = dao.findGroupByGroupId(4);
//		List<Member> ms = g.getMembers();
		
//		System.out.println(m);
	}

}
