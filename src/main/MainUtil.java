package main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jdt.core.dom.*;

import com.seu.ast.Visitor.MethodVisitor;
import com.seu.ast.Visitor.Method_VariableVisitor;
public class MainUtil {

	public static void main(String[] args) throws Exception 
	{
		byte[] input = null;
		String path = "D:\\\\project\\\\workspace\\\\MRSBW\\\\src\\\\cn\\\\edu\\\\seu\\\\web\\\\recovery\\\\SoftwareArchitecture.java";
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		input = new byte[bis.available()];
		bis.read(input);
		bis.close();
		ASTParser astParser = ASTParser.newParser(AST.JLS3);
        astParser.setSource(new String(input).toCharArray());
        astParser.setBindingsRecovery(true);        
        astParser.setKind(ASTParser.K_COMPILATION_UNIT);
 
        CompilationUnit result = (CompilationUnit) (astParser.createAST(null));
		Method_VariableVisitor visitor = new Method_VariableVisitor();
		result.accept(visitor);
		MethodVisitor mVisitor = new MethodVisitor();
		//visitor.print();
		//result.accept(mVisitor);
	}

}
