package annotations;

import java.lang.annotation.Annotation;

@MyAnnotation(age = 10, name = "sddsds", newNames = { "asasa" })
public class Test {

	public static void main(String[] args) {

		Class<Test> classobj = Test.class;
		Annotation[] aList = classobj.getAnnotations();

		for (Annotation annotationRow : aList) {

			MyAnnotation myAnn = (MyAnnotation) annotationRow;
			System.out.println(myAnn.age());
		}
	}
	
	
	 @SafeVarargs
	public static <T> T[] unsafe(T... elements) {
		return elements;
		 
	 }

}
