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
	  
//	  @Override
//	  public boolean visit(SingleVariableDeclaration vDeclaration) {
//		  String classes = vDeclaration.getType().toString();
//		  String name1 = vDeclaration.getName().getFullyQualifiedName();
//		  methodNode.AddClass(classes, name1);		
//		  //System.out.println(classes+"---"+vDeclaration.toString()+"-------"+name1);
//		 // System.out.println(methodNode.getSubclass().size());
//		 // methodNode.AddSubclass(classes);		 
//		  return true;
//	  }
//	  @Override
//	  public boolean visit(MethodInvocation invocation) {
//		 System.out.println("invocation"+invocation.toString());
//		 String ex = invocation.toString();
//		 if(ex != null) {
//			 int dotindex = ex.indexOf('.');
//			 int includeindex = ex.indexOf("(");			 
//			 if(dotindex > includeindex || dotindex == -1) {
//				 return true;
//			 }
//			// System.out.println(dotindex+"----------"+includeindex);
//			 String name = ex.substring(0,dotindex);
//			 String methodname = ex.substring(dotindex+1, includeindex);
//			// System.out.println(name +"-------"+methodname);
//			 if(methodNode != null) {
//				 methodNode.AddClassMethod(name, methodname);
//			 }
//		 }
//		 // methodNode.AddSubmethod(invocation.getName().getFullyQualifiedName()+"invovation");
//		  return false;
//	  }
//	 
	  @Override
	  public boolean visit(MethodInvocation invocation) {
		//System.out.println("has came in this method");
	// System.out.println("invocation         "+invocation.toString());
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
				
				 for(ClassNodeInMethod tt: methodNode.getSubclass()) {
					 
					// System.out.println(tt.getClassname()+"----"+tt.getName()+"-----"+tt.getMethod().size());
					 
				 }
			 }else {
				 System.out.println("Methodnode is null!");
			 }
		 }
		 // methodNode.AddSubmethod(invocation.getName().getFullyQualifiedName()+"invovation");
		  return false;
	  }
	  
	public MethodNode getMethodNode() {
		return methodNode;
	}
	@Override
	public boolean visit(VariableDeclarationExpression expression) {
	//	System.out.println(expression.toString());
		return true;
	}
	@Override
	public boolean visit(VariableDeclarationStatement statement) {
		
		
//		Expression statements = statement.getInitializer();
//		
		
		if(statement == null) {
			return true;
		}
	//	System.out.println("Statement" + statement.toString());
		String classtype = statement.toString();
		int index = classtype.indexOf(" ");
		int endindex = classtype.indexOf("=");
		if(!(index >= 0 && index <classtype.length())) {
			return true;
		}
		if(!(endindex >= 0 && endindex <classtype.length())) {
			return true;
		}
		if(endindex < index) {
			return true;
		}
		String type = classtype.substring(0, index);
		String name = classtype.substring(index,endindex);
		if(type == null || name == null || "".equals(type) || "".equals(name)) {
			return true;
		}
		if(methodNode == null) {
			return true;
		}
		methodNode.AddClass(type,name);	
//		 InvocationVisitor invocationVisitor = new InvocationVisitor();
//		 invocationVisitor.setMethodNode(methodNode);
//			statement.getParent().accept(invocationVisitor);
//		//System.out.println(statement.toString());//+"-----++==    "+tem.getInitializer().toString()+"==   "+tem.getName().toString()
		return true;
	}
	
	public void setMethodNode(MethodNode methodNode) {
		this.methodNode = methodNode;
	}
	  
}
