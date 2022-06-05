package org.example.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private Long id;
    private String name;
    private Integer cantSections;
}
