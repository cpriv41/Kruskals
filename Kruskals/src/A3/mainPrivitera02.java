package A3;
import java.io.File;
import java.io.FileNotFoundException;

public class mainPrivitera02{

public static void main(String[] args) throws FileNotFoundException {
	try {

		if (args.length < 1) {
			System.out.println("Must specify inputFileName from command line");
			System.exit(1);
		}
		if (args.length == 1) {

			new KruskalsMSTPrivitera02(new File(args[0]));

		} else if (args.length > 1) {
			for (String input : args) {
				new KruskalsMSTPrivitera02(new File(input));
			}
		} else {
			System.out.println("Must specify inputFileName from command line");
			System.exit(1);
		}

	} catch (Exception e) {
		System.out.print(e.getClass());
	}

}
}

