package renderManager.graphics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TileManager {
	private List<Tile> tiles = new ArrayList<>();

	public TileManager() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new File("sources/others/tilemap.xml"));
			doc.getDocumentElement().normalize();
//			Element element = (Element) doc.getElementsByTagName("layer").item(0);
			String input = doc.getElementsByTagName("data").item(0).getTextContent().replaceAll("\\s+", "");
			String[] elements = input.split(",");
			int x = 0, y = 0;

			for (int index = 0; index < elements.length; index++) {

				tiles.add(new Tile(x, y, Integer.parseInt(elements[index])));
				x += 16;
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
