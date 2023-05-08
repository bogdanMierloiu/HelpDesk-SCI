package ro.sci.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PoliceStructure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "policeStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("policeStructure")
    private List<Department> departments;

    @OneToMany(mappedBy = "policeStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("policeStructure")
    private List<Worker> workers;


}