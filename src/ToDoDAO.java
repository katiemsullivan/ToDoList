import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToDoDAO {

	ArrayList<ToDoItem> arrayList = new ArrayList<ToDoItem>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public ToDoDAO() {
		makeConnection();
		
		try {
			String q = "SELECT * from todolist";
			st = con.createStatement();
			rs = st.executeQuery(q);
			
			while (rs.next()) {
				String tempItem = rs.getString(1);
				
				ToDoItem e = new ToDoItem(tempItem);
				arrayList.add(e);
			}
			
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error with table or data.");
		}
	}
	
	public void makeConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/todo";
		String user = "root";
		String password = "password";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
		} catch (Exception ex){
			Logger lgr = Logger.getLogger(ToDoDAO.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("SQL Exception");
		}
	}
	
	public void addNewItem(ToDoItem i) {
		makeConnection();
		
		try {
			String q = "insert into todolist (item) values" + " ('" + i.getToDoItem() + "');";
			
			st = con.createStatement();
			st.executeUpdate(q);

			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error with table or data.");
		}
	}
	
	public void removeItem(ToDoItem i) {
		makeConnection();
		
		try {
			String q = "delete from todolist where (item) =" + " ('" + i.getToDoItem() + "');";
			
			st = con.createStatement();
			st.executeUpdate(q);

			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			System.out.println("Error with table or data.");
		}
	}
	
	public String getCurrentToDoList(String s) {
		String str = "";
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getToDoItem().equals(s)) {
				str += "\n";
			}
		}
		
		return str;
	}
 }
