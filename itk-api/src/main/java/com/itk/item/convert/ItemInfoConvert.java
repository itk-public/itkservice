package com.itk.item.convert;

import com.itk.item.model.ItemInfo;
import com.itk.item.model.ItemInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/13/17.
 */
public class ItemInfoConvert {
    public static ItemInfoVO modelToVO(ItemInfo itemInfo){
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        if (itemInfo != null) {
            BeanUtils.copyProperties(itemInfo, itemInfoVO);
        }
        return itemInfoVO;
    }
}
