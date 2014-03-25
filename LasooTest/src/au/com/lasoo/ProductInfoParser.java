package au.com.lasoo;

import org.jsoup.nodes.Document;
//http://www.smartbuyglasses.co.nz/designer-eyeglasses/Lafont/Lafont-Damoiselle-347-91768.html?feed=nz+lasoo
//http://www.visiondirect.com.au/designer-sunglasses/Calvin-Klein/Calvin-Klein-7414S-033-A-95159.html?feed=au+lasoo
import org.jsoup.nodes.Element;
/*
 * examples
 * http://www.visiondirect.com.au/designer-sunglasses/Calvin-Klein/Calvin-Klein-7414S-033-A-95159.html?feed=au+lasoo

http://www.smartbuyglasses.co.nz/designer-eyeglasses/Lafont/Lafont-Damoiselle-347-91768.html?feed=nz+lasoo

 */
public class ProductInfoParser {
	protected Document document;
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String getImage(){
		String img=null;
		Element element = getElement("image");
		if(element!=null){

			img = element.attr("src");
		}
		return img;
	}
	public String getName(){
		String name =null;
		Element element = getElement("name");;
		if(element!=null){

			name = element.html();
		}
		return name;
	}
	public String getPrice(){
		String price =null;
		Element element = getElement("price");;
		if(element!=null){

			price = element.html();
		}
		return price;
	}
	public String getDescription(){
		String description =null;
		Element element = getElement("description");
		if(element!=null){

			description = element.html();
		}
		return description;
	}
	protected Element getElement(String tag){
		Element element = null;
		element = document.select("[itemprop="+tag+"]").first(); // checks itemprop attribute of all elements in document with value = tag
		if(element == null){
			element = document.select("#"+tag).first(); //gets element with id = tag
		}
		if(element == null){
			element = document.select("."+tag).first(); //gets element with class = tag
		}
		return element;
	}
}
