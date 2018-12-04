import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Entry> inputs = new ArrayList<Entry>();
	    while (true){
	        String str = sc.nextLine();
	        if (str.equals(""))
                break;
            String[] str_arr = str.split(",");
            try {
                Entry entry = new Entry(str_arr);
                inputs.add(entry);
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            } catch (NumberFormatException e){
                e.printStackTrace();
            } catch (InvalidParameterException e){
                e.printStackTrace();
            }
        }

	    for (Entry s: inputs){
            System.out.println(s.serialize());
        }
    }
}
