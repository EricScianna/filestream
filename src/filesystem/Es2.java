/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Es2 {

    public static void main(String[] args) throws IOException {

        try {
            Path srcPath = FileSystems.getDefault().getPath("Anagrafica.txt");
            Path destPath = FileSystems.getDefault().getPath("Anagrafica-numerata2.txt");

            AtomicInteger i = new AtomicInteger(1);
            Files.write(destPath,
                    Files.lines(srcPath)
                            .map(v -> i.getAndIncrement() + " " + v)
                            .collect(Collectors.toList()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
