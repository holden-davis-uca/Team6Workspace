//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * DatabaseTest.java
 * 
 * Provides JUnit 5 unit tests for the Database.java files, particularly those that take parameters
 */

package Tests;

import static org.junit.Assert.*; //Needed for non-null assertions
import org.junit.*; //Needed for tests

import ServerCommunication.Database;

public class DatabaseTest {
	
	private Database db;

	@Before
	public void setUp()
	{
		db = new Database();
	}
	@Test
	public void testQuerySuccess()
	{
		assertNotNull(db.query("select * from users"));
	}
	@Test (expected=AssertionError.class)
	public void testQueryFail()
	{
		assertNotNull(db.query("select * from gamers"));
	}
	@Test
	public void testexecuteDMLSuccess()
	{
		assert(db.executeDML("insert into users values('test',aes_encrypt('testspw', 'midnightexigent'),0,0);"));
		assert(db.executeDML("delete from users where username='test';"));
	}
	@Test (expected=AssertionError.class)
	public void testexecuteDMLFail()
	{
		assert(db.executeDML("insert into gamers values('test',aes_encrypt('testspw', 'midnightexigent'),0,0);"));
	}
	@Test
	public void testcreateAccountSuccess()
	{
		assert(db.createAccount("test", "testspw"));
		assert(db.executeDML("delete from users where username='test';"));
	}
	@Test (expected=AssertionError.class)
	public void testcreateAccountFail()
	{
		assert(db.createAccount("test", "testspwbuttoolong"));
	}
	@Test
	public void testverifyAccountSuccess()
	{
		assert(db.verifyAccount("Holden", "Davis13"));
	}
	@Test (expected=AssertionError.class)
	public void testverifyAccountFail()
	{
		assert(db.verifyAccount("test", "testpw"));
	}
	@Test
	public void testgetUserRatioSuccess()
	{
		assertNotEquals(db.getUserRatio("Holden"), "");
	}
	@Test (expected=AssertionError.class)
	public void testgetUserRatioFail()
	{
		assertNotEquals(db.getUserRatio("test"), "");
	}
	@Test
	public void testgetAllUsersSuccess()
	{
		assertNotNull(db.getAllUsers());
	}
	@Test (expected=NullPointerException.class)
	public void testgetAllUsersFail()
	{
		db.finish();
		db.getAllUsers();
		setUp();
	}
	@Test
	public void testrecordMatchSuccess()
	{
		db.recordMatch("Holden", "Austin", false);
	}
	@Test
	public void testrecordMatchFail()
	{
		db.finish();
		db.recordMatch("ffffffffffffffffffffffffffffyour", "mom", true);
		setUp();
	}
	@After
	public void tearDown() 
	{
		db.finish();
	}

}
