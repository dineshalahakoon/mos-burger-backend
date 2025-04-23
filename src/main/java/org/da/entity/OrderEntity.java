package org.da.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String orderid;
    private String date;
    private String time;
    private String orderTotal;
    private String discount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_custId", referencedColumnName = "custId")
    private CustomerEntity custometEntity;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemEntity> itemEntityList;

}
