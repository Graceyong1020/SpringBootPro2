package org.zerock.b01.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    @NotNull
    private Long rno;
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;

    private LocalDateTime regDate, modDate;
}
