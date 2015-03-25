
public class Launcher {

	public static void main(String[] args){
		
		ItemManager item_mng = new ItemManager();// 하나의상품 단위로 관리
		
		HomepageReader hp_thread = new HomepageReader(item_mng);// 홈페이지 읽어오기
		
		ShowItems si_thread = new ShowItems(item_mng);// 보여주기
		
		ItemSearch item_search = new ItemSearch(item_mng);// 검색기능
		//Gui gui = new Gui(item_mng);
		
		hp_thread.start();
		si_thread.start();
		item_search.searchWord();
		
	}
}

//----객체지향 설계법
//1. Waterfall (UML, Class diagram)
//2. Refactoring 

//----- 객체지향 잘하는법
//1. 하나의 객체는 하나의 기능만 한다.
//2. 큰기능은 잘게 쪼갠다.


