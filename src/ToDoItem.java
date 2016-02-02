
public class ToDoItem {

	private String toDoItem;
	
	public ToDoItem(String i) {
		toDoItem = i;
	}

	public String getToDoItem() {
		return toDoItem;
	}

	public void setToDoItem(String toDoItem) {
		this.toDoItem = toDoItem;
	}

	@Override
	public String toString() {
		return toDoItem;
	}
	
	
}
