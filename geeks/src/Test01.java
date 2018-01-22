import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test01 {
	
	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		int page, per_page, total, total_pages;
		String data;
		/*
		{   "page":1,
			"per_page":10,
			"total":0,
			"total_pages":0,
			"data":[]}
		*/
		
		
		
		
		String s = response.toString();
		String splitpage[] = s.split(",");
		
			page = Integer.parseInt(splitpage[0].split(":")[1]);
			per_page = Integer.parseInt(splitpage[1].split(":")[1]);
			total = Integer.parseInt(splitpage[2].split(":")[1]);
			total_pages = Integer.parseInt(splitpage[3].split(":")[1]);
			
			
			String output[] = new String[per_page];
			int count = 0;
			
			System.out.println(page+" "+per_page+" "+total+" "+total_pages);
			
			
			String url1 = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=";
			
		while((total_pages)>=0)
		{
			String url2 = url1+page;
			URL obj1 = new URL(url2);
			HttpURLConnection conn = (HttpURLConnection) obj1.openConnection();
			System.out.println(" url 2 :" +url2);
			conn.setRequestMethod("GET");
			//add request header
			conn.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode1 = conn.getResponseCode();
			BufferedReader in1 = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine1;
			StringBuffer response1 = new StringBuffer();
			while ((inputLine1 = in1.readLine()) != null) {
				response1.append(inputLine1);
			}
			total_pages--;
			
			String[] s1 = response1.toString().split("Title");
			String splitpage1[] = s1[1].split(",");
			String data3[] = splitpage1[0].split(":");
			String[] data2 = data3[3].split(",");
			String imp[];
			
			System.out.println(s1[1]);
			
			for(int j = 0;j<data2.length;j++)
			{
				imp = data2[j].split(":");
				System.out.println(imp[3]);
			}
			
			//System.out.println(response1.toString());
			in1.close();
		}
			
			// optional default is GET
			
			
			
			
		//System.out.println(splitpage[1]);

		//print result
		//System.out.println(response.toString());

	}

}
