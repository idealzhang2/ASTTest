package com.seu.ast.Visitor;

import java.util.ArrayList;
import java.util.List;
public class File_Method_Node {
	private String name;	
	private List<Method_Variable_Node> variable_Node = new ArrayList<Method_Variable_Node>();

	
	public ArrayList<Method_Variable_Node> getVariable_Node() {
		return (ArrayList<Method_Variable_Node>) variable_Node;
	}

	public void setVariable_Node(ArrayList<Method_Variable_Node> variable_Node) {
		this.variable_Node = variable_Node;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	public void AddVariable(Method_Variable_Node node) {
		variable_Node.add(node);
	}
	public void RemoveVariable(Method_Variable_Node node) {
		variable_Node.remove(node);
	}
	public void RemoveVariable(int index) {
		variable_Node.remove(index);
	}
	public Method_Variable_Node GetMethod_Variable(int index) {
		return variable_Node.get(index);
	}
}
