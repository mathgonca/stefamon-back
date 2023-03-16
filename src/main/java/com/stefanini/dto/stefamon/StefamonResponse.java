package com.stefanini.dto.stefamon;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class StefamonResponse {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "rockitten")
    private String nome;

    @Schema(example = "55")
    private Integer vida;

    @Schema(example = "31")
    private Integer ataque;

    @Schema(example = "30")
    private Integer defesa;

    @Schema(example = "91")
    private Integer inteligencia;

    @Schema(example = "56")
    private Integer poder;

    @Schema(example = "21")
    private Integer velocidade;

    @Schema(example = "https://raw.githubusercontent.com" +
            "/Tuxemon/Tuxemon/development/mods/tuxemon/gfx/sprites/battle/rockitten-front.png")
    private String urlFoto;

    public StefamonResponse(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia,
                            Integer poder, Integer velocidade, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.poder = poder;
        this.velocidade = velocidade;
        this.urlFoto = urlFoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}