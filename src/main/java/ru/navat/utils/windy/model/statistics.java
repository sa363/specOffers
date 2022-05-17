package ru.navat.utils.windy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@EntityListeners(AuditingEntityListener.class)
public class statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ip;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date requestDate;

    private Double lat;
    private Double lon;
    private Double radius;
    private String ua;
    private String userID;
    private Double ulat;
    private Double ulon;
}
