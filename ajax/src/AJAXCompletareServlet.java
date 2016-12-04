import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.google.gson.Gson; 
import javax.json.JsonArray;
import javax.json.JsonWriter; 
import javax.json.Json;

public class AJAXCompletareServlet extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    PrintWriter out=res.getWriter();
    String tip=req.getParameter("tip");
    res.setHeader("Cache-Control","no-cache");
    if(tip.equals("xml")){
      res.setContentType("text/xml");
      out.print("<?xml version=\"1.0\" ?>");
      out.print("<optionale>");
      out.print("<disciplina>");
      out.print("<denumire> Calcul Paralel </denumire>");
      out.print("</disciplina>");
      out.print("<disciplina>");
      out.print("<denumire> Tehnologii distribuite </denumire>");
      out.print("</disciplina>");
      out.print("<disciplina>");
      out.print("<denumire> Rezolvarea numerica a e.d.o. </denumire>");
      out.print("</disciplina>");
      out.print("</optionale>"); 
    }
    else{
      res.setContentType("application/json");
      
      // gson
      /*
      Disciplina an=new Disciplina("Analiza numerica");
      Disciplina pd=new Disciplina("Programare distribuita");
      Disciplina sm=new Disciplina("Soft matematic");
      Disciplina[] discipline={an,pd,sm};
      Gson gson=new Gson();
      String json=gson.toJson(discipline);
      out.println(json);
      //System.out.println(json);
      */
      // jee
      JsonArray jsonArray=Json.createArrayBuilder()
       .add(Json.createObjectBuilder()
          .add("nume","Analiza numerica"))
       .add(Json.createObjectBuilder()
         .add("nume","Programare distribuita"))
       .add(Json.createObjectBuilder()
         .add("nume","Soft matematic"))           
      .build();
      JsonWriter jsonWriter=Json.createWriter(out);
      jsonWriter.writeArray(jsonArray);
      jsonWriter.close();
      //out.println(jsonArray);
    }
    out.close();
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    doGet(req,res);
  }
}

/*
class Disciplina{
  private String nume;
  Disciplina(){}
  
  Disciplina(String nume){
    this.nume=nume;
  }
  public String getNume(){
    return nume;
  }
}
*/
