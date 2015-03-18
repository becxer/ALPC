import java.io.File;

class file {

	public static void main(String[] args)
	{
		
		
		File myFile = new File("C:\\MyJava");
		myFile.mkdirs();   //디렉터리를 생성하였다.
		File yourFile = new File("C:\\YourJava");
		yourFile.mkdirs();   //디렉터리를 생성하였다.
		
		File myFile1 = new File("C:\\MyJava\\picapica.txt");
		File yourFile1 = new File("C:\\YourJava\\picapica.txt");
		
		myFile1.renameTo(yourFile1);  //myJava폴더에 있던 picapica 라는 이름의 메모장을 YourJava폴더로 옴겼다.
		
	
		File[] files = yourFile.listFiles();  //파일리스트배열
		

		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			System.out.println(count+1 + " = " + files[i].getName() );            //폴더안에 있는 전체파일목록 출력
			count++;
		
		}
		
		System.out.println("\n\n");
		
		
		
		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			if(files[i].getName().endsWith(".txt")) // 메모장파일만을 골라내서 출력한다.
			{
				System.out.println(count+1 + " = " + files[i].getName() );
				count++;
			
			
			}
		}
		System.out.println("\n\n");
		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{ 
			if(files[i].getName().endsWith(".docx"))               //워드파일은 삭제!
			{
				files[i].delete();
			}
			
			
		}
		System.out.println("\n\n");

		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			System.out.println(count+1 + " = " + files[i].getName() );            //폴더안에 있는 전체파일목록 출력
			count++;
		
		}
		
	
	}
	
}
