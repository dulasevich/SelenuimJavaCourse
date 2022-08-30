import org.apache.hc.client5.http.classic.methods.HttpHead;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ProtocolException;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.DownloadPage;

import java.io.IOException;

public class DownLoadTest extends BaseTest {

    private final static String URL = "http://the-internet.herokuapp.com/download";
    private final DownloadPage downloadPage = new DownloadPage();

    private boolean checkIfFileIsReadyToBeDownloaded() throws ProtocolException, IOException {
        driver.get(URL);
        String link = driver.findElement(By.linkText("sample.txt")).getAttribute("href");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);

        String contentType = httpClient.execute(request).getHeader("Content-type").getValue();
        int contentLength = Integer.parseInt(httpClient.execute(request).getHeader("Content-length").getValue());
        if (contentType.equals("application/octet-stream") && contentLength != 0){
            return true;
        }
        return false;
    }

    @Test
    void downloadFile() throws IOException, ProtocolException {
        Assumptions.assumeTrue(checkIfFileIsReadyToBeDownloaded());
        driver.get(URL);
        downloadPage.download();
    }
}
