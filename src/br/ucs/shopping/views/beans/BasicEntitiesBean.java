package br.ucs.shopping.views.beans;

import br.ucs.shopping.ejb.intf.BasicEntitiesIntf;
import java.text.ParseException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "basicEntitiesBean")
@SessionScoped
public class BasicEntitiesBean {

  @EJB
  private BasicEntitiesIntf basicEntitiesService;

  public String run() throws ParseException {
    basicEntitiesService.run();
    return "index.xhtml";
  }

}
