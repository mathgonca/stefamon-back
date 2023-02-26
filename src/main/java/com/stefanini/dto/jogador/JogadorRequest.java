package com.stefanini.dto.jogador;

import com.stefanini.entity.Stefamon;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class JogadorRequest {
    @NotNull(message = "O campo nickname não deve ser nulo.")
    @NotEmpty(message = "O campo nickname não deve ser em branco.")
    private String nickname;

    @NotNull(message = "O campo password não deve ser nulo.")
    @NotBlank(message = "O campo password não deve ser em branco.")
    @Size(min = 4, max = 10, message = "Tamanho inválido para o campo password. Tamanho mínimo é igual a 4 caracteres e o máximo é igual a 10 caracteres")
    private String password;

    private BigDecimal saldo;

    private List<Stefamon> stefamonList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Stefamon> getStefamonList() {
        return stefamonList;
    }

    public void setStefamonList(List<Stefamon> stefamonList) {
        this.stefamonList = stefamonList;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
