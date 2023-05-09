package stmallrecently.domain;

import java.util.*;
import lombok.*;
import stmallrecently.domain.*;
import stmallrecently.infra.AbstractEvent;

@Data
@ToString
public class StockIncresed extends AbstractEvent {

    private Long id;
    private String productName;
    private String stock;
}
