import java.util.Scanner;


public class Launcher {

	public static void main(String[] args) {
		int sel;
		//String urlAddress=null;
		Scanner sc = new Scanner(System.in);
		
		ItemManager item_mng = new ItemManager();// �ϳ��ǻ�ǰ ������ ����
		HomepageReader hp_reader = new HomepageReader(item_mng); // Ȩ������ �о����
		ItemSearch item_search = new ItemSearch(item_mng);// �˻����
		ShowItems show_item = new ShowItems(item_mng);// �����ֱ�.
		
		hp_reader.homepageReading();
		show_item.titleShowing();
		item_search.searchWord();
		
		
		/*System.out.println("---�޴�---");
		System.out.println("1.URL�ּ��Է�");
		System.out.println("2.�˻�");
		System.out.println("3.�����ֱ�");
		
		sel = sc.nextInt();
		switch(sel){
		case 1:
			System.out.println("URL�ּҸ� �Է� �ϼ���");
			urlAddress = sc.nextLine();

			break;
		case 2:
			HomepageReader hp_reader = new HomepageReader(item_mng,urlAddress); 
			hp_reader.homepageReading();
			System.out.println("�˻� :");
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

//----��ü���� �����
//1. Waterfall (UML, Class diagram)
//2. Refactoring 

//----- ��ü���� ���ϴ¹�
//1. �ϳ��� ��ü�� �ϳ��� ��ɸ� �Ѵ�.
//2. ū����� �߰� �ɰ���.


//Ư�����ڰ� &quot, &gt�� ���ɴϴ�.