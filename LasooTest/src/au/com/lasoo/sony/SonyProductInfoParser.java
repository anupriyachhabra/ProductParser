package au.com.lasoo.sony;

import org.jsoup.nodes.Element;

import au.com.lasoo.ProductInfoParser;

public class SonyProductInfoParser extends ProductInfoParser {
// example url:	http://www.sony.com.au/product/ALC-B55/sku/alc-b55__m++ae?site=hp_en_AU_i
	@Override
	public String getImage(){
		String img=null;
		Element element = document.select("div.gallery_content img").first();
		if(element!=null){

			img = element.attr("src");
		}
		return img;
	}
	@Override
	public String getName(){
		String name =null;
		Element element =  document.select("h1.HeaderText").first();
		if(element!=null){

			name = element.html();
		}
		return name;
	}
	@Override
	public String getPrice(){
		String price =null;
		Element element = document.select(".price >strong").first();
		if(element!=null){

			price = element.html();
		}
		return price;
	}

}
