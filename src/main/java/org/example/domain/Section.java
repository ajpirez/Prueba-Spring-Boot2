package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.example.domain.utils.Enum.ProductType;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ProductType productType;
    private Double size;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties(value="section")
    private List<Product> products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    @JsonIgnoreProperties(value={"section"})
    private Store store;
}
