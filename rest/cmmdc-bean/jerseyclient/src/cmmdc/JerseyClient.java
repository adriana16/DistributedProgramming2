package cmmdc;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity; 
import javax.ws.rs.core.MediaType;
import java.util.Scanner;
import java.io.PrintWriter; 
import resources.CmmdcBean;

public class JerseyClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    String sm=(new Long(m)).toString();
    String sn=(new Long(n)).toString();
    CmmdcBean bean=new CmmdcBean();
    bean.setSm(sm);
    bean.setSn(sn);   
    
    int tip=1; 
    do{
      System.out.println("Encoder Type");
      System.out.println("1: JSON");
      System.out.println("2: XML");
      tip=scanner.nextInt();
    }  
    while((tip!=1) &&  (tip!=2));
    Client client = ClientBuilder.newClient(); 
    String sURI="";
    
    if(tip==1){
      sURI="http://localhost:8080/JsonCmmdc/resources/cmmdc";
    }
    else{
      sURI="http://localhost:8080/XmlCmmdc/resources/cmmdc";
    }
    WebTarget target=client.target(sURI);
    CmmdcBean obj;
    if(tip==1){
      obj = target
        .request()
        .post(Entity.entity(bean, MediaType.APPLICATION_JSON), CmmdcBean.class);
    }
    else{
      obj = target
        .request()
        .post(Entity.entity(bean, MediaType.APPLICATION_XML), CmmdcBean.class);
    }
    System.out.println(obj.getResult());
  }
}
