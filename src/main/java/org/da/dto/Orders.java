package org.da.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String orderid;
    private String date;
    private String time;
    private String orderTotal;
    private String discount;
    private Customer custometEntity;
    private List<Item> itemEntityList;
}
