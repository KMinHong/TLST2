package kr.eddi.ztz_process.entity.boards;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoard {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    private String content;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDateTime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate upDateTime;

    @PrePersist
    public void createDate(){
        this.createDateTime = LocalDate.now();
        this.upDateTime = LocalDate.now();
    }
}
