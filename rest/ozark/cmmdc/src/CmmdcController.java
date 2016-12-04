package resources;

import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
//import javax.mvc.View;
//import javax.mvc.Viewable;
//import javax.mvc.mapper.OnConstraintViolation;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.*;
import javax.ws.rs.QueryParam;

@Path("/")
@Controller
public class CmmdcController {

  @Inject
  private Models models;

  @GET
  @Path("/cmmdc")
  public String computeCmmdc(@QueryParam("m") String sm,
  @QueryParam("n") String sn) {
      
    CmmdcBean cb=new CmmdcBean();
    cb.setSm(sm);
    cb.setSn(sn);
    long result =cmmdc(Long.parseLong(sm),Long.parseLong(sn));
    cb.setResult(new Long(result).toString());
    System.out.println(sm+":"+sn+":"+result);
    models.put("cmmdc", cb);

    return "cmmdc.hbs";
  }

  public long cmmdc(long m,long n) {
    long c,r;
    do{
        c=n;
        r=m%n;
        m=n;
        n=r;
    }
    while(r!=0);
    return c;
  }
}
