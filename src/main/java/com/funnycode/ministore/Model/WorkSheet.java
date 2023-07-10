package com.funnycode.ministore.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkSheet {

    @Id
    String idWorkSheet;
    Date date;
    int sheet;

    @OneToOne()
    @JoinColumn(name = "id_emp")
    Employee employee;

}
