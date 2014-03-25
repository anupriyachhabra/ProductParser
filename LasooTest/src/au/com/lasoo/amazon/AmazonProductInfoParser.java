package au.com.lasoo.amazon;

import org.jsoup.nodes.Element;

import au.com.lasoo.ProductInfoParser;

public class AmazonProductInfoParser extends ProductInfoParser{
//example : http://www.amazon.com/Fascinations-MAGICFB1-Magic-Fishbowl/dp/B000VHYNMI%3FSubscriptionId%3DAKIAIAIB6OSAIC2XKPUQ%26tag%3Dws%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB000VHYNMI
	@Override
	public String getImage(){
		String img=null;
		Element element = document.select("#landingImage").first();
		if(element!=null){

			img = element.attr("src");
		}
		return img;
	}
	@Override
	public String getName(){
		String name =null;
		Element element =  document.select("#productTitle").first();
		if(element!=null){

			name = element.html();
		}
		return name;
	}
	@Override
	public String getPrice(){
		String price =null;
		Element element = document.select("#priceblock_ourprice").first();
		if(element!=null){

			price = element.html();
		}
		return price;
	}
	@Override
	public String getDescription(){
		String description =null;
		Element element = document.select("#featurebullets_feature_div").first();
		if(element!=null){

			description = element.html();
		}
		return description;
	}

}
