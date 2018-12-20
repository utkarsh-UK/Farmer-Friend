import java.sql.*;

import javax.swing.JOptionPane;
public class WorkerDB {
		Connection conn=null;
		public static Connection dbConnector()
		{
			try {
				Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\WorkerDb.accdb");
				//JOptionPane.showMessageDialog(null,"Data Saved..!!");
				return conn;
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
				return null;
			}
		}
		public static Connection dbCrop(){
			try{
				Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\CropInfo.accdb");
				return conn;
			} catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
				return null;
			
		}
		}
}
