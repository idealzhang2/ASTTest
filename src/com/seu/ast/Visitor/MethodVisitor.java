package com.seu.ast.Visitor;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.VariableElement;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
public class MethodVisitor extends ASTVisitor {
		@Override
		public boolean visit(FieldDeclaration node) {
			for(Object tem : node.fragments()) {
				VariableDeclarationFragment v = (VariableDeclarationFragment)tem;
				//System.out.println(v.getName());
			}
			//System.out.println("Method Name:"+node.getType()+"----"+node.getFlags()+"--"+node.getModifiers()+"-----"+node.getNodeType()+"---"+node.getStartPosition());
			return true;
		}
		@Override
		public boolean visit(InstanceofExpression md) {
			Type type = md.getRightOperand();
		//	System.out.println(type.getStartPosition()+"----"+type.getNodeType()+"----"+type.toString());
			
			return true;
		}
		@Override 
		public boolean visit(MethodDeclaration mDeclaration) {
			String tem = mDeclaration.getName().getFullyQualifiedName();
			Block  block = mDeclaration.getBody();
			//System.out.println(block+"----"+block.getLocationInParent());
			List<Statement> ls = block.statements();
			for(int i = 0; i < ls.size();i++) {
				Statement st = ls.get(i);
			//	System.out.println(st.getLeadingComment()+"----"+st.getStartPosition());
				@SuppressWarnings("unchecked")
				Map<String, Object> map = st.properties();
				Iterator<Map.Entry<String,Object>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()) {
				Map.Entry<String, Object> entry = iterator.next();
		//		System.out.println("key:"+entry.getKey()+"-----values:"+entry.getValue());
				}
			}
			
		//	System.out.println("######################"+tem);
			return true;
		}
		@Override 
		public boolean visit(MethodInvocation mDeclaration) {
			String tem = mDeclaration.getName().getFullyQualifiedName();
		IMethodBinding typeBinding = mDeclaration.resolveMethodBinding();
			//if(typeBinding != null)
		//	System.out.println(typeBinding.getMethodDeclaration()+"-----------"+typeBinding.getKey()+"-----"+typeBinding.getName());
			//Expression expression = mDeclaration.getExpression();
			//if(expression != null)
			//System.out.println("-----"+expression.getLength()+"----"+expression.toString());
			//SimpleName simpleName = mDeclaration.getName();
			System.out.println(tem+"------"+mDeclaration.getParent().toString()+"-----");
			
			return true;
		}
		@Override 
		public boolean visit(TypeDeclaration mDeclaration) {
			System.out.println("Type");
			 System.out.println(mDeclaration.getName());;
			FieldDeclaration[] fieldDeclarations = mDeclaration.getFields();
			for(int i = 0; i < fieldDeclarations.length;i++) {
				FieldDeclaration tem = fieldDeclarations[i];
			//System.out.println("#########"+tem.toString());
			}
			
			
			return true;
		}
		@Override
		public boolean visit(VariableDeclarationFragment vdf) {
			//System.out.println(vdf.getName()+" "+vdf.getParent().getFlags());
			return true;
		}
		@Override
		public boolean visit(SingleVariableDeclaration vdf) {
			System.out.println(vdf.toString()+" "+vdf.getParent().getFlags());
			return true;
		}
		
		
		
}
