package com.seu.ast.nodevisitor;

import java.security.Policy.Parameters;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclaration;

import com.seu.ast.node.MethodNode;

public class MethodVisitor extends ASTVisitor {
	  private MethodNode methodNode;

	  
	  @Override
	  public boolean visit(SingleVariableDeclaration vDeclaration) {
		  String classes = vDeclaration.getType().toString();
		  String name = vDeclaration.getName().getFullyQualifiedName();		  
		  methodNode.setName(name);
		  methodNode.AddSubclass(classes);		 
		  return true;
	  }
	  @Override
	  public boolean visit(MethodInvocation invocation) {
		  methodNode.AddSubmethod(invocation.getName().getFullyQualifiedName()+"invovation");
		  return true;
	  }
	 
	public MethodNode getMethodNode() {
		return methodNode;
	}

	public void setMethodNode(MethodNode methodNode) {
		this.methodNode = methodNode;
	}
	  
}
