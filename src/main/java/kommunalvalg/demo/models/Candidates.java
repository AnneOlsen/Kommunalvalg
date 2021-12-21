package kommunalvalg.demo.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="candidates")

public class Candidates {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;
    
    @Column
    private String politicalParty;

}
