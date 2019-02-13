package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository acc;

	private static final String MOCK_OBJECT1 = "{\"id\":1,\"account_number\":\"12\",\"first_name\":\"Jamie\",\"last_name\":\"d\"}";
	private static final String MOCK_OBJECT2 = "{\"id\":2,\"account_number\":\"12\",\"first_name\":\"John\",\"last_name\":\"d\"}";
	private static final String MOCK_OBJECT3 = "{\"id\":3,\"account_number\":\"12\",\"first_name\":\"John\",\"last_name\":\"d\"}";
	private static final String MOCK_OBJECT4 = "{\"id\":4,\"account_number\":\"12\",\"first_name\":\"George\",\"last_name\":\"d\"}";

	@Before
	public void setup() {
		acc = new AccountMapRepository();

	}

	@Test
	public void addAccountTest() {
		String reply = acc.createAccount(MOCK_OBJECT1);
		Assert.assertEquals(reply, "Account Created");
	}

	// Write a new feature that cycles through your accounts and looks for all
	// account by a given first name
	// For the given name a count should be incremented to work out the amount of
	// accounts with the given first name
	// Finally this total should be printed to the standard system out.

	@Test
	@Ignore
	public void add2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void removeAccountTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	@Ignore
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		Assert.assertEquals(0, acc.checkName("James"));

	}

	@Test

	public void getCountForFirstNamesInAccountWhenOne() {

		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		Assert.assertEquals(1, acc.checkName("John"));
	}

	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenTwo() {
		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		String input3 = acc.createAccount(MOCK_OBJECT3);
		String input4 = acc.createAccount(MOCK_OBJECT4);
		Assert.assertEquals(2, acc.checkName("John"));
	}

}
