package com.seu.ast.util;

import java.io.File;
import java.util.ArrayList;

public class FilePaths {
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
