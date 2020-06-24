package MavenProject;

import java.io.File;  
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JdbcToJava {

	private static final String StringEscapeutils = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=null;
JSONArray ja=new JSONArray();
ArrayList<CustomerDetails> a=new ArrayList<CustomerDetails>();

conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business2", "root", "mysql");


Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("select * from CustomerInfo where location= 'Asia' and PurchasedDate=curdate();");
while(rs.next())
{
	CustomerDetails c= new CustomerDetails();
	c.setCourseName(rs.getString(1));
	c.setPurchaseDate(rs.getString(2));
	c.setAmount(rs.getInt(3));
	c.setLocation(rs.getString(4));
	a.add(c);
	/*System.out.println(c.getCourseName());
	System.out.println(c.getPurchaseDate());
	System.out.println(c.getAmount());
	System.out.println(c.getLocation());*/
}


for(int i=0;i<a.size();i++){
	ObjectMapper o=new ObjectMapper();
	o.writeValue(new File("C:\\Users\\Monali_PC\\workspace\\Jsonjava\\customerInfo"+i+".json"),a.get(i));
	/*Gson g=new Gson();
	String jsonString=g.toJson(a.get(i));
	ja.add(jsonString);*/ 
	
}
//convort java object to json string


//single json
JSONObject jo=new JSONObject();
jo.put("data", ja);
System.out.println(jo.toJSONString());
/*String unescapesting=StringEscapeUtils.unescapeJava(jo.toJSONString());
System.out.println(unescapesting);
String string1=unescapesting.replace("\"{","{");
String finalstring=string1.replace("}/", "}");
System.out.println(finalstring);*/

/*ja.add(1stindax data )
ja.add(2ndindax data )
ja.add(3rdindax data )*/ 

conn.close();
	}
}












/*try {
	 
    // Constructs a FileWriter given a file name, using the platform's default charset
    file = new FileWriter("/Users/Shared/crunchify.txt");
    file.write(obj.toJSONString());
    CrunchifyLog("Successfully Copied JSON Object to File...");
    CrunchifyLog("\nJSON Object: " + obj);*/

