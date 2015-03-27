
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.PriorityQueue;

//파일찾기
public class Matcher {
	
	//String[] fileToDelete = {".tmp",".log"}; //찾으면서 지운다.
	//String[] dirToDelete = {"C:\temp"}; //다지운다.
	
	/*public String[] findFiles(){
		
		File searchFile  = new File("C:\\");
		
	 
		
		String[] result =null;
		
	
		
		return result;
	}*/
	
   
    ArrayList<File> fileList = new ArrayList<File>();
    PriorityQueue<File> queue = new PriorityQueue<File>();
	
	public void startMacth()
	{
	
		File searchFile  = new File("C:\\");
	         fileSearch(searchFile);
	       System.out.println(queue.size());
	        
	       int i =0 ;
	      while(true){   
	        	
	    	  //System.out.println(queue.poll().getAbsolutePath());
	    	i++;
	         fileSearch(queue.poll());
	       if(queue.size()==0)
	    	   break;
	      }
	 
	}
	
	
   public void fileSearch(File directory){
	   
	   
	   File[] directories = directory.listFiles(new FileFilter() {  // 폴더찾기
		
		@Override
		public boolean accept(File pathname) {
			// TODO Auto-generated method stub
			return pathname.isDirectory();
		}
	});
	   
	   
	  if(directories != null && directories.length != 0)
	  {
		  for(int i =0 ; i < directories.length ; i++)
		  {
			 
			  // fileSearch(directories[i]);
			  queue.add(directories[i]);  // recursive
			  
		  }
	  }
	
	
	   File[] files = directory.listFiles(new FileFilter() {
		
		@Override
		public boolean accept(File pathname) {
			// TODO Auto-generated method stub
			return pathname.isFile();
		}
	});
	  
	if(files !=null && files.length != 0 )
	{
		for(int i=0 ; i<files.length ; i++)
		{
			if(files[i].getName().endsWith(".docx") )
		//System.out.println(files[i].getPath() + files[i].getName());
				fileList.add(files[i]);
		}
	
	}  
	   
   }
     
}



