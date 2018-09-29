package com.seu.ast.node;

import java.util.ArrayList;

public class MethodNode {
	private String filepath = "";
	private String returntype = "";
	private String name = "";
	private ArrayList<String> parameter = new ArrayList<String>();
	private ArrayList<String> subclass = new ArrayList<String>();
	private ArrayList<String> submethod = new ArrayList<String>();
	public void AddParameter(String name) {
		parameter.add(name);
	}
	public void AddSubclass(String name) {
		subclass.add(name);
	}
	public void AddSubmethod(String name) {
		submethod.add(name);
	}
	public String GetParameter(int index) {
		if(index < parameter.size()) {
			return parameter.get(index);
		}
		return null;			
	}
	public void SetParameter(int index, String item) {
		parameter.set(index,item);
	}
	public String GetSubclass(int index) {
		if(index < subclass.size()) {
			return subclass.get(index);
		}
		return null;			
	}
	public void SetSubclass(int index, String item) {
		subclass.set(index, item);
	}
	public String GetSubmethod(int index) {
		if(index < submethod.size()) {
			return submethod.get(index);
		}
		return null;			
	}
	public void SetSubmethod(int index, String item) {
		submethod.set(index, item);
	}
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getReturntype() {
		return returntype;
	}
	public void setReturntype(String returntype) {
		this.returntype = returntype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getParameter() {
		return parameter;
	}
	public void setParameter(ArrayList<String> parameter) {
		this.parameter = parameter;
	}
	public ArrayList<String> getSubclass() {
		return subclass;
	}
	public void setSubclass(ArrayList<String> subclass) {
		this.subclass = subclass;
	}
	public ArrayList<String> getSubmethod() {
		return submethod;
	}
	public void setSubmethod(ArrayList<String> submethod) {
		this.submethod = submethod;
	}
	
}
