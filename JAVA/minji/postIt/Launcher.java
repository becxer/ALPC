import java.io.IOException;
import java.util.Scanner;


public class Launcher {

	public static void main(String[] ar) throws IOException{
		
		// ����Ʈ�� �����ϱ�
		PostItManager post_mng = new PostItManager();
		while(true){
			System.out.println("1. ����ȭ 2. ���� ���� 3. ���� 4. ����");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1)			//���� �ҷ����� 
				post_mng.loadFile();
			else if(choice == 2){	//���� �����ϱ�
				System.out.println("���� �̸� �Է��ϼ���");
				String title = sc.next();
				sc.nextLine();
				System.out.println("���� ���� �Է��ϼ���");
				String content = sc.nextLine();
				
				post_mng.storePostit(title, content);
			}
			else if(choice == 3){
				System.out.println("������ ���� ���� ����");
				String title = sc.next();
				post_mng.deletePostit(title);
			}
			else
				break;
		}
			
		
		// ����ȭ �ϱ� (��Ʈ��ũ)
		
		// �����ϱ�
		
		// GUI
		
		// ���������ϱ�		*�Ϸ�*
		
		// ���Ϻҷ�����		*�Ϸ�*
		
		
	}
}


//��ü���� ��¥�¹�
//1. 1Ŭ������ 1���� ��ɸ�
//2. ū����� �߰� �߰� �߰� �߰� �ɰ���.

