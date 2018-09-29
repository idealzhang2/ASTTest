package com.seu.ast.Visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

public class ObjectInMethodVisitor  extends ASTVisitor{
		@Override
		public boolean visit(MethodInvocation md) {
			
			return true;
		}
}
