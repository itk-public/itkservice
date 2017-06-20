package com.itk.solr.repository;

import com.itk.solr.model.SolrItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by young on 2017/6/7.
 */
public interface SolrItemRepository extends SolrCrudRepository<SolrItem,Integer> {

    @Query("item_name_txt_py:?0 or item_shop_category_txt_py:?0 or item_shop_info_txt_py:?0 or item_category_txt_py:?0")
    Page<SolrItem> findByNameOrShopCategoryOrShopInfoOrCategory(String keyword, Pageable pageable);
}
