package com.seu.ast.node;

import java.util.ArrayList;
import java.util.List;

public class ClassNodeInMethod {
	private String classname = "";
	private String name = "";
	private List<String> method = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public List<String> getMethod() {
		return method;
	}
	public void setMethod(List<String> method) {
		this.method = method;
	}
	public void addMethod(String name) {	
		method.add(name);
	}
	public void deleteMethod(String name) {
		method.remove(name);
	}
	public void deleteMethod(int index) {
		method.remove(index);
	}
	public String getMethod(int index) {
		if(index < method.size()) {
		return method.get(index);
		}else {
		return null;	
		}
	}
	public int getIndex(String name) {
		return method.indexOf(name);
	
	}
}
