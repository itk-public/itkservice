package com.itk.utils;

import com.itk.util.PageInfo;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by yangqi on 2017/5/11.
 */
public class PaginationUtil {

    /**
     * 返回数据前处理分页数据
     *
     * @param page
     * @param baseUrl
     * @return
     * @throws URISyntaxException
     */
    public static HttpHeaders generatePaginationHttpHeaders(PageInfo<?> page, String baseUrl)
            throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotal());
        String urlConnector = "?";
        if (baseUrl.contains("?")) {
            urlConnector = "&";
        }
        String link = "";
        if ((page.getPageNum()) < page.getPages()) {
            link = "<" + (new URI(baseUrl + urlConnector + "pageNum=" + (page.getPageNum()) + "&pageSize=" + page.getPageSize())).toString() + ">, rel=\"next\";";
        }
        // prev link
        if ((page.getPageNum() - 1) > 0) {
            link += "<" + (new URI(baseUrl + urlConnector + "pageNum=" + (page.getPageNum() - 1) + "&pageSize=" + page.getPageSize())).toString() + ">, rel=\"prev\";";
        }
        // last and first link
        int lastPage = 0;
        if (page.getPages() > 0) {
            lastPage = page.getPages();
        }
        link += "<" + (new URI(baseUrl + urlConnector + "pageNum=" + lastPage + "&pageSize=" + page.getPageSize())).toString() + ">, rel=\"last\";";
        link += "<" + (new URI(baseUrl + urlConnector + "pageNum=" + 1 + "&pageSize=" + page.getPageSize())).toString() + ">, rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

}
