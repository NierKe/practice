import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
//test
public class Test01 {
    public void test(){

    }
}
@Target(value = {ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@interface MyAnnotation{

}
