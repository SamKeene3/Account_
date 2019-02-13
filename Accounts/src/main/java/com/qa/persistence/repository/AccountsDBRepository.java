package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default 
public class AccountsDBRepository implements AccountRepository{
	
	
	private JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	
	@Override
	public String getAllAccounts() {
	Query query = em.createQuery("SELECT a FROM Account m ");
	Collection <Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		em.persist(account);
		return "Account Created";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		if(em.contains(em.find(Account.class, id))) {
		em.remove(em.find(Account.class, id));
		}
		return "Account Deleted";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		if (em.contains(em.find(Account.class, id ))) {
		deleteAccount(id);
		createAccount(account);
		}
		return "Account Updated";
	}

	@Override
	@Transactional(REQUIRED)
	public String FindAAccount(Long id) {
		return util.getJSONForObject(em.find(Account.class, id));
	}

}
