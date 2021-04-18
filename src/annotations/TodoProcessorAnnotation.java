package annotations;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("Todo")   // <1>
@SupportedSourceVersion(SourceVersion.RELEASE_11)   // <2>
public class TodoProcessorAnnotation extends AbstractProcessor{   // <3>
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) { // <4>
        Messager messager = processingEnv.getMessager();

        for (TypeElement typeElement : annotations) {   // <5>
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {    // <6>
                Todo todo = element.getAnnotation(Todo.class);  // <7>
                messager.printMessage(Diagnostic.Kind.ERROR,    // <8>
                        "Task '" + todo.value() + "' is pending on " + element);
            }
        }

        return true;    // <9>
    }
}