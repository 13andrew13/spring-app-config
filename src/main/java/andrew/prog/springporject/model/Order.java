package andrew.prog.springporject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{
    @Id
    @SequenceGenerator (name = "MAIN_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DETAILS")
    private String details;
    @JoinColumn(name = "USER_ID")
    @ManyToOne()
    private User user;


    public Order () {
    }

    public Order (String details) {
        this.details = details;
    }

    public void setDetails (String details) {
        this.details = details;
    }

    public void setUser (User user) {
        this.user = user;
    }

    @Override
    public String toString () {
        return "Order{" +
                "id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
