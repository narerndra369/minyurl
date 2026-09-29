package com.minyurl.generate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.annotation.processing.Generated;

@Entity
@Table(name = "url_sequence")
@Getter @Setter @NoArgsConstructor
public class UrlSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sequence;
}
