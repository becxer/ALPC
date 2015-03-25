import java.util.ArrayList;


class ItemManager {
	boolean isItem=false; //Template의 개념에 대해서 공부해보기.
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
