package stepDefination;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProvider.GetPageContent;
import dataType.Post;
import managers.FileReaderManager;

public class SimpleDemo {
	
	@Test
	public void testExtractPageContent() {
		GetPageContent getPageContent = new GetPageContent();
		Assert.assertTrue(getPageContent.getContent());
	}
	
	@Parameters("id")
	@Test(dependsOnMethods={"testExtractPageContent"})
	public void testVerify5Comments(int testId){
		String actuallineResult;
		Post post = FileReaderManager.getInstance().getJsonReader().getPostById(testId);
		actuallineResult = post.getBody();
   	    String[] lines = actuallineResult.split("\r\n|\r|\n");
		//System.out.println(lines.length);
		Assert.assertEquals(lines.length, 5);
		
  }

	@Parameters("id")
	@Test(dependsOnMethods={"testExtractPageContent"})
	public void testVerifyBody(int testId){
		String actualbodyResult;
		String expectedbodyResult;		
		Post post = FileReaderManager.getInstance().getJsonReader().getPostById(testId);
		
		actualbodyResult = post.getBody();
		expectedbodyResult = "veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla";
		System.out.println(expectedbodyResult);
		Assert.assertEquals(actualbodyResult, expectedbodyResult);
		
  }	
}
