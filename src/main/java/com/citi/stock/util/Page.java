package com.citi.stock.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Page {
    private Integer page;
    private Integer size;
}
