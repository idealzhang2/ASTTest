package com.seu.ast.node;

import java.util.ArrayList;

public class CompilationNode {
	private  String filepath = "";
	private  ArrayList<ClassNode> unitlist = new ArrayList<ClassNode>();
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public ArrayList<ClassNode> getUnitlist() {
		return unitlist;
	}
	public void setUnitlist(ArrayList<ClassNode> unitlist) {
		this.unitlist = unitlist;
	}
	public void addClassNode(ClassNode classNode) {
		unitlist.add(classNode);
	}
	public ClassNode getClassNode(int index) {
		int size = unitlist.size();
		if(index < 0 || index >= size ) {
			return null;
		}
		return unitlist.get(index);
	}
	public int getIndex(ClassNode classNode) {
		return unitlist.indexOf(classNode);
	}
	public void deleteClassNode(int index) {
		int size = unitlist.size();
		if(index < 0 || index >= size ) {
			return;
		}
		unitlist.remove(index);
	}
	public void deleteClassNode(ClassNode classNode) {
		unitlist.remove(classNode);
	}
}
