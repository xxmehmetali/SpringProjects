package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class A {
    @Autowired
    private B b;

    @Autowired
    private A a;

    @Autowired
    private C c;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m1() {
        b.m2(); // will create a new transaction // B.class??? NOO  EnhancerBySpringCGLIB$$ec44bc4b
        this.m2(); // won't create a new transaction // A.class YESS
        a.m2(); // a new transaction will be created
        // why????
        /**
          Below is provided the outputs.
          when you call any method in this class without accessing the context, it will be only an object from java.
         so any transaction or aop operation will not be valid on calling.
         to make it valid, you have to inject class itself.

         We see that B class is actually beans.B$$EnhancerBySpringCGLIB$$fa1442a7
         this is called proxy that means spring can intercept the class and add extra functionality on the object
         https://medium.com/@s.sreejith/proxy-in-spring-e21ffbb2953a
         PROXY IN SPRING

         */
        System.out.println(b.getClass()); // class beans.B$$EnhancerBySpringCGLIB$$fa1442a7
        System.out.println(this.getClass()); // class beans.A
        System.out.println(a.getClass()); // class beans.A$$EnhancerBySpringCGLIB$$e678ba04
        System.out.println(c.getClass());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m2() {

    }
}
