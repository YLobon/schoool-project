package com.luna.school.anneescolaire.application.vm;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-10-09
 */
@Getter
@Setter
public class JwtToken {
    private UUID id;
    private String token;
    private boolean premiereConnection;
    private boolean expirer;
    private boolean revoquer;

    public JwtToken() {
        this(null, false);
    }

    public JwtToken(String token, boolean premiereConnection) {
        this.id = UUID.randomUUID();
        this.token = token;
        this.premiereConnection = premiereConnection;
        this.expirer = false;
        this.revoquer = false;
    }
}
