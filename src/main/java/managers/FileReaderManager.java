package managers;

import dataProvider.PostDataReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static PostDataReader jsonDataReader;
	
	private FileReaderManager() {
	}
	
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
	 
 
	 public PostDataReader getJsonReader(){
		 return (jsonDataReader == null) ? new PostDataReader() : jsonDataReader;
	}
}