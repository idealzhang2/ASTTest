package com.seu.ast.util;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.CompilationUnit;

import com.seu.ast.node.ClassNode;
import com.seu.ast.node.CompilationNode;
import com.seu.ast.node.ProjectNode;
import com.seu.ast.nodevisitor.ClassVisitor;

public class ASTResultCreator {
	private ProjectNode projectNode = new ProjectNode();
	private CompilationList compilationList =  new CompilationList();
	public ProjectNode getProjectNode() {
		return projectNode;
	}

	public void setProjectNode(ProjectNode projectNode) {
		this.projectNode = projectNode;
	}

	public void creatAST(String path) throws Exception {
		FilePaths paths = new FilePaths();		
		paths.searchfiles(path);
		for(String tt:paths.getSrclist()) {
			System.out.println(tt);
		}
		compilationList.InitUnits(paths.getSrclist());		
		ArrayList<CompilationUnit> units = (ArrayList<CompilationUnit>) compilationList.getUnits();
		System.out.println(paths.getSrclist().size()+"        "+units.size());
		for(CompilationUnit unit: units) {
			ClassVisitor visitor = new ClassVisitor();
			ClassNode classNode = new ClassNode();
			CompilationNode compilationNode = new CompilationNode();
			compilationNode.getUnitlist().add(classNode);
			String classpath = paths.getSrclist().get(units.indexOf(unit));
		//	if(unit.getPackage() != null)
		//	System.out.println(unit.getPackage().getName());
		//	System.out.println(paths.getSrclist().get(units.indexOf(unit)));
			visitor.setCompilationNode(compilationNode);
			classNode.setFilepath(classpath);
			classNode.setName("----------TEST--------");
			visitor.setClassnode(classNode);
			projectNode.addCompilation(compilationNode);
			unit.accept(visitor);
		}
//		CompilationUnit  cUnit = (CompilationUnit)(parser.createAST(null));
//		ClassVisitor visitor = new ClassVisitor();
//		ClassNode classNode = new ClassNode();
//		CompilationNode compilationNode = new CompilationNode();
//		visitor.setCompilationNode(compilationNode);
//		classNode.setFilepath(path);
//		classNode.setName("TEST-----");
//		visitor.setClassnode(classNode);
//		cUnit.accept(visitor);
	}
	
}
