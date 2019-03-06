package client;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import model.Book;

public class ParseBooks {

		boolean inBooks = false;
		boolean inBook = false;
		boolean inId = false;
		boolean inAuthor = false;
		boolean inTitle = false;
		boolean inYear = false;
		
		Book currentBook;
		List<Book> currentBookList;

	public List<Book> doParseBooks(String s) {
		// TODO Auto-generated method stub
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return currentBookList;
	}

	private void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException{
		// TODO Auto-generated method stub
		int eventType = pullParser.getEventType();
		do {
			if(eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} else if(eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} else if(eventType == XmlPullParser.START_TAG) {
				;
			} else if(eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} else if(eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} else if(eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			}
		}
	}

}
