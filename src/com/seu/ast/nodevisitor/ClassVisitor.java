package com.seu.ast.nodevisitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import com.seu.ast.node.ClassNode;
import com.seu.ast.node.CompilationNode;
import com.seu.ast.node.MethodNode;

public class ClassVisitor extends ASTVisitor{
	 private ClassNode classnode ;
	 
	 public ClassNode getClassnode() {
		return classnode;
	}

	public void setClassnode(ClassNode classnode) {
		this.classnode = classnode;
	}

	@Override
	 public boolean visit(MethodDeclaration mDeclaration) {
		  String name = mDeclaration.getName().getFullyQualifiedName();		  
		  //classnode.setName(name);
		 
		  CompilationNode.unitlist.add(classnode);		 
		  MethodVisitor visitor = new MethodVisitor();
		  MethodNode subnode = new MethodNode();
		  List<SingleVariableDeclaration> methodDeclarations = mDeclaration.typeParameters();
		  for(int i = 0; i < methodDeclarations.size();i++) {
			  subnode.AddParameter(methodDeclarations.get(i).getName().getFullyQualifiedName());
		  }
		  subnode.setName(name);
		  subnode.setFilepath(classnode.getFilepath()+"."+name);
		//  subnode.setReturntype(mDeclaration.getReturnType().toString());
		  classnode.AddMethodNode(subnode);
		 visitor.setMethodNode(subnode);
		  mDeclaration.accept(visitor);
		 // System.out.println();
		//  System.out.println("==============="+mDeclaration.getName().getFullyQualifiedName()+"===================");
		 return false;
	 }
}
