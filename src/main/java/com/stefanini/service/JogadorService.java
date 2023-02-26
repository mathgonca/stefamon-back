package com.stefanini.service;

import com.stefanini.dto.jogador.JogadorRequest;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.stefanini.parser.JogadorParser.requestToEntity;

@ApplicationScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(JogadorRequest jogadorRequest) {
        verificarNickNameDisponibilidade(jogadorRequest.getNickname());

        Jogador jogador = requestToEntity(jogadorRequest);
        String senhaEncode = Base64.getEncoder().encodeToString(jogadorRequest.getPassword().getBytes());
        jogador.setPassword(senhaEncode);

        jogadorRepository.save(jogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if (Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Long id, JogadorRequest jogadorRequest) {
        Jogador jogador = pegarPorId(id);

        if (!jogador.getNickname().equals(jogadorRequest.getNickname())) {
            verificarNickNameDisponibilidade(jogadorRequest.getNickname());
        }

        Jogador jogadorAtualizado = requestToEntity(jogadorRequest);
        String senhaEncode = Base64.getEncoder().encodeToString(jogadorRequest.getPassword().getBytes());
        jogadorAtualizado.setPassword(senhaEncode);

        jogadorRepository.update(jogadorAtualizado);
    }

    public void deletar(Long id) {
        pegarPorId(id);
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

    public void verificarNickNameDisponibilidade(String nickname) {
        Optional<Jogador> jogadorOptional = jogadorRepository.findByLogin(nickname);
        if (jogadorOptional.isPresent()) {
            throw new RegraDeNegocioException("O nickName " + nickname + " já está em uso por outro jogador.", Response.Status.BAD_REQUEST);
        }
    }
}
