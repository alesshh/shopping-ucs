package br.ucs.shopping.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "homeBean")
@SessionScoped
public class HomeBean {

	private String foo;

	public HomeBean() {
		this.foo = "hoo";
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo() {
		this.foo = new Date().toString();
	}

}
