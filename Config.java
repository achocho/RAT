import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Config {

	public static void main(String[] args) throws Exception {
		boolean form=true;
		Scanner scan=new Scanner(System.in);
		while(form) {
			System.out.println("Register!!");
			String name=scan.nextLine();
			if(name.length()<4||name.length()>15) 
			{
				System.out.println("Min length =4,Max length =15");
				continue;
				
			}
		String id=Id(name);
		Server sr=new Server();
		Client cl=new Client();
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		whatismyip.openStream()));
	


		String ip = in.readLine(); 
		Connection conn=conn();
if(Exist(id,conn)==0) {
	
		sr.WriteServerProperty(id);
		cl.WriteClientProperty(id);
		InsertIntoIds(conn,id);
		form=false;
	}

else 
{
System.out.println("The client exists!!!");
continue;
}
	
}
		Path file=Files.copy(Paths.get("Client.exe"),Paths.get("Clients\\Client.exe"));

	}
	public static String Id(String name) throws Exception{
		
		
		  String id="";
       try {
	
     
      
  
        for(int i=0;i<name.length();i++) 
        {
        	id+=(int)name.charAt(i)*(int)name.charAt(i)/2;
        	
        }
     
       }catch(Exception e) 
       {
    	   System.out.println(e.getMessage());
    	   
       }
       return id;
	}
	public static int Exist(String id,Connection conn) throws Exception
	{
		
		 String sql1 = "SELECT COUNT(*) FROM ids Where id ="+"'"+id+"'";
			PreparedStatement statement = null;
		    ResultSet resultSet = null;
		    statement = conn.prepareStatement(sql1);
		    resultSet = statement.executeQuery();
		    int out=0;
		    if(resultSet.next()) {
		      out=resultSet.getInt(1);
		 
		  
		    }
		return out;	
		
	}
    public static void InsertIntoIds(Connection conn,String id) throws Exception
    {
    	PreparedStatement ps=conn.prepareStatement("insert into ids values(?)");
    	ps.setString(1, id);
    	ps.executeUpdate();
    }
    public static Connection conn() throws Exception
    {
    	Connection conn = null;
		String url = "jdbc:mysql://18.188.255.221:3306/";
		String dbName = "java";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "acho";
		String password = "1234";
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url+dbName,userName,password);
		return conn;
    	
    }
}
