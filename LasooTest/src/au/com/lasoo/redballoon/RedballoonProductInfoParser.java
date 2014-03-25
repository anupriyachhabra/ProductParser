package au.com.lasoo.redballoon;

import org.jsoup.nodes.Element;

import au.com.lasoo.ProductInfoParser;

public class RedballoonProductInfoParser extends ProductInfoParser {
//example http://www.redballoon.com.au/creative-gifts/art-craft-classes/resin-jewellery-workshop/?affiliateId=991

	@Override
	public String getName() {
		String name =null;
		Element element =  document.select("h1.fn").first();
		if(element!=null){

			name = element.html();
		}
		return name;
	}

}
