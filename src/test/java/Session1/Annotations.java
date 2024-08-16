package Session1;

import org.testng.annotations.*;

public class Annotations {

    @BeforeSuite
    public void BeforeSuite()
    {
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void BeforeTest()
    {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Before Method");
    }
    @Test
    public void testCase1()
    {
        System.out.println("Test Case 1");
    }
    @Test
    public void testCase2()
    {
        System.out.println("Test Case 2");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("After Test");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After Method");
    }

}
