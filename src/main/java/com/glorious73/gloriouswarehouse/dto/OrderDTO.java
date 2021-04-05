package com.glorious73.gloriouswarehouse.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderDTO {
    public LocalDateTime localDateTime = LocalDateTime.now();
    public Set<ItemDTO> items;
}
