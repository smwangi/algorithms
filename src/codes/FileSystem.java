import java.io.File;
import java.util.*;

public class FileSystem {
    public enum FileType {
        Directory,
        File
    }
    private class Entity {
        private int entityId;
        private FileType fileType;
        private List<Integer> children;
        private int size;
        private String name;

        public Entity(int entityId, FileType fileType, List<Integer> children, int size, String name) {
            this.children = children;
            this.entityId = entityId;
            this.fileType = fileType;
            this.size = size;
            this.name = name;
        }

        public FileType getFileType() {
            return fileType;
        }

        public int getEntityId() {
            return entityId;
        }

        public int getSize() {
            return size;
        }

        public List<Integer> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }
    }

    public Map<Integer, Entity> fileSystem() {
        Map<Integer, Entity> filesystem = new HashMap<>();
        filesystem.put(1, new Entity(1, FileType.Directory, Arrays.asList(2, 3), 0, "root"));
        filesystem.put(2, new Entity(2, FileType.File, null, 200, "file 3"));
        filesystem.put(3, new Entity(3, FileType.Directory, Arrays.asList(4, 5), 0, "dir1"));
        filesystem.put(4, new Entity(4, FileType.File, null, 100, "file1"));
        filesystem.put(5, new Entity(5, FileType.File, null, 300, "file2"));

        return filesystem;
    }

    static class FileSystemTest {
        static FileSystem fSystem = new FileSystem();
        public static void main(String[] args) {

            fSystem.fileSystem();
           int totalSize = getSize(1);
           System.out.println(totalSize);
        }

        static int getSize(int entityId) {
            int size = 0;
            Entity ent = fSystem.fileSystem()
                    .values()
                    .stream()
                    .filter(e -> e.entityId == entityId)
                    .findFirst()
                    .orElse(null);

            if (ent != null && ent.fileType == FileType.Directory) {
                if (ent.getChildren() != null) {
                    System.out.println(ent.getChildren());
                    size = ent.getChildren().stream().mapToInt(x -> getSize(x.intValue())).sum();
                }
            } else {
                size += ent.size;
            }
            return size;
        }

        private static long diskUsage(Map<Integer, Entity> fs) {
            long total = fs.size();
            for (Map.Entry<Integer, Entity> f : fs.entrySet()) {
                Entity e = f.getValue();
                if (e.fileType == FileType.Directory) {
                    for (int i : e.getChildren()) {
                        // total += diskUsage(f);
                    }
                } else {
                    total += e.size;
                }
            }
            return total;
        }

        private static long diskUsage2(File root) {
            long total = root.length();

            if (root.isDirectory()) {
                for (String chileName : root.list()) {
                    File child = new File(root, chileName);
                    total += diskUsage2(child);
                }
            }
            return total;
        }
    }
}
