package Userdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//
//import Dto.Customerdto;
import Userdto.Userdto;

public class Userdao {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
EntityManager em=emf.createEntityManager();
EntityTransaction t=em.getTransaction();

	public void save(Userdto dto){
		t.begin();
		em.persist(dto);
		t.commit();
	}
	public List<Userdto> find(long phoneno) {
		return em.createQuery("select x from Userdto x where phoneno=?1").setParameter(1, phoneno).getResultList();
	}

	public List<Userdto> find(String email) {
		return em.createQuery("select x from Userdto x where email=?1").setParameter(1, email).getResultList();
	}
	public Userdto find(int cid) {
		return em.find(Userdto.class,cid);
	}

	
}
