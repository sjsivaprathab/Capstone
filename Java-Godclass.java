{
'GodClass': '''
import java.util.*; import java.io.*; import java.net.*;
import java.sql.*; import java.math.*; import java.text.*;
public class GodClass {
  private Connection db; private Socket socket; private List<Object> cache = new ArrayList<>();
  public void processOrder(int id) { for(int i=0;i<100;i++) { if(i%2==0) { for(int j=0;j<50;j++) { if(j>10) { cache.add(i*j); } } } } } 
  public void saveToDb(Object o) { try { db.prepareStatement("INSERT INTO t VALUES(?)").execute(); } catch(Exception e) {} } 
  public void sendEmail(String s) { try { socket.getOutputStream().write(s.getBytes()); } catch(Exception e) {} } 
  public void generateReport() { for(int i=0;i<200;i++) { System.out.println("Report line "+i); } } 
  public void validateInput(String s) { if(s==null) { if(s.length()==0) { if(s.trim().isEmpty()) { throw new RuntimeException(); } } } } 
}''',
