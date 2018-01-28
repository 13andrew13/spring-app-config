package andrew.prog.springporject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator (name = "PRODUCT_GEN")

    private Long id;
    private String desriprion;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
