//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * DatabaseTest.java
 * 
 * Provides JUnit 5 unit tests for the Database.java files, particularly those that take parameters
 */
package ServerCommunication;

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
		
	}
	@Test 
	public void testQueryFail()
	{
		
	}
	@Test
	public void testexecuteDMLSuccess()
	{
		
	}
	@Test
	public void testexecuteDMLFail()
	{
		
	}
	@Test
	public void testcreateAccountSuccess()
	{
		
	}
	@Test
	public void testcreateAccountFail()
	{
		
	}
	@Test
	public void testverifyAccountSuccess()
	{
		
	}
	@Test
	public void testverifyAccountFail()
	{
		
	}
	@Test
	public void testgetUserRatioSuccess()
	{
		
	}
	@Test
	public void testgetUserRatioFail()
	{
		
	}
	@Test
	public void testrecordMatchSuccess()
	{
		
	}
	@Test
	public void testgetrecordMatchFail()
	{
		
	}
	@After
	public void tearDown() 
	{
		db.finish();
	}

}
