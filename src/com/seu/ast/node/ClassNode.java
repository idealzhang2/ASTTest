package com.seu.ast.node;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ClassNode {
	private String filepath = "";
	private String name = "";
	private ArrayList<MethodNode> methodlist = new ArrayList<MethodNode>();
	public void AddMethodNode(MethodNode node) {
		methodlist.add(node);
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<MethodNode> getMethodlist() {
		return methodlist;
	}
	public void setMethodlist(ArrayList<MethodNode> methodlist) {
		this.methodlist = methodlist;
	}
	
}
