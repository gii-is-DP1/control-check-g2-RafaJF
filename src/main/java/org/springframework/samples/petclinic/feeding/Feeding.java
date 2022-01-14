package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feeding extends BaseEntity {
    
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "start_date")
    @NotNull
    LocalDate startDate;

    @NotNull
    @Min(value = 1)
    @Column(name = "weeks_duration")
    double weeksDuration;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet")
    Pet pet;   

    @ManyToOne
    @JoinColumn(name = "feedingType")
    FeedingType feedingType;
}
