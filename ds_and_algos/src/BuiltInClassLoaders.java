import java.sql.Date;

public class BuiltInClassLoaders {
    public static void main(String[] args) {
        BuiltInClassLoaders builtInClassLoaders = new BuiltInClassLoaders();
        ClassLoader classLoader = builtInClassLoaders.getClass().getClassLoader();
        printClassLoaderDetails(classLoader);
        
        // java.sql classes are loaded by platform classloader
        java.sql.Date now = new Date(System.currentTimeMillis());
        ClassLoader platformClassLoader = now.getClass().getClassLoader();
        printClassLoaderDetails(platformClassLoader);
        
        //java.lang classes are loaded by bootstrap classloader
        ClassLoader bootStrapClassLoader = args.getClass().getClassLoader();
        printClassLoaderDetails(bootStrapClassLoader);
    }
    
    private static void printClassLoaderDetails(ClassLoader classLoader) {
        //bootstrap classloader is represented by null in JVM
        if (classLoader != null) {
            System.out.println("ClassLoader name : " + classLoader.getName());
            System.out.println("ClassLoader class : " + classLoader.getClass().getName());
        } else {
            System.out.println("Bootstrap classloader");
        }
    }
}
