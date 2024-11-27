package com.romulo.controlegasto.converter;

import com.romulo.controlegasto.dto.*;
import com.romulo.controlegasto.model.*;

public class Converter {


    // Métodos d Usuario


    // Converte UsuarioRequestDTO para UsuarioModel
    public static UsuarioModel toUsuarioModel(UsuarioRequestDTO usuarioRequestDTO) {
        return new UsuarioModel(
                usuarioRequestDTO.getNome(),
                usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getPassword()
        );
    }

    // Converte UsuarioModel para UsuarioResponseDTO
    public static UsuarioResponseDTO toUsuarioResponseDTO(UsuarioModel usuarioModel) {
        return new UsuarioResponseDTO(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail()
        );
    }


    // Métodos de Contas


    public static ContasDTO toContasDTO(ContasModel conta) {
        return new ContasDTO(
                conta.getId(),
                conta.getNome(),
                conta.getBalanco(),
                conta.getUsuario().getId()
        );
    }

    public static ContasModel toContasModel(ContasDTO contaDTO, UsuarioModel usuario) {
        return new ContasModel(
                contaDTO.getNome(),
                contaDTO.getBalanco(),
                usuario
        );
    }


    // Métodos de Gastos

    public static GastosDTO toGastosDTO(GastosModel gasto) {
        return new GastosDTO(
                gasto.getId(),
                gasto.getDescricao(),
                gasto.getPreco(),
                gasto.getData(),
                gasto.getCategoria().getId(),
                gasto.getConta().getId()
        );
    }

    public static GastosModel toGastosModel(GastosDTO gastoDTO, CategoriaModel categoria, ContasModel conta) {
        return new GastosModel(
                gastoDTO.getDescricao(),
                gastoDTO.getPreco(),
                gastoDTO.getData(),
                categoria,
                conta
        );
    }


    // Métodos de Categoria


    public static CategoriaDTO toCategoriaDTO(CategoriaModel categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }

    public static CategoriaModel toCategoriaModel(CategoriaDTO categoriaDTO) {
        return new CategoriaModel(
                categoriaDTO.getNome()
        );
    }
}


