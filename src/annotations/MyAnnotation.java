package annotations;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;

@Retention(RetentionPolicy.RUNTIME)    //or SOURCE,  or CLASS
@Target(ElementType.TYPE)   // or ElementType.METHOD ...
@Documented      // for javadoc
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {

    String   value() default "";

    String   name();
    int      age();
    String[] newNames();

}