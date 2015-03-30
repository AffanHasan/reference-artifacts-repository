package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Affan Hasan on 3/24/15.
 */
public class DefaultRunner implements Runner {

    private boolean isWindows(){
        return System.getProperty("os.name").contains("Windows");
    }

    @Override
    public String getWebInfDirPath() {
        return SystemProperties.getWebInfDir();
    }

    private boolean isValidWefWebInfDirectory(){

        String path = this.getWebInfDirPath();
        boolean isModelsFolderPresent = false, isWorkFolderPresent = false;
        File file = new File(path);
        if(file.isDirectory() && path.endsWith("WEB-INF")){
            for(File item : file.listFiles()){
                if(item.getName().equals("models"))
                    isModelsFolderPresent = true;
                if(item.getName().equals("work"))
                    isWorkFolderPresent = true;
            }
            if( isModelsFolderPresent && isWorkFolderPresent )
                return true;
        }
        return false;
    }

    private final Set<String> _qualifiedFileNames = new LinkedHashSet<String>();

    @Override
    public Set<String> scanTestClasses() {

        if(!this.isValidWefWebInfDirectory()) {
            throw new IllegalStateException("Scan for test classes failed; no valid Web Experience Factory WEB-INF path found");
        }
        _qualifiedFileNames.clear();
        new FileTreeWalker().walkFileTree(
                new File( getWebInfDirPath() + ( isWindows() ? "\\work\\classes\\test" : "/work/classes/test" )),
                new TestClassFileVisitor());

        return _qualifiedFileNames;
    }

    private class TestClassFileVisitor{

        private String parseClassQualifiedNameFromPath(String path){
            String absolutePath = path.split((isWindows() ? "work\\\\classes" : "work/classes"))[1];
            absolutePath = absolutePath.replace((isWindows() ? '\\' : '/'), '.');
            absolutePath = absolutePath.replaceFirst("\\Q.\\E", "").trim();
            absolutePath = absolutePath.split("\\Q.\\Eclass")[0];
            return absolutePath;
        }

        public void visitFile(File file) throws IOException {

            if(str.frmt.validators.Factories.JavaTestClasscFileNameValidatorFactory.getInstance().
                    isJavaTestClassFileNameValid(file.getName())){
                _qualifiedFileNames.add(parseClassQualifiedNameFromPath(file.getPath()));
            }
        }
    }

    private class FileTreeWalker{

        class DirectoryFilter implements FilenameFilter{

            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory();
            }
        }

        public void walkFileTree(File rootDir, TestClassFileVisitor testClassFileVisitor){

            File file = rootDir;

            if(file.isDirectory()){

                for( File item : file.listFiles() ){
                    try {
                        testClassFileVisitor.visitFile(item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                File[] directories = file.listFiles(new DirectoryFilter());
                for( File dir : directories ){
                    this.walkFileTree(dir, testClassFileVisitor);//Recursion
                }
            }
        }
    }

    @Override
    public Set<Class> getTestClassesSet(ClassLoader cl) throws ClassNotFoundException {
        Set<Class> classesSet = new LinkedHashSet<Class>();
        for( String className : this.scanTestClasses()){
            classesSet.add( Class.forName(className, true, cl));
        }
        return classesSet;
    }
}