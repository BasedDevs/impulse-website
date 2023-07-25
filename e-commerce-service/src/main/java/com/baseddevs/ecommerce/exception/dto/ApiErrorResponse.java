package com.baseddevs.ecommerce.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private ZonedDateTime timestamp;
    private String message;
    private ErrorCode errorCode;

}