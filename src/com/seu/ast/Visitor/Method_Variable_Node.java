package com.seu.ast.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Method_Variable_Node {
	private String methodname = "";
	private List<String> entityname = new ArrayList<String>();
	public void AddEntity(String name) {
		entityname.add(name);
	}
	public String GetEntity(int index) {
		if (index < entityname.size()) {
			return entityname.get(index);
		}
		return null;
	}
	
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public List<String> getEntityname() {
		return entityname;
	}
	public void setEntityname(List<String> entityname) {
		this.entityname = entityname;
	}
	public void SetEntity(int index, String name) {
		if(index < entityname.size()) {
			entityname.set(index,name);
		}
	}
	public void RemoveEntity(int index) {
		entityname.remove(index);
	}
	public void RemoveEntity(String index) {
		entityname.remove(index);
	}
}
