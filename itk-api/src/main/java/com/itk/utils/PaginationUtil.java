package com.itk.utils;

import com.itk.util.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

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
    public static HttpHeaders generatePaginationHttpHeaders(PageInfo<?> page, String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotal());
        String link = "";
        if ((page.getPageNum()) < page.getPages()) {
            link = "<" + generateUri(baseUrl, page.getPageNum(), page.getPageSize()) + ">, rel=\"next\";";
        }
        // prev link
        if ((page.getPageNum() - 1) > 0) {
            link += "<" + generateUri(baseUrl, page.getPageNum() - 1, page.getPageSize()) + ">, rel=\"prev\";";
        }
        // last and first link
        int lastPage = 0;
        if (page.getPages() > 0) {
            lastPage = page.getPages();
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getPageSize()) + ">, rel=\"last\";";
        link += "<" + generateUri(baseUrl, 1, page.getPageSize()) + ">, rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page, String baseUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">, rel=\"next\";";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">, rel=\"prev\";";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">, rel=\"last\";";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">, rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
    }

}
