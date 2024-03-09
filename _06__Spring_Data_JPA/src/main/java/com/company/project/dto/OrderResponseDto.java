package com.company.project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long trackingId;

    private String status;

    private String message;

}
