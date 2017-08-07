package com.itk.order.convert;

import com.itk.dto.OrderInfoDTO;
import com.itk.order.model.OrderInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by enchen on 6/20/17.
 */
public class OrderInfoConvert {
    public static OrderInfoDTO OrderInfoVOToDTO(OrderInfoVO orderInfoVO){
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        if (orderInfoVO != null) {
            BeanUtils.copyProperties(orderInfoVO, orderInfoDTO);
        }
        return orderInfoDTO;
    }

    public static OrderInfoVO OrderInfoDTOToVO(OrderInfoDTO orderInfoDTO){
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        if (orderInfoDTO != null) {
            BeanUtils.copyProperties(orderInfoDTO, orderInfoVO);
        }
        return orderInfoVO;
    }
}
