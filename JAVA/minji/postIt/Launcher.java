import java.io.IOException;
import java.util.Scanner;


public class Launcher {

	public static void main(String[] ar) throws IOException{
		
		// 포스트잇 생성하기
		PostItManager post_mng = new PostItManager();
		while(true){
			System.out.println("1. 동기화 2. 파일 생성 3. 삭제 4. 종료");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1)			//파일 불러오기 
				post_mng.loadFile();
			else if(choice == 2){	//파일 저장하기
				System.out.println("파일 이름 입력하세요");
				String title = sc.next();
				sc.nextLine();
				System.out.println("파일 내용 입력하세요");
				String content = sc.nextLine();
				
				post_mng.storePostit(title, content);
			}
			else if(choice == 3){
				System.out.println("삭제할 파일 제목 ㄱㄱ");
				String title = sc.next();
				post_mng.deletePostit(title);
			}
			else
				break;
		}
			
		
		// 동기화 하기 (네트워크)
		
		// 삭제하기
		
		// GUI
		
		// 파일저장하기		*완료*
		
		// 파일불러오기		*완료*
		
		
	}
}


//객체지향 잘짜는법
//1. 1클래스는 1개의 기능만
//2. 큰기능은 잘게 잘게 잘게 잘게 쪼갠다.

