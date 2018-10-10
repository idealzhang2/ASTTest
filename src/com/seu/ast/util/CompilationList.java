package com.seu.ast.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
public class CompilationList {
	private List<CompilationUnit>  units = new ArrayList<CompilationUnit>();
	public void InitUnits(ArrayList<String> list) throws Exception {
		 if(list == null || list.size() == 0) {
			 return;
		 }
		 for(String item: list) {
			 File tem = new File(item);
			 if(!tem.exists()) {
				 continue;
			 }			 
			 FileInputStream inputStream = new FileInputStream(tem);
			 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			 byte[] input = new byte[bufferedInputStream.available()];
			 bufferedInputStream.read(input);
			 bufferedInputStream.close();
			 ASTParser parser = ASTParser.newParser(AST.JLS3);
			 parser.setSource(new String(input).toCharArray());
			 parser.setKind(ASTParser.K_COMPILATION_UNIT);
			 CompilationUnit compilationUnit = (CompilationUnit)(parser.createAST(null)); 
			 units.add(compilationUnit);
			 
		 }
	}
	public List<CompilationUnit> getUnits() {
		return units;
	}

	public void setUnits(List<CompilationUnit> units) {
		this.units = units;
	}
	public void addCompilationUnit(CompilationUnit unit) {
		units.add(unit);
	}
	public CompilationUnit getCompilationUnit(int index) {
		int size = units.size();
		if(index < 0 || index >= size) {
			return null;
		}
		return units.get(index);
	}
	public int getIndex(CompilationUnit compilationUnit) {
		return units.indexOf(compilationUnit);
	}
}
