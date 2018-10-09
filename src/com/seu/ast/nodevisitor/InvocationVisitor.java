package com.seu.ast.nodevisitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

import com.seu.ast.node.ClassNodeInMethod;
import com.seu.ast.node.MethodNode;

public class InvocationVisitor extends ASTVisitor {
	private MethodNode methodNode;
	
	 public MethodNode getMethodNode() {
		return methodNode;
	}

	public void setMethodNode(MethodNode methodNode) {
		this.methodNode = methodNode;
	}

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
	 
}
