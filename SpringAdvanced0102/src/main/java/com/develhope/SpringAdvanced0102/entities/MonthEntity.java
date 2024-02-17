package com.develhope.SpringAdvanced0102.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "months")
public class MonthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthId;

    @Column(name = "month_number")
    private Integer monthNumber;
    @Column(name = "english_name")
    private String englishName;
    private String italianName;
    private String germanName;
}
