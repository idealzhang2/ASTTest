package com.seu.ast.node;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class ProjectNode {
	private List< CompilationNode> compilationNodes = new ArrayList<CompilationNode>();
	private String projectname;
	private String path;
	public List<CompilationNode> getCompilationNodes() {
		return compilationNodes;
	}
	public void setCompilationNodes(List<CompilationNode> compilationNodes) {
		this.compilationNodes = compilationNodes;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void addCompilation(CompilationNode compilationNode) {
		compilationNodes.add(compilationNode);
	}
	public void deleteCompilation(int index) {
		int size = compilationNodes.size();
		if(index < 0 || index >=size) {
			return ;
		}
		compilationNodes.remove(index);
	}
	public void deleteCompilation(CompilationNode compilationNode) {		
		compilationNodes.remove(compilationNode);
	}
	public CompilationNode getCompilation(int index) {
		int size = compilationNodes.size();
		if(index < 0 || index >= size) {
			return null;
		}
		return compilationNodes.get(index);
	}
}
