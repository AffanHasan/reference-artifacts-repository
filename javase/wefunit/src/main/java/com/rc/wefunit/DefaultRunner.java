package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;
import str.frmt.validators.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

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

    @Override
    public Set<String> scanTestClasses() {
        if(!this.isValidWefWebInfDirectory())
            throw new IllegalStateException("Scan for test classes failed; no valid Web Experience Factory WEB-INF path found");

        final Set<String> qualifiedFileNames = new LinkedHashSet<String>();

        class FileScanner extends SimpleFileVisitor<Path> {

            private String parseClassQualifiedNameFromPath(String path){
                String absolutePath = path.split((isWindows() ? "work\\classes\\" : "work/classes/"))[1];
                absolutePath = absolutePath.replace((isWindows() ? '\\' : '/'), '.');
                return absolutePath;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(str.frmt.validators.Factories.JavaTestClasscFileNameValidatorFactory.getInstance().
                        isJavaTestClassFileNameValid(file.getFileName().toString())){
                    qualifiedFileNames.add(parseClassQualifiedNameFromPath(file.toString()));
                }
                return FileVisitResult.CONTINUE;
            }

        }
        try {
            Files.walkFileTree(Paths.get( getWebInfDirPath() + ( isWindows() ? "\\work\\classes\\test" : "/work/classes/test" ) ),
                    new FileScanner());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qualifiedFileNames;
    }

}