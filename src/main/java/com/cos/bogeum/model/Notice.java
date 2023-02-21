package com.cos.bogeum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "notice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR4",
        sequenceName = "USER_SEQ4",
        initialValue = 1,
        allocationSize = 1
)

public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR4")
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private Users users;

//    @OneToMany(mappedBy = "notice", fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
//    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}