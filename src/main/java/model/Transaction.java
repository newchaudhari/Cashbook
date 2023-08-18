package model;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Transaction {
    private String type;
    private int incomeExpenseId;
    private Date date;
    private Time time;
    private int amount;
    private String remarks;
    private String category;
    private String paymentMode;
}
