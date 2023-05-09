package stmallrecently.domain;

import java.util.*;
import lombok.Data;
import stmallrecently.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String orderID;
    private String productID;
    private String productName;
    private Integer qty;
    private String status;
}
