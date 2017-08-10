package com.itk.item.web;

import com.itk.item.model.ItemInfo;
import com.itk.item.service.ItemInfoFrontServiceImpl;
import com.itk.solr.model.SolrItem;
import com.itk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/api/item/itemInfo")
public class ItemInfoController {

    @Autowired
    private ItemInfoFrontServiceImpl itemInfoFrontService;

    @Autowired
    MessageSource exceptionSource;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<WebResult> addItemInfo(@RequestBody ItemInfo itemInfo)  {
        itemInfoFrontService.addItemInfo(itemInfo);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.ADD_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<WebResult> updateItemComment(@RequestBody ItemInfo itemInfo)  {
        itemInfoFrontService.updateItemInfo(itemInfo);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.EDIT_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }

    @RequestMapping(value = "/deleteItemInfo/{itemInfoId}", method = RequestMethod.DELETE)
    public ResponseEntity<WebResult> delItemInfo(@PathVariable(value = "itemInfoId") Integer itemInfoId)  {
        itemInfoFrontService.delItemInfo(itemInfoId);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.DELETE_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }


    @RequestMapping(value = "/selectByCategoryIdAndStatus", method = RequestMethod.GET)
    public ResponseEntity<WebResult> selectByCategoryIdAndStatus(@RequestParam("categoryId") Long categoryId,
                                                                 @RequestParam("status") Integer status)  {
        return ResponseEntity.ok(
                WebResult.ok(itemInfoFrontService.selectByCategoryIdAndStatus(categoryId, status)
                )
        );
    }

    @RequestMapping(value = "/selectByShopIdAndStatus", method = RequestMethod.GET)
    public ResponseEntity<WebResult> selectByShopIdAndStatus(@RequestParam("shopId") Long shopId,
                                                             @RequestParam("status") Integer status)  {
        return ResponseEntity.ok(
                WebResult.ok(itemInfoFrontService.selectByShopIdAndStatus(shopId, status)
                )
        );
    }

    @RequestMapping(value = "/selectByShopCategoryIdAndStatus", method = RequestMethod.GET)
    public ResponseEntity<WebResult> selectByShopCategoryIdAndStatus(@RequestParam("shopCategoryId") Integer shopCategoryId,
                                                                     @RequestParam("status") Integer status)  {
        return ResponseEntity.ok(
                WebResult.ok(
                        itemInfoFrontService.selectByShopCategoryIdAndStatus(shopCategoryId, status)
                )
        );
    }

    @RequestMapping(value = "/selectByItemId", method = RequestMethod.GET)
    public ResponseEntity<WebResult> selectByItemId(@RequestParam("itemId") String itemId)  {
        return ResponseEntity.ok(
                WebResult.ok(
                        itemInfoFrontService.selectByItemId(itemId)
                )
        );
    }

    /**
     * 根据关键字查询商品信息
     *
     * @param keyword
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<WebResult> searchByKeyword(@RequestParam String keyword,
                                                     PageParam pageable) {
        PageInfo<SolrItem> page = itemInfoFrontService.searchByKeyword(keyword, pageable);
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(page, "api/item/itemInfo/search?keyword=" + keyword);
        return new ResponseEntity<>(
                WebResult.ok(page.getResult()), httpHeaders, HttpStatus.OK
        );
    }
}
