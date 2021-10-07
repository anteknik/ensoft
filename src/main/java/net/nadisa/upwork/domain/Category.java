package net.nadisa.upwork.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author mayanton
 */
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    
    @ManyToOne( )
    private Product product;

}
