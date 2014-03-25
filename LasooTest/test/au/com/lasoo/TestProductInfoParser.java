package au.com.lasoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProductInfoParser {
	 ProductInfoParser getProductInfo;
	 @Before
     public void setUp() {
		 getProductInfo = new ProductInfoParser();
     }
	
     @After
     public void tearDown() {
    	 getProductInfo = null;
     }
	@Test
	public void testGetImage() 
	{
		StringBuffer html = new StringBuffer(); 
		html.append("<html>");
		html.append("<body>");
		html.append("<img id='big_image' class='big_image' alt=' Glasses - Lafont Damoiselle' src='http://cdn4.smartbuyglasses.co.nz/public/images/designer_eyeglasses/Lafont/Lafont Damoiselle 347.jpg' title='Lafont Damoiselle' itemprop='image'>");
		html.append("</body>");
		html.append("</html>");
		Document document = Jsoup.parse(html.toString());
		getProductInfo.setDocument(document);
		assertEquals("http://cdn4.smartbuyglasses.co.nz/public/images/designer_eyeglasses/Lafont/Lafont Damoiselle 347.jpg", getProductInfo.getImage());
	  }
	@Test
	public void testGetName()
	{
		StringBuffer html = new StringBuffer(); 
		html.append("<html>");
		html.append("<body>");
		html.append("<h1 itemprop='name'>Lafont Damoiselle 347</h1>");
		html.append("<img id='big_image' class='big_image' alt=' Glasses - Lafont Damoiselle' src='http://cdn4.smartbuyglasses.co.nz/public/images/designer_eyeglasses/Lafont/Lafont Damoiselle 347.jpg' title='Lafont Damoiselle' itemprop='image'>");
		html.append("</body>");
		html.append("</html>");
		Document document = Jsoup.parse(html.toString());
		getProductInfo.setDocument(document);

     //  URL url= new URL("http://www.smartbuyglasses.co.nz/designer-eyeglasses/Lafont/Lafont-Damoiselle-347-91768.html?feed=nz+lasoo");
		//Document document = Jsoup.parse(url,30000);
		
		assertEquals("Lafont Damoiselle 347", getProductInfo.getName());
	  }
	@Test
	public void testGetPrice()
	{
		StringBuffer html = new StringBuffer(); 
		html.append("<html>");
		html.append("<body>");
		html.append("<h1 itemprop='name'>Lafont Damoiselle 347</h1>");
		html.append("<img id='big_image' class='big_image' alt=' Glasses - Lafont Damoiselle' src='http://cdn4.smartbuyglasses.co.nz/public/images/designer_eyeglasses/Lafont/Lafont Damoiselle 347.jpg' title='Lafont Damoiselle' itemprop='image'>");
		html.append("<span itemprop='price'>NZ$316.95</span>");
		html.append("</body>");
		html.append("</html>");
		Document document = Jsoup.parse(html.toString());
		getProductInfo.setDocument(document);

     //  URL url= new URL("http://www.smartbuyglasses.co.nz/designer-eyeglasses/Lafont/Lafont-Damoiselle-347-91768.html?feed=nz+lasoo");
		//Document document = Jsoup.parse(url,30000);
		
		assertEquals("NZ$316.95", getProductInfo.getPrice());
	}
	@Test
	public void testGetDescription()
	{
		StringBuffer html = new StringBuffer(); 
		html.append("<html>");
		html.append("<body>");
		html.append("<h1 itemprop='name'>Lafont Damoiselle 347</h1>");
		html.append("<img id='big_image' class='big_image' alt=' Glasses - Lafont Damoiselle' src='http://cdn4.smartbuyglasses.co.nz/public/images/designer_eyeglasses/Lafont/Lafont Damoiselle 347.jpg' title='Lafont Damoiselle' itemprop='image'>");
		html.append("<span itemprop='price'>NZ$316.95</span>");
		html.append("<p itemprop='description'>Get these sensational Calvin Klein 7414S in Silver Anthracite . Order your Calvin Klein 7414S from VisionDirect and relax knowing you have a 24 month warranty. To top it off each pair comes with free professional lens care cleaning kit as well.</p>");
		html.append("</body>");
		html.append("</html>");
		Document document = Jsoup.parse(html.toString());
		getProductInfo.setDocument(document);

		assertNotNull(getProductInfo.getDescription());
	}
}
