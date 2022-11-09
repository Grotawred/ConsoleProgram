package org.example.entities;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Getter
    private int id;
    @Getter
    @Setter
    private int stockId;
    @Getter
    @Setter
    private int customerId;
    @Getter
    @Setter
    private int quantity;
}
