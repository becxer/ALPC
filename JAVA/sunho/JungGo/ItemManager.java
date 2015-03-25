import java.util.ArrayList;


class ItemManager {
	boolean isItem=false; //Template�� ���信 ���ؼ� �����غ���.
	ArrayList<String> title_list = new ArrayList<String>();
	
	public void saveItem(String title){
		title_list.add(title);
		
		synchronized(this){
			notifyAll();
		}
			
		
	}
	
	public String getItem(int num){
		if(isItem==false){
			try
			{
				synchronized (this) {
					wait();
					
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
		return title_list.get(num-1);
	}
	
}
