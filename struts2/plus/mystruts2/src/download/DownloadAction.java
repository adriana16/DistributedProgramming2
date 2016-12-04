package download;
import javax.servlet.ServletContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.Result;
//import org.apache.struts2.dispatcher.StreamResult; 
//import com.opensymphony.xwork2.ActionContext; 
import org.apache.struts2.ServletActionContext;
import java.io.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
 
public class DownloadAction extends ActionSupport{
  private String file;
  public void setFile(String file) {
    this.file=file;
  }
  
  public String getFile(){
    return file;
  }  
  
  private InputStream fileInputStream;
  
  public InputStream getFileInputStream() {
    return fileInputStream;
  }
  /*
  public InputStream getInputStream() throws Exception {             
    // Setarea ContentDisposition are ca efect afisarea numelui 
    // fisierului in fereastra de dialog de descarcare
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    Result result = 
      ActionContext.getContext().getActionInvocation().getResult();
    if (result!=null && result instanceof StreamResult){
      StreamResult streamResult = (StreamResult) result;
      streamResult.setContentDisposition("attachment;filename="+file);
    } 
    return servletContext.getResourceAsStream("resources/"+file);
  }
  */
  public String execute() throws Exception {
    String fs=System.getProperty("file.separator"); 
    
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    String path=servletContext.getRealPath("/")+
      fs+"resources"+fs;
    
    /*
    String pathTomcat = new java.io.File(".").getCanonicalPath();
    String path=Paths.get(pathTomcat).toString()+
      fs+"webapps"+fs+"mystruts2-app"+
      fs+"resources"+fs; 
    */  
    fileInputStream = new FileInputStream(new File(path+file));
    return SUCCESS;
  }
}
