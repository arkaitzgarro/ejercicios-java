package com.arkaitzgarro.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.arkaitzgarro.hibernate.model.Actor;
import com.arkaitzgarro.hibernate.repository.abstracts.BaseJPARepository;
import com.arkaitzgarro.hibernate.util.JPAHelper;

public class ActorRepository extends BaseJPARepository<Actor, Long> {

	public List<Actor> findByStr(String str) {
		List<Actor> list = null;

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager em = factoriaSession.createEntityManager();

		try {
			TypedQuery<Actor> query = em
					.createQuery(
							"SELECT a FROM Actor a WHERE a.firstName LIKE :str OR a.lastName LIKE :str",
							Actor.class);

			query.setParameter("str", "%" + str + "%");
			list = (List<Actor>) query.getResultList();
		} finally {
			em.close();
		}

		return list;
	}
}
