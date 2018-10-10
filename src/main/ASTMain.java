package main;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.internal.compiler.ast.ExtendedStringLiteral;

import com.seu.ast.node.ClassNode;
import com.seu.ast.node.ClassNodeInMethod;
import com.seu.ast.node.CompilationNode;
import com.seu.ast.node.MethodNode;
import com.seu.ast.nodevisitor.ClassVisitor;


public class ASTMain {

	public static void main(String[] args) throws Exception {
		String path = "D:\\project\\workspace\\MRSBW\\src\\cn\\edu\\seu\\web\\recovery\\SoftwareArchitecture.java";
		
		FileInputStream inputStream = new FileInputStream(path);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		byte[] input = new byte[bufferedInputStream.available()];
		bufferedInputStream.read(input);
		bufferedInputStream.close();
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(new String(input).toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		CompilationUnit  cUnit = (CompilationUnit)(parser.createAST(null));
		ClassVisitor visitor = new ClassVisitor();
		ClassNode classNode = new ClassNode();
		CompilationNode compilationNode = new CompilationNode();
		visitor.setCompilationNode(compilationNode);
		classNode.setFilepath(path);
		classNode.setName("TEST-----");
		visitor.setClassnode(classNode);
		cUnit.accept(visitor);
		
		ASTMain astMain = new ASTMain();
		astMain.print(compilationNode);
	}
	public void print(CompilationNode compilationNode) {
		ArrayList<ClassNode> classNodes = compilationNode.getUnitlist();
		for(int i = 0; i < classNodes.size();i++) {
			ClassNode tem = classNodes.get(i);
			
			System.out.println("Class Path:"+tem.getFilepath()+"Class Name:"+tem.getName());
			ArrayList<MethodNode> temmethod = tem.getMethodlist();
			for(int j = 0; j < temmethod.size();j++) {
				MethodNode teMethodNode = temmethod.get(j);
				System.out.print("Method Name:  "+teMethodNode.getName()+"   Parameters:   (");
				//System.out.println("-------Method Name:--------"+teMethodNode.getName()+"-------Return Type:----------"+teMethodNode.getReturntype()+"-----ÊýÁ¿"+teMethodNode.getSubclass().size());
				ArrayList<String> parameter = teMethodNode.getParameter();
				for(int t = 0; t < parameter.size();t++) {
					System.out.print(parameter.get(t).toString()+"         ");
				}
				System.out.println("){");
				ArrayList<ClassNodeInMethod> classes = teMethodNode.getSubclass();
				for(int t = 0;t < classes.size();t++) {
					System.out.println(classes.get(t).getClassname()+"  "+classes.get(t).getName()+ "  { ");
					//System.out.println("method of class in the method   " + classes.get(t).getMethod().size() );
					for(String tt:classes.get(t).getMethod()) {
					// System.out.println("has came in this method!");
						System.out.println("method:  "+tt+"  ");	
					}
					System.out.println("}");
				}
				System.out.println("}");
				
				
			}
		}
	}

}
