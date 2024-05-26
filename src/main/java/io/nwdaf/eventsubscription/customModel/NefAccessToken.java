package io.nwdaf.eventsubscription.customModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class NefAccessToken {

    private String access_token;
    private String token_type;
}
