package com.stefanini.parser;

import com.stefanini.dto.jogador.JogadorRequest;
import com.stefanini.entity.Jogador;

public class JogadorParser {
    public static Jogador requestToEntity(JogadorRequest jogadorRequest) {
        return new Jogador(jogadorRequest.getNickname(), jogadorRequest.getSaldo(), jogadorRequest.getStefamonList());
    }
}
