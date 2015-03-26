package wefunitfixturemaker;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import str.frmt.validators.Factories;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Goal which touches a timestamp file.
 *
 * @goal compileClasses
 * 
 * @phase process-sources
 */
public class MyMojo extends AbstractMojo{

    private Set<String> _fileNames = new LinkedHashSet<>();

    public void execute() throws MojoExecutionException {
        try {
            Files.walkFileTree(Paths.get("samplewefproject/WebContent/WEB-INF/work/source"), new FileScanner());
            System.out.println(_fileNames.toString());
            File[] filesArray = new File[_fileNames.size()];
            int size = _fileNames.size();

            for(int i = 0; i < size; i++){
                filesArray[i] = new File(_fileNames.toArray()[i].toString());
            }
            JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
            Iterable fileObjects = sjfm.getJavaFileObjects(filesArray);
            String [] options = new String[]{ "-d", "samplewefproject/WebContent/WEB-INF/work/classes" };
            jc.getTask(null, null, null, Arrays.asList(options), null, fileObjects).call();
            sjfm.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FileScanner extends SimpleFileVisitor<Path>{

//        private String currentDirectory;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if(Factories.JavaSrcFileNameValidatorFactory.getInstance().
                    isJavaTestSrcFileNameValid(file.getFileName().toString())){
                _fileNames.add(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return super.visitFileFailed(file, exc);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return super.postVisitDirectory(dir, exc);
        }
    }
}