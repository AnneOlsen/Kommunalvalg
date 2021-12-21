package kommunalvalg.demo.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="votes")
public class Votes {



    @Id
    @Column
    private String politicalParty;

    @Column
    private double votes;

}
