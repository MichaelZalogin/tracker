package ru.mch.tracker.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "user_notification")
public class UserMessenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "messenger")
    private String messenger;

    @Column(name = "identify")
    private String identify;

}