package br.ucs.shopping.views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LogoutBean {
  public String logout(){
    FacesContext fc = FacesContext.getCurrentInstance();  
    HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
    session.invalidate();  
    return "login.xhtml";
  }
}
