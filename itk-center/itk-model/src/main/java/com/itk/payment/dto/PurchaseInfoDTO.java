package com.itk.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by enchen on 6/20/17.
 */
@Setter
@Getter
public class PurchaseInfoDTO {
    private List<String> orderIds;
    private int purchaseType;
}
