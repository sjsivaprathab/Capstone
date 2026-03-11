'TightCoupling': '''
import java.sql.*; import java.net.*; import java.io.*;
import javax.mail.*; import org.apache.http.*; import com.google.gson.*;
import org.springframework.beans.*; import org.hibernate.*;
public class TightCoupling {
  private Connection dbConn; private Object httpClient; private Object mailSession;
  public void run() { try { dbConn.createStatement().execute("SELECT 1"); } catch(Exception e) {} } 
  public void sendAlert(String msg) { System.out.println(msg); } 
  public void processAll() { for(int i=0;i<100;i++) { run(); sendAlert("msg"); } } 
}'''
