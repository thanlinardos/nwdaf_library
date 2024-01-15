package io.nwdaf.eventsubscription.customModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class NefUeState {
    private String supi;
    private String mcc;
    private String mnc;
    private String name;
    private String external_identifier;
    private String description;
    private String speed;
    private String ip_address_v4;
    private Float latitude;
    private String ip_address_v6;
    private Float longitude;
    private String mac_address;
    private String path_id;
    private String dnn;
    private Integer owner_id;
    @JsonProperty("Cell_id")
    private String Cell_id;
    private String cell_id_hex;
    private String gnb_id_hex;

    @Override
    public String toString() {
        return "class NefUeState {" +
                "supi='" + supi + '\'' +
                ", mcc='" + mcc + '\'' +
                ", mnc='" + mnc + '\'' +
                ", name='" + name + '\'' +
                ", external_identifier='" + external_identifier + '\'' +
                ", description='" + description + '\'' +
                ", speed='" + speed + '\'' +
                ", ip_address_v4='" + ip_address_v4 + '\'' +
                ", latitude='" + latitude + '\'' +
                ", ip_address_v6='" + ip_address_v6 + '\'' +
                ", longitude='" + longitude + '\'' +
                ", mac_address='" + mac_address + '\'' +
                ", path_id='" + path_id + '\'' +
                ", dnn='" + dnn + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", Cell_id='" + Cell_id + '\'' +
                ", cell_id_hex='" + cell_id_hex + '\'' +
                ", gnb_id_hex='" + gnb_id_hex + '\'' +
                '}';
    }
}
