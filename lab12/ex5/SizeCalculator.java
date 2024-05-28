package ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;


public class SizeCalculator extends SimpleFileVisitor<Path> {
    private final Map<Path, Long> sizes = new HashMap<>();
    private boolean recursive;
    private Path startingDir;

    public SizeCalculator(boolean recursive, Path startingDir) {
        this.recursive = recursive;
        this.startingDir = startingDir;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        sizes.put(file, attrs.size());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        sizes.put(dir, 0L);
        if (!recursive && !dir.equals(startingDir)) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        long total = 0;

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
            for (Path child : ds) {
                total += sizes.getOrDefault(child, 0L);
            }
            sizes.put(dir, total);
        }
        
        return FileVisitResult.CONTINUE;
    }
    
    public void printSizes(Path start) throws IOException {
        printSizesRecursive(start, "", true);
    }

    private void printSizesRecursive(Path dir, String prefix, boolean isRoot) throws IOException {
        if (!Files.isDirectory(dir)) {
            System.out.println(prefix + dir.getFileName() + ": " + sizes.get(dir) + " kB");
            return;
        }

        if ((isRoot || recursive) && !dir.equals(startingDir) ) {
            System.out.println((isRoot ? "" : prefix) + dir.getFileName() + ": " + sizes.get(dir) + " kB");
        }

        if (!recursive && !isRoot) {
            return;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (entry.getParent().equals(startingDir)){
                    printSizesRecursive(entry, prefix, false);
                } else {
                    printSizesRecursive(entry, prefix + "|->", false);
                }
            }
        }

        if (dir.equals(startingDir)) {
            System.out.println("Total: " + sizes.get(startingDir) + " kB");
        }
    }
}


