package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import dataType.Post;;

public class PostDataReader {
	private final String postFilePath = "/home/jerry/workspace/Demo/src/testData/post.json";
	private List<Post> postList;
	
	public PostDataReader(){
		postList = getPostData();
	}
	
	public List<Post> getPostData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(postFilePath));
			Post[] posts = gson.fromJson(bufferReader, Post[].class);
			return Arrays.asList(posts);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + postFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Post getPostById(int id){
			 return postList.stream().filter(x -> x.id == id).findAny().get();
	}
	
}