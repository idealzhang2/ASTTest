package com.seu.ast.node;

import java.util.ArrayList;

public class MethodNode {
	private String filepath = "";
	private String returntype = "";
	private String name = "";
	private ArrayList<String> parameter = new ArrayList<String>();
	private ArrayList<ClassNodeInMethod> subclass = new ArrayList<ClassNodeInMethod>();
	public void AddClass(String type, String methodname) {
		if(type == null || methodname == null || "".equals(type) || "".equals(methodname)) {
			return;
		}
		for(ClassNodeInMethod method: subclass) {
			String typename = method.getClassname();
			String name = method.getName();
			if(methodname.equals(name) && type.equals(typename)) {
				return;
			}
		}		
		ClassNodeInMethod teMethod = new ClassNodeInMethod();
		teMethod.setClassname(type);
		teMethod.setName(methodname);
		subclass.add(teMethod);
		//System.out.println("success");
	}
	public void AddClassMethod(String classname, String methodname) {
		if (classname == null || methodname == null) {
			return;
		}
		for (ClassNodeInMethod cInMethod : subclass) {
			String name = cInMethod.getName();
			if (classname.equals(name)) {
				cInMethod.addMethod(methodname);
			}
		}

	}

	public void AddParameter(String name) {
		parameter.add(name);
	}

	public void AddSubclass(ClassNodeInMethod name) {
		subclass.add(name);
	}

	public String GetParameter(int index) {
		if (index < parameter.size()) {
			return parameter.get(index);
		}
		return null;
	}

	public void SetParameter(int index, String item) {
		parameter.set(index, item);
	}

	public ClassNodeInMethod GetSubclass(int index) {
		if (index < subclass.size()) {
			return subclass.get(index);
		}
		return null;
	}

	public void SetSubclass(int index, ClassNodeInMethod item) {
		subclass.set(index, item);
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

	public ArrayList<ClassNodeInMethod> getSubclass() {
		return subclass;
	}

	public void setSubclass(ArrayList<ClassNodeInMethod> subclass) {
		this.subclass = subclass;
	}

}
