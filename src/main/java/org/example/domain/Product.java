package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.Utils.Enum.ContainerType;
import org.example.domain.Utils.Enum.ProductType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_Type", nullable = false)
    private ProductType productType;
    private Double size;
    private String color;
    private Double price;
    private Boolean fragile;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "container_Type", nullable = false)
    private  ContainerType containerType;
    private Integer lote;

    @OneToOne(mappedBy = "product")// La relacion no es OneToOne
    private Section section;
}
