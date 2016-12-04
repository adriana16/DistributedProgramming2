package judete.service;
import judete.model.Judet;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class JudeteManager{
  private HashMap<String,Judet> refJudete=null;
  private List<String> lstJud=null;
  //private String tomcatVersion="8.5.6";
  
  JudeteManager(){
    refJudete=new HashMap<String,Judet>();
    lstJud=new LinkedList<String>(); 
    try{
      String pathServer=new java.io.File(".").getCanonicalPath();
      String fs=System.getProperty("file.separator");
      String path=pathServer+fs+"webapps"+fs+"judete"+fs+"judete.txt";
      InputStream is=new FileInputStream(path);
      //InputStream is=new FileInputStream("/JavaApp/apache-tomcat-"+tomcatVersion+"/webapps/judete/judete.txt");
      
      
      InputStreamReader isr=new InputStreamReader(is);
      BufferedReader br=new BufferedReader(isr);
      String s="";
      do{
        s=br.readLine();
        String[] ts=s.split(" ");
        Judet jud=new Judet();
        jud.setNume(ts[0]);
        jud.setCapitala(ts[1]);
        jud.setAbreviere(ts[2]);
        refJudete.put(ts[0],jud);
        lstJud.add(ts[0]);
        System.out.println(ts[0]+" "+ts[1]+" "+ts[2]);
      }
      while(s!=null);
      br.close();
      isr.close();
      is.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  public HashMap<String,Judet> getRefJudete(){
    return refJudete;
  } 
  
  public List<String> getLstJud(){
    return lstJud;
  }
}  
  