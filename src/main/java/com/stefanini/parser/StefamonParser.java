package com.stefanini.parser;

import com.stefanini.dto.stefamon.StefamonResponse;
import com.stefanini.entity.Stefamon;

public class StefamonParser {

    public static StefamonResponse entityToDTO(Stefamon stefamon) {
        return new StefamonResponse(
                stefamon.getId(),
                stefamon.getNome(),
                stefamon.getVida(),
                stefamon.getAtaque(),
                stefamon.getDefesa(),
                stefamon.getInteligencia(),
                stefamon.getPoder(),
                stefamon.getVelocidade(),
                stefamon.getUrlFoto()
        );
    }

}
