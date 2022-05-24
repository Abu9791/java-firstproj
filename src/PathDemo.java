import java.io.IOException;
import java.nio.file.*;
public class PathDemo {
    public static void main(String[] args) throws IOException {
       Path path=Paths.get("F:\\Abu Talha\\abu siddick");
//       Files.createDirectory(path);
       Files.delete(path);
    } 
    
}
