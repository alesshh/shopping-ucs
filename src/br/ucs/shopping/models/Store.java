package br.ucs.shopping.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Store implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "store_sq")
  @SequenceGenerator(name = "store_sq", sequenceName = "store_sq")
  private Integer id;

  @Column
  private String name;

  @Column
  private String cgc;

  @Column
  private String phoneNumber;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Customer> customers;

  @OneToOne(cascade = CascadeType.ALL)
  private Stock stock;

  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Department> departments;

  public Store() {
    this.customers = new ArrayList<Customer>();
    this.departments = new ArrayList<Department>();
  }

  public Store(String name, String cgc, String phoneNumber) {
    this();
    this.name = name;
    this.cgc = cgc;
    this.phoneNumber = phoneNumber;
  }

  public Store(String name, String cgc, String phoneNumber, Address address) {
    this();
    this.address = address;
    this.cgc = cgc;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCgc(String cgc) {
    this.cgc = cgc;
  }

  public String getCgc() {
    return cgc;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  public Stock getStock() {
    return stock;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }

  public void setDepartments(List<Department> departments) {
    this.departments = departments;
  }

  public List<Department> getDepartments() {
    return departments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Store other = (Store) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
