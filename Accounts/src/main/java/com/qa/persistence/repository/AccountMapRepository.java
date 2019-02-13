package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

import com.qa.util.*;

@Alternative 
public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	private JSONUtil util = new JSONUtil();
	private EntityManager em;

	public String getAllAccounts() {

		return util.getJSONForObject(accountMap.values());
	}

	
	public String createAccount(String account) {

		Account secondAccount = util.getObjectForJSON(account, Account.class);

		accountMap.put(secondAccount.getId(), secondAccount);

		return "Account Created";
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "Account Deleted";
	}

	public String updateAccount(Long id, String account) {

		deleteAccount(id);
		createAccount(account);

		return "Account Updated";
	}

	public int checkName(String testName) {

		return (int) accountMap.values().stream().filter(n -> n.getFirst_name().contentEquals(testName)).count();

	}


	public String FindAAccount(Long id) {
		accountMap.get(id);
		return "Account Found";
	}

}
