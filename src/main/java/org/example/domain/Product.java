package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.example.domain.utils.Enum.ContainerType;
import org.example.domain.utils.Enum.ProductType;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double size;
    private String color;
    private Double price;
    private Boolean fragile;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ContainerType containerType;
    private Integer lote;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    @JsonIgnoreProperties(value = {"products","store"})
    private Section section;
}
