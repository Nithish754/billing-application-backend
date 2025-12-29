package com.mrk.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingPageResDTO {

    private long totalRecords;
    private int totalPages;
    private int currentPage;

    private List<BillingListResDTO> data;
}
