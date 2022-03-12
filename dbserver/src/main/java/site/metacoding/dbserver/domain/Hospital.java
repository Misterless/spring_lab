package site.metacoding.dbserver.domain;

import javax.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Hospital {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private Integer id;
    private String addr;
    private Integer mgtStaDd;
    private String pcrPsblYn;
    private String ratPsblYn;
    private Integer recuClCd;
    private String sgguCdNm;
    private String sidoCdNm;
    private String yadmNm;
    private String ykihoEnc;
    private String xposWgs84;
    private String yposWgs84;
    private String xpos;
    private String ypos;
}
