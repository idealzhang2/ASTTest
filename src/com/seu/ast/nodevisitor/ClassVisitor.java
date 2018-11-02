package com.seu.ast.nodevisitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import com.seu.ast.node.ClassNode;
import com.seu.ast.node.CompilationNode;
import com.seu.ast.node.MethodNode;

public class ClassVisitor extends ASTVisitor {
	private CompilationNode compilationNode;
	private ClassNode classnode;
	public CompilationNode getCompilationNode() {
		return compilationNode;
	}

	public void setCompilationNode(CompilationNode compilationNode) {
		this.compilationNode = compilationNode;
	}

	public ClassNode getClassnode() {
		return classnode;
	}

	public void setClassnode(ClassNode classnode) {
		this.classnode = classnode;
	}
	@Override
	public boolean visit(TypeDeclaration node) {
		//System.out.println("Class:\t" + node.getName());//+"   "+node.toString()
		if(node.getName() == null) {
			return true;
		}
		String classname = node.getName().getFullyQualifiedName();
		classnode.setName(classname);
//		List<ClassNode> ll = compilationNode.getUnitlist();
//		for(ClassNode cNode:ll) {
//			if(classname.equals(cNode.getName())) {
//				
//				return true;
//			}
//		}
//		
//		classnode = new ClassNode();
//		compilationNode.getUnitlist().add(classnode);
		
		return true;
	}
	
	@Override
	public boolean visit(MethodDeclaration mDeclaration) {
		String name = mDeclaration.getName().getFullyQualifiedName();
		// classnode.setName(name);
		//System.out.println(name);
		//compilationNode.getUnitlist().add(classnode);
		MethodVisitor visitor = new MethodVisitor();
		MethodNode subnode = new MethodNode();
		List<TypeParameter> methodDeclarations = mDeclaration.typeParameters();
		for (int i = 0; i < methodDeclarations.size(); i++) {
			subnode.AddParameter(methodDeclarations.get(i).getName().getFullyQualifiedName());
		}
		subnode.setName(name);
		subnode.setFilepath(classnode.getFilepath() + "." + name);
		// subnode.setReturntype(mDeclaration.getReturnType().toString());
		classnode.AddMethodNode(subnode);
		visitor.setMethodNode(subnode);
		mDeclaration.accept(visitor);
		// System.out.println("==============="+mDeclaration.getName().getFullyQualifiedName()+"===================");
		return false;
	}

}
