import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToDoList {

	public static void main(String[] args) {
		
		JFrame main = new JFrame();
		JPanel mainPanel = new ToDoListPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		main.add(mainPanel);
		main.setSize(600, 400);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);

	}

}
