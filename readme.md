# ClassLoader

1. 类的加载方式

   是指虚拟机将class文件加载到内存的方式，分为类的显式加载和隐式加载

   - 类的显式加载就是通过反射的方式得到class文件得到对象
   ```java
   public void test(){
    try{
     Class clazz=Class.forName("org.abliger.demo1.TestMyClassLoader");
     ClassLoader.getSystemClassLoader.loadClass("org.abliger.demo1.TestMyClassLoader");
    }catch(Execption e){
    e.printStackTrace();
    }
   }
   ```

   - 类的隐式加载

     隐式加载指不需要在java代码中明确调用加载的代码，而是通过虚拟机自动加载到内存中。比如在加载某个class时，该class引用了另外一个类的对象，那么这个对象的字节码文件就会被虚拟机自动加载到内存中。

     ```java
     public void test(){
     	TestMyClassLoader testMyClassLoader=new TestMyClassLoader();
     }
     ```

     

2. 类的唯一性

   对于任何一个类，都需要一个类加载器，加载该类的class文件，通过双亲委派机制来保证该类只被加载一次

   但如果一个类的class文件是由不同的类加载器加载，那么该两个class就不相同

   即：比较两个类是否相等，只有这两个类是由同一个类加载的才有意义

3. 类加载器的命名空间

   命名空间是由该类加载器以及其父类加载器所构成的，其中上级加载器加载的类对其下级可见，但是反过来子类加载的类对父类不可见，同一个命名空间中一定不会出现同一个类（全限定名，包括包名一模一样的类）多个Class对象，换句话说就是在同一命名空间中只能存在一个Class对象，所以当你听别人说在内存中同一类的Class对象只有一个时其实指的是同一命名空间中。