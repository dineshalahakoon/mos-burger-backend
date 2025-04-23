package org.da.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private Long itemCode;
    private Long price;
    private Integer discount;
    private Integer quantity;
    private Orders Orders;
}
