package br.ucs.shopping.ejb.intf;

import java.text.ParseException;
import javax.ejb.Local;

@Local
public interface BasicEntitiesIntf {
  public void run() throws ParseException;
}
