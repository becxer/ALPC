
public class Launcher {

	public static void main(String[] args){
		
		ItemManager item_mng = new ItemManager();// �ϳ��ǻ�ǰ(����) ������ ����
		
		HomepageReader hp_thread = new HomepageReader(item_mng);// Ȩ������ �о���� ���
		
		ShowItems si_thread = new ShowItems(item_mng);// �����ֱ���
		
		ItemSearch item_search = new ItemSearch(item_mng);// �˻����
		
		Gui gui = new Gui(item_mng, item_search);//GUI
		
		
		hp_thread.start();
		si_thread.start();
		
		gui.jFrame();
		
		
	}
}

//----��ü���� �����
//1. Waterfall (UML, Class diagram)
//2. Refactoring 

//----- ��ü���� ���ϴ¹�
//1. �ϳ��� ��ü�� �ϳ��� ��ɸ� �Ѵ�.
//2. ū����� �߰� �ɰ���.


