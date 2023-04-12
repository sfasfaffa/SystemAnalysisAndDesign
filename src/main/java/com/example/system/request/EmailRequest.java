package com.example.system.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {


    private String recipientAddress;

    private String theme;

    private String mainBody;

    private String appendix;
}
