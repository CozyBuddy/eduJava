package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오후 2:49:52
 * @subject
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) {
		String parsingFile = "hello.xml"; // 해당 파일을 구문분석
		String docType = "xml";
		
		Parseable parser = ParserManager.getParser(docType);
		parser.parse(parsingFile);
		
		System.out.println("End");
	}

}
interface Parseable {
	void parse(String fileName);
	default void print() {
		System.out.println("각각 parser에서 인쇄 기능 구현");
	}
}
// XML 파일을 구문분석하는 클래스
class XMLParser implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println("XML 구문분석");
		
	}
	
	// HTML 파일을 구문분석하는 클래스
}
class HTMLParser implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println("HTML 구문 분석");
		
	}
	
}
//Xml파일 -> XmlParser 로 반환
//Html파일 ->HtmlParser 
class ParserManager{
	// 			   리터자료형:인터페이스    다형성
	public static Parseable getParser(String docType) {
		if (docType.equals("xml")) {
			return new XMLParser();
		} else if (docType.equals("html")){
			return new HTMLParser();
		} else {
			return null;
		}
	}
}
