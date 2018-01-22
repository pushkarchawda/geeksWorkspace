import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

public class Test00 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String filename, outFilename;
		String sCurrentLine;
		String split[];
		StringBuilder output = new StringBuilder("");

		HashMap<String, Integer> hm = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		filename = sc.nextLine();//"hosts_access_log_00.txt";// 
		outFilename = "req_" + filename;
		// System.out.println(outFilename);

		FileReader in = new FileReader(filename);//("F:\\Study\\Codes\\workspace\\geeks\\src\\" + filename);
		BufferedReader fIn = new BufferedReader(in);

		FileWriter out = new FileWriter(outFilename);
		BufferedWriter fOut = new BufferedWriter(out);

		while ((sCurrentLine = fIn.readLine()) != null) {

			split = sCurrentLine.split(" ");
			String check = split[3].substring(1, split[3].length());
			// System.out.println(check);
			if (hm.containsKey(check)) {
				int x = hm.get(check);
				int i = hm.get(check);
				if (i == 1)
					output.append(check + "\n");
				hm.put(check, ++x);

			} else {
				hm.put(check, 1);
			}
		}

		//System.out.println(output.toString());
		fOut.write(output.toString());
		
		fOut.close();
		fIn.close();
		out.close();
		in.close();

	}

}
