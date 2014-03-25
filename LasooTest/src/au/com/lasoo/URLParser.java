package au.com.lasoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;

public class URLParser {

	public static void main (String args[]){
		ProductInfoParser getProductInfo = null;
		String isContinue = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			do{
				System.out.print("Enter URL to extract product information from => ");

				URL url;

				String input = br.readLine();

				url = new URL(input);
				getProductInfo= ProductInfoFactory.getParserForUrl(input);
				getProductInfo.setDocument(Jsoup.parse(url,30000));
				System.out.println("Product Name : "+(getProductInfo.getName()==null?"Not Available":getProductInfo.getName()));
				System.out.println("Image URL : "+(getProductInfo.getImage()==null?"Not Available":getProductInfo.getImage()));
				System.out.println("Price : "+(getProductInfo.getPrice()==null?"Not Available":getProductInfo.getPrice()));
				System.out.println("Description : "+(getProductInfo.getDescription()==null?"Not Available" :getProductInfo.getDescription()));

				System.out.print("Continue extracting (press Y to continue) :");
				isContinue = br.readLine();
				
			}while("Y".equalsIgnoreCase(isContinue.trim()));
			br.close();
		} catch (MalformedURLException e) {
			System.out.println("Unable to get Product information");
		} catch (IOException e) {
			System.out.println("Unable to get Product information");
		}


	}
}
