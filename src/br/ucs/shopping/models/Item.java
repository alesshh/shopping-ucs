package br.ucs.shopping.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Item implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "item_sq")
  @SequenceGenerator(name = "item_sq", sequenceName = "item_sq")
  private Integer id;

  @Column
  private Integer number;

  @Column
  private Integer amount;

  @Column
  private Double price;

  @OneToOne(cascade = CascadeType.ALL)
  private Product product;

  public Item() {
  }

  /*public Item(Integer number, Integer amount, Double price) {
    this.amount = amount;
    this.number = number;
    this.price = price;
  }*/

  public Item(Integer number, Integer amount, Double price, Product product) {
    this.amount = amount;
    this.number = number;
    this.price = price;
    this.product = product;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getNumber() {
    return number;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
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
    Item other = (Item) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
