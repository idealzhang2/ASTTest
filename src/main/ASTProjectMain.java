package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.seu.ast.node.ClassNode;
import com.seu.ast.node.ClassNodeInMethod;
import com.seu.ast.node.CompilationNode;
import com.seu.ast.node.MethodNode;
import com.seu.ast.node.ProjectNode;
import com.seu.ast.util.ASTResultCreator;

public class ASTProjectMain {
	
	public static void main(String[] args) throws Exception {
		Compalition compalition = new Compalition();
		String path = "E:\\idealzhang\\MRSBWSys";
		ASTResultCreator creator = new ASTResultCreator();
		creator.creatAST(path);
		ProjectNode projectNode = creator.getProjectNode();
		List<CompilationNode> list = projectNode.getCompilationNodes();
		//System.out.println(list.size());
	for(CompilationNode node:list) {
		
		List<ClassNode>  ll = node.getUnitlist();
		for(ClassNode cn: ll) {
			System.out.println("class Name:     "+cn.getName()+"   Number of SubMethod:  "+cn.getMethodlist().size());
			 List<MethodNode> mc = cn.getMethodlist();
			 for(MethodNode md:mc) {
				 if(md.getSubclass().size() > 0) {
					 ArrayList<ClassNodeInMethod> inMethods=md.getSubclass();
					 for(ClassNodeInMethod method:inMethods) {
						 System.out.println(method.getClassname()+"    "+method.getName());
						 for(String tt:method.getMethod()) {
							 System.out.print(tt+"        ");
						 }
					 }
				 }
				// System.out.println("Method Name:  "+md.getName()+"        Number of Subclass:  "+ md.getSubclass().size());
			 }
		}
	}
//		for(CompilationNode node:projectNode.getCompilationNodes()) {
//			for(ClassNode classNode :node.getUnitlist()) {
//				System.out.println(" class name "+classNode.getName()+" { ");
//				for(MethodNode methodNode:classNode.getMethodlist()) {
//					System.out.println(" Method Name: "+methodNode.getName()+"  { ");
//					for(ClassNodeInMethod inMethod:methodNode.getSubclass()) {
//						System.out.println(" Inner Class: " + inMethod.getClassname()+"     "+inMethod.getName()+"  {");
//						for(String tem :inMethod.getMethod()) {
//							System.out.println("	Inner Method: "+tem);
//						}
//						System.out.println(" } ");
//					}
//					System.out.println(" } ");
//				}
//				System.out.println(" } ");
//			}
//			
//		}
//		compalition.searchfiles(path);
//		for(String tem:compalition.getSrclist()) {
//			System.out.println(tem);
//		}
//		for(String tem:compalition.getClasspathlist()) {
//			System.out.println(tem);
//		}
//		for(String tem:compalition.getJarpathlist()) {
//			System.out.println(tem);
//		}
	}

}

class Compalition{
	 private ArrayList<String> srclist = new ArrayList<String>();
	 private ArrayList<String> classpathlist = new ArrayList<String>();
	 private ArrayList<String>  jarpathlist = new ArrayList<String>();
	 
	 public ArrayList<String> getSrclist() {
		return srclist;
	}

	public void setSrclist(ArrayList<String> srclist) {
		this.srclist = srclist;
	}

	public ArrayList<String> getClasspathlist() {
		return classpathlist;
	}

	public void setClasspathlist(ArrayList<String> classpathlist) {
		this.classpathlist = classpathlist;
	}

	public ArrayList<String> getJarpathlist() {
		return jarpathlist;
	}

	public void setJarpathlist(ArrayList<String> jarpathlist) {
		this.jarpathlist = jarpathlist;
	}

	public void searchfiles(String path) {
		 File directory = new File(path);
			ArrayList<File> directs = new ArrayList<File>();
			directs.add(directory);
			while(!directs.isEmpty()) {
				File indirect = directs.get(0);
				directs.remove(0);
				File[] files = indirect.listFiles();
				if(files == null) {
					continue;
				}
				for(File listfile:files) {
					if(listfile.isDirectory()) {
						directs.add(listfile);
					}else if(listfile.getName().endsWith(".java")) {
						srclist.add(listfile.getAbsolutePath());
					}else if(listfile.getName().endsWith(".class")) {
						classpathlist.add(listfile.getAbsolutePath());
					}else if(listfile.getName().endsWith(".jar")) {
						jarpathlist.add(listfile.getAbsolutePath());
					}
				}
			}
	 }
}