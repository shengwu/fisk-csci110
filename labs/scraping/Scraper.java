import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scraper {
	// Pattern for recognizing a URL, based off RFC 3986. Source:
	// http://stackoverflow.com/questions/5713558/detect-and-extract-url-from-a-string
	private static final Pattern URL_PATTERN = Pattern.compile(
			"(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
			+ "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
			+ "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	private static String getPage(String address)
            throws MalformedURLException, IOException {
		URL url = new URL(address);
        Scanner s = new Scanner(url.openStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
	}

	private static List<String> getURLs(String webpageContents) {
		Matcher matcher = URL_PATTERN.matcher(webpageContents);
        List<String> urls = new ArrayList<>();
		while (matcher.find()) {
			int matchStart = matcher.start(1);
			int matchEnd = matcher.end();
            urls.add(webpageContents.substring(matchStart, matchEnd));
		}
        return urls;
	}

	public static void main(String[] args)
            throws MalformedURLException, IOException {
        // This scrapes the example page. It then only prints the URLs on that page.
        //
        // You'll need to replace this URL with the assignment URL.
        String baseUrl = "http://sheng.io/fisk/labs/scraping/example";
        String page = getPage(baseUrl);
        List<String> urls = getURLs(page);
        System.out.println(urls);

		// TODO: use while loops to write code and scrape all 
		// of the pages under sheng.io/fisk/labs/scraping/assignment
	}
}
