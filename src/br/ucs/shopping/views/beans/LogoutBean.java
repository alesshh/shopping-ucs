package br.ucs.shopping.views.beans;

import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Employee;
import br.ucs.shopping.models.Request;

@ManagedBean
@SessionScoped
public class LogoutBean {

	@PersistenceContext(unitName = "shopping-ucs")
	private EntityManager entityManager;

	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		session.invalidate();
		return "login.xhtml";
	}

	public Customer getCustomer() {
		String customerName = FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();
		Query query = entityManager
				.createQuery("select customer from Customer as customer where customer.username = :name");
		query.setParameter("name", customerName);
		List results = query.getResultList();
		if (!results.isEmpty()) {
			return (Customer) results.get(0);
		}
		return null;
	}

	/**
	 * @return
	 */
	public List<Request> getCustomerRequests() {
		Customer c = getCustomer();

		if (c != null) {
			Query query = entityManager
					.createQuery("select r from Request as r where r.customer = :customer");
			query.setParameter("customer", c);

			return query.getResultList();

		} else {
			return Collections.emptyList();
		}
	}

	public Employee getEmployee() {
		String employeeName = FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();
		Query query = entityManager
				.createQuery("select employee from Employee as employee where employee.username = :name");
		query.setParameter("name", employeeName);
		List results = query.getResultList();
		if (!results.isEmpty()) {
			return (Employee) results.get(0);
		}
		return null;
	}

	public boolean isLoggedIn() {
		if (this.getCustomer() != null || this.getEmployee() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmployee() {
		if (this.getEmployee() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCustomer() {
		if (this.getCustomer() != null) {
			return true;
		} else {
			return false;
		}
	}

  public boolean isEmployee(){
    if(this.getEmployee() != null){
      return true;
    }else{
      return false;
    }
  }

  public boolean isCustomer(){
    if(this.getCustomer() != null){
      return true;
    }else{
      return false;
    }
  }

}
