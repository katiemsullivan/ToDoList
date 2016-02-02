import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListPanel extends JPanel {

		JLabel title = new JLabel("Katie's To-Do List");
		JTextField inputBox = new JTextField(25);
		JButton addButton = new JButton("add");
		JButton removeButton = new JButton("remove");
		ToDoDAO itemDAO = new ToDoDAO();
		ArrayList<ToDoItem> listModel = new ArrayList<ToDoItem>(itemDAO.arrayList);
		JList list = new JList(listModel.toArray());
		JScrollPane scroll = new JScrollPane(list);
		
		public ToDoListPanel() {
			AddButtonListener a = new AddButtonListener();
			addButton.addActionListener(a);
			RemoveButtonListener r = new RemoveButtonListener();
			removeButton.addActionListener(r);

			add(title);
			add(inputBox);
			add(addButton);
			add(scroll);
			add(removeButton);
			
		}
		
		class AddButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tempItem = inputBox.getText();
				ToDoItem t = new ToDoItem(tempItem);
				itemDAO.addNewItem(t);
				
				inputBox.setText(""); //Clears input box for next item
				System.out.println("Item added to database.");
				
				removeAll();
				JPanel newPanel = new ToDoListPanel();
				add(newPanel);
	            revalidate();
	            newPanel.repaint();
			}
			
		}
		
		class RemoveButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if (index != -1) { //negative 1 is when nothing is selected
					ToDoItem tempItem = listModel.get(index);
					itemDAO.removeItem(tempItem);
					
					listModel.remove(index);
					list.setListData(listModel.toArray());
					System.out.println("Item removed from database.");
				}
		
				removeAll();
				JPanel newPanel = new ToDoListPanel();
				add(newPanel);
	            revalidate();
	            newPanel.repaint();
			}
			
		}
}
