//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * DatabaseTest.java
 * 
 * Provides JUnit 5 unit tests for the Database.java files, particularly those that take parameters
 */

package ServerCommunication;

import static org.junit.Assert.*;

import org.junit.*; //Needed for tests

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
	@Test 
	public void testQueryFail()
	{
		//assertNotNull(db.query("select * from gamers"));
	}
	@Test
	public void testexecuteDMLSuccess()
	{
		assert(db.executeDML("insert into users values('yourmom',aes_encrypt('yourmomspw', 'midnightexigent'),0,0);"));
		assert(db.executeDML("delete from users where username='yourmom';"));
	}
	@Test
	public void testexecuteDMLFail()
	{
		//assert(db.executeDML("insert into gamers values('yourmom',aes_encrypt('yourmomspw', 'midnightexigent'),0,0);"));
	}
	@Test
	public void testcreateAccountSuccess()
	{
		assert(db.createAccount("yourmom", "yourmomspw"));
		assert(db.executeDML("delete from users where username='yourmom';"));
	}
	@Test
	public void testcreateAccountFail()
	{
		//assert(db.createAccount("yourmom", "yourmomspwbuttoolong"));
	}
	@Test
	public void testverifyAccountSuccess()
	{
		assert(db.verifyAccount("Holden", "Davis13"));
	}
	@Test
	public void testverifyAccountFail()
	{
		//assert(db.verifyAccount("yourmom", "yourmompw"));
	}
	@Test
	public void testgetUserRatioSuccess()
	{
		assertNotNull(db.getUserRatio("Holden"));
	}
	@Test
	public void testgetUserRatioFail()
	{
		//assertNotNull(db.getUserRatio("yourmom"));
	}
	@Test
	public void testgetAllUsersSuccess()
	{
		assertNotNull(db.getAllUsers());
	}
	@Test
	public void testgetAllUsersFail()
	{
		//assert???(db.getAllUsers());
	}
	@Test
	public void testrecordMatchSuccess()
	{
		db.recordMatch("Holden", "Austin", false);
	}
	@Test
	public void testrecordMatchFail()
	{
		//db.recordMatch("your", "mom", true);
	}
	@After
	public void tearDown() 
	{
		db.finish();
	}

}
