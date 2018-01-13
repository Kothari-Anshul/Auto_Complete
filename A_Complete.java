import java.io.*;
import java.util.Scanner;
public class A_Complete {
	private TST<Boolean> dictionary;
	public A_Complete(){
		dictionary = new TST<Boolean>();
		try{
			BufferedReader r = new BufferedReader(new FileReader("words.txt"));
			String str;
			while((str = r.readLine()) != null){
				dictionary.put(str.toLowerCase(), true);
			}
			
		}
		catch(IOException e){
			System.out.println("Something went wrong");
		}
	}
	public Iterable<String> suggestions(String prefix){
		prefix = prefix.toLowerCase();
		if(isValid(prefix) == false){
			return null;
		}
		return dictionary.keys_starts_with(prefix);
	}
	public boolean isValid(String s){
		// check for validity, i.e must contain only a-z character
		return s.matches("[a-z]+");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A_Complete feature = new A_Complete();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type 'exit' to exit from the program or type any prefix to continue!");
		String input = sc.nextLine();
		while(true){
			if(input.equals("exit")){
				break;
			}
			System.out.println("Below is the list of suggestions to choose from:");
			for(String x: feature.suggestions(input)){
				System.out.println(x);
			}
			input = sc.nextLine();
		}
		
		

	}

}
