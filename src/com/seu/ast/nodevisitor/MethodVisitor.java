package com.seu.ast.nodevisitor;



import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import com.seu.ast.node.ClassNodeInMethod;
import com.seu.ast.node.MethodNode;

public class MethodVisitor extends ASTVisitor {
	  private MethodNode methodNode;
	  
	  @Override
	  public boolean visit(SingleVariableDeclaration vDeclaration) {
		  String classes = vDeclaration.getType().toString();
		  String name1 = vDeclaration.getName().getFullyQualifiedName();
		  methodNode.AddClass(classes, name1);		
		  //System.out.println(classes+"---"+vDeclaration.toString()+"-------"+name1);
		 // System.out.println(methodNode.getSubclass().size());
		 // methodNode.AddSubclass(classes);		 
		  return true;
	  }
	  @Override
	  public boolean visit(MethodInvocation invocation) {
		// System.out.println(invocation.toString());
		 String ex = invocation.toString();
		 if(ex != null) {
			 int dotindex = ex.indexOf('.');
			 int includeindex = ex.indexOf("(");			 
			 if(dotindex > includeindex || dotindex == -1) {
				 return true;
			 }
			// System.out.println(dotindex+"----------"+includeindex);
			 String name = ex.substring(0,dotindex);
			 String methodname = ex.substring(dotindex+1, includeindex);
			// System.out.println(name +"-------"+methodname);
			 if(methodNode != null) {
				 methodNode.AddClassMethod(name, methodname);
			 }
		 }
		 // methodNode.AddSubmethod(invocation.getName().getFullyQualifiedName()+"invovation");
		  return true;
	  }
	 
	public MethodNode getMethodNode() {
		return methodNode;
	}
	
	@Override
	public boolean visit(VariableDeclarationFragment statement) {
		
		
		Expression statements = statement.getInitializer();
		
		System.out.println(statement.toString());//+"-----++==    "+tem.getInitializer().toString()+"==   "+tem.getName().toString()
		return true;
	}
	public void setMethodNode(MethodNode methodNode) {
		this.methodNode = methodNode;
	}
	  
}
