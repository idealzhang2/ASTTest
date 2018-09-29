package com.seu.ast.Visitor;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class Method_VariableVisitor extends ASTVisitor {
		private File_Method_Node Node = new File_Method_Node();
		
		private Method_Variable_Node tem = null; 
		
	  public File_Method_Node getNode() {
			return Node;
		}



		public void setNode(File_Method_Node node) {
			Node = node;
		}

		public void print() {
			ArrayList<Method_Variable_Node> aList = Node.getVariable_Node();
			for(int i = 0; i < aList.size();i++) {
				Method_Variable_Node temp = aList.get(i);
				System.out.println(temp.getMethodname()+":");
				ArrayList<String> entity = (ArrayList<String>) temp.getEntityname();
				for(int j = 0;j < entity.size();j++) {
					System.out.println(entity.get(j));
				}
			}
		}

	@Override
	  public boolean visit(MethodDeclaration mDeclaration) {
		  String name = mDeclaration.getName().getFullyQualifiedName();
		  if(tem != null) {
			  Node.AddVariable(tem);
		  }
		  if(name != null) {
			 tem = new Method_Variable_Node();
			  tem.setMethodname(name);
//			  @SuppressWarnings("unchecked")
//			 
//			List<SingleVariableDeclaration> ls =  mDeclaration.parameters();
//			  for(int i = 0;i < ls.size();i++) {
//				tem.AddEntity(ls.get(i).getType().toString());  
//			  }
		  }
		
		  return true;
	  }
	@Override 
	public boolean visit(SingleVariableDeclaration singleVariableDeclaration) {
		String name = singleVariableDeclaration.getType().toString();
		if(tem == null) {
			tem = new Method_Variable_Node();
		}
		if(name != null) {
			tem.AddEntity(name);
		}
		return true;
	}
	@Override
	public boolean visit(ExpressionStatement tDeclaration) {
		System.out.println("+++++++++"+tDeclaration.getExpression().toString()+"++++++++++");
		return false;
	}
}
