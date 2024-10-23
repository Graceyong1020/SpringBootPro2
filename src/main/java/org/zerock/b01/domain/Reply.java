package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "Reply", indexes = { // index는 검색 속도를 높이기 위해 사용 (데이터베이스 성능 향상)
        @Index(name = "idx_board_bno", columnList = "board_bno")
})
@Getter
@Builder
@AllArgsConstructor // 생성자 자동 생성
@NoArgsConstructor // 빈 생성자 자동 생성
@ToString
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    private String replyText;
    private String replyer;

    public void changeText(String text) {
        this.replyText = text;
    }


}
