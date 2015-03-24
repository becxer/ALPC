import java.util.Scanner;


public class Launcher {

	public static void main(String[] args) {
		int sel;
		//String urlAddress=null;
		Scanner sc = new Scanner(System.in);
		
		ItemManager item_mng = new ItemManager();// 하나의상품 단위로 관리
		HomepageReader hp_reader = new HomepageReader(item_mng); // 홈페이지 읽어오기
		ItemSearch item_search = new ItemSearch(item_mng);// 검색기능
		ShowItems show_item = new ShowItems(item_mng);// 보여주기.
		
		hp_reader.homepageReading();
		show_item.titleShowing();
		item_search.searchWord();
		
		
		/*System.out.println("---메뉴---");
		System.out.println("1.URL주소입력");
		System.out.println("2.검색");
		System.out.println("3.보여주기");
		
		sel = sc.nextInt();
		switch(sel){
		case 1:
			System.out.println("URL주소를 입력 하세요");
			urlAddress = sc.nextLine();

			break;
		case 2:
			HomepageReader hp_reader = new HomepageReader(item_mng,urlAddress); 
			hp_reader.homepageReading();
			System.out.println("검색 :");
			String search_word = sc.nextLine();
			ItemSearch item_search = new ItemSearch(item_mng);
			item_search.searchWord(search_word);
			break;
		case 3:
			ShowItems show_item = new ShowItems(item_mng);
			show_item.titleShowing();
			break;
		}/*
		
		/*HomepageReader hp_reader = new HomepageReader(item_mng); 
		
		
		
		
		hp_reader.homepageReading();
		show_item.titleShowing();
		item_search.searchWord();*/
	}
}

//----객체지향 설계법
//1. Waterfall (UML, Class diagram)
//2. Refactoring 

//----- 객체지향 잘하는법
//1. 하나의 객체는 하나의 기능만 한다.
//2. 큰기능은 잘게 쪼갠다.


//특수문자가 &quot, &gt로 나옵니다.