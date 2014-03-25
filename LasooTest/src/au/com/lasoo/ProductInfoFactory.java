package au.com.lasoo;

import au.com.lasoo.amazon.AmazonProductInfoParser;
import au.com.lasoo.redballoon.RedballoonProductInfoParser;
import au.com.lasoo.sony.SonyProductInfoParser;

public class ProductInfoFactory {

	public static ProductInfoParser getParserForUrl(String url){
		ProductInfoParser productInfo = null;
		if(url.contains("amazon.com")){
			productInfo = new AmazonProductInfoParser();
		}
		else if(url.contains("redballoon.com")){
			productInfo = new RedballoonProductInfoParser();
		}
		else if(url.contains("sony.com.au")){
			productInfo = new SonyProductInfoParser();
		}
		else{
			productInfo = new ProductInfoParser();
		}
		return productInfo;
	}
}
