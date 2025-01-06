package com.kshrd.springdatajpacrud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String bookingDescription;
    private Timestamp bookingDate;
    private Integer bookingBy;
    private Integer recourceId;
}
