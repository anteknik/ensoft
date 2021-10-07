package net.nadisa.upwork.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    
}
