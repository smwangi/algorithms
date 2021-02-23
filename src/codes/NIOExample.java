import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.EnumSet;
import java.util.Set;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.StandardOpenOption.*;

public class NIOExample {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("E:/crmlogs/crm.txt");
        System.out.println(path.getFileName()+" "+path.getName(0)+" "+path.getParent()+" "+path.getRoot());
        Path p = path.toRealPath();
        System.out.println(p.getFileName());
        if(path.equals(p))System.out.println("Equal");

        boolean isReqExecutable = Files.isExecutable(p) & Files.isReadable(p) & Files.isWritable(p);
        System.out.println(isReqExecutable);
        UserPrincipal owner = p.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("samwan");
        System.out.println(owner.getName());

        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for(Path name:dirs){
            System.err.println(name);
        }

        Path test = Path.of("E:\\xampp\\htdocs");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(test)) {
            for (Path file: stream){
                System.out.println(file.getFileName());
            }
        }catch (IOException | DirectoryIteratorException x){
            System.err.println(x);
        }
        /*ReadableByteChannel rbc = Files.newByteChannel(path, EnumSet.of(READ));

        //Open file for reading
        WritableByteChannel wbc = Files.newByteChannel(path,EnumSet.of(CREATE,APPEND));

        //Create file with initial permissions opening it for both reading and writing
        FileAttribute<Set<PosixFilePermission>> perms = PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwxrwxrwx"));
        SeekableByteChannel sbc = Files.newByteChannel(path,EnumSet.of(CREATE_NEW,READ,WRITE),perms);
        sbc.size();*/
        FileOutputStream fout = new FileOutputStream(path.getFileName().toString());
        FileChannel fileChannel = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < 5;i++){
            buffer.putInt(i);
        }
        buffer.flip();
        fileChannel.write(buffer);

        PrintFiles printFiles=new PrintFiles();
        Files.walkFileTree(test,printFiles);
        //printFiles.postVisitDirectory(test,BasicFileAttributes.class);
    }

    /**
     * Here is an example that extends SimpleFileVisitor to print all entries in a file tree.
     * It prints the entry whether the entry is a regular file, a symbolic link, a directory,
     * or some other "unspecified" type of file. It also prints the size, in bytes, of each file.
     * Any exception that is encountered is printed to the console.
     */
    static class PrintFiles extends SimpleFileVisitor<Path>{
        // Print information about
        // each type of file.

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(attrs.isSymbolicLink()){
                System.out.format("Symbolic link: %s ",file);
            }else if (attrs.isRegularFile()){
                System.out.format("Regular file is: %s ",file);
            }else {
                System.out.format("Other: %s ",file);
            }
            System.out.println("("+attrs.size()+ "bytes)");
            return CONTINUE;
        }
        // Print each directory visited.

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.format("Directory: %s%n",dir);
            return CONTINUE;
        }
        // If there is some error accessing
        // the file, let the user know.
        // If you don't override this method
        // and an error occurs, an IOException
        // is thrown.

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println(exc);
            return CONTINUE;
        }
    }
}
