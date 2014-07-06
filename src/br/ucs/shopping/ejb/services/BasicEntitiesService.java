package br.ucs.shopping.ejb.services;

import br.ucs.shopping.ejb.intf.BasicEntitiesIntf;
import br.ucs.shopping.models.Address;
import br.ucs.shopping.models.Department;
import br.ucs.shopping.models.Employee;
import br.ucs.shopping.models.Store;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class BasicEntitiesService implements BasicEntitiesIntf {

  @PersistenceContext(unitName = "shopping-ucs")
  private EntityManager entityManager;

  public void run() {
    Address elvengearAddress = new Address("Elvengear Avenue", 1337, "Flat", "Tower", "Mount Doom", "1234");
    Address rickAddress = new Address("Rick's Avenue", 1337, "Flat", "Tower", "Mount Doom", "1234");
    Department sales = new Department("Sales");
    Employee rick = new Employee("Rick Grimes", new Date(), "rick", "carlwins", "54 3286-1234", rickAddress, sales, false);
    Store elvengear = new Store("ElvenGear", "123", "54 3282-2345", elvengearAddress);
    elvengear.getDepartments().add(sales);

    entityManager.persist(rick);
    entityManager.persist(elvengear);
  }

}
