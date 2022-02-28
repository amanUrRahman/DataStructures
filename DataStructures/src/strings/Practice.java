package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Practice {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//System.out.println(response);
		
		String newresponse1 = response.toString();
		
		System.out.println(newresponse1);
  
		String newresponse2[] = response.toString().replace("{", "").replace("\"", "").replace("}", "").replace(",", "").replace(":", " ").split(" ");
				
		
		
		for (int i = 0; i < newresponse2.length; i++) {		
			System.out.println(newresponse2[i]);
			if (newresponse2[i].equalsIgnoreCase("description"))
				 System.out.println(newresponse2[i+1]);
		}
	}
}
		
