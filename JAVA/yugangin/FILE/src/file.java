import java.io.File;

class file {

	public static void main(String[] args)
	{
		
		
		File myFile = new File("C:\\MyJava");
		myFile.mkdirs();   //���͸��� �����Ͽ���.
		File yourFile = new File("C:\\YourJava");
		yourFile.mkdirs();   //���͸��� �����Ͽ���.
		
		File myFile1 = new File("C:\\MyJava\\picapica.txt");
		File yourFile1 = new File("C:\\YourJava\\picapica.txt");
		
		myFile1.renameTo(yourFile1);  //myJava������ �ִ� picapica ��� �̸��� �޸����� YourJava������ �Ȱ��.
		
	
		File[] files = yourFile.listFiles();  //���ϸ���Ʈ�迭
		

		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			System.out.println(count+1 + " = " + files[i].getName() );            //�����ȿ� �ִ� ��ü���ϸ�� ���
			count++;
		
		}
		
		System.out.println("\n\n");
		
		
		
		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			if(files[i].getName().endsWith(".txt")) // �޸������ϸ��� ��󳻼� ����Ѵ�.
			{
				System.out.println(count+1 + " = " + files[i].getName() );
				count++;
			
			
			}
		}
		System.out.println("\n\n");
		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{ 
			if(files[i].getName().endsWith(".docx"))               //���������� ����!
			{
				files[i].delete();
			}
			
			
		}
		System.out.println("\n\n");

		for(int i=0 ,count = 0 ; i<files.length ; i++)
		{
			System.out.println(count+1 + " = " + files[i].getName() );            //�����ȿ� �ִ� ��ü���ϸ�� ���
			count++;
		
		}
		
	
	}
	
}
