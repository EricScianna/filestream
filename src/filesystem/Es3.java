/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class Es3 {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("");

        try (Stream<Path> s1 = Files.walk(path, 1);
                Stream<Path> s2 = Files.walk(path)) {

            Files.walk(path, 1)
                    .filter(p -> !Files.isDirectory(p))
                    .filter(p -> p.getFileName().toString().endsWith(".txt"))
                    .forEach(p -> System.out.println(p.getFileName()));

            Files.list(path)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(v -> v.endsWith(".txt"))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
