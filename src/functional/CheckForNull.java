package functional;
import java.util.function.Predicate;

public class CheckForNull  implements Predicate<String> {
		@Override
		public boolean test(String t) {
			return t!=null;
		}
}