public class ConcurrentDemo {
    public synchronized void step1(){
        System.out.println("step1");
        step2();
    }
    public synchronized void step2(){
        System.out.println("step2");
    }

    public static void main(String[] args){
//        new ConcurrentDemo().step1();
        ClassLoader classLoader = ConcurrentDemo.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        System.out.println(parent.getParent());
    }

}
