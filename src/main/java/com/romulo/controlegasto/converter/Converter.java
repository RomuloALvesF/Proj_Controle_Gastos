package com.romulo.controlegasto.converter;
import com.romulo.controlegasto.dto.*;
import com.romulo.controlegasto.model.*;

public class Converter {
    //BeanUtils.copyProperties() poderia ser usada também, mas para fins didaticos realizei manual
    // Usuario
    public static UsuarioDTO toUsuarioDTO(UsuarioModel usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPassword());
    }

    public static UsuarioModel toUsuarioModel(UsuarioDTO usuarioDTO) {
        return new UsuarioModel(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getPassword());
    }

    // Contas
    public static ContasDTO toContasDTO(ContasModel conta) {
        return new ContasDTO(conta.getId(), conta.getNome(), conta.getBalanco(), conta.getUsuario().getId());
    }

    public static ContasModel toContasModel(ContasDTO contaDTO, UsuarioModel usuario) {
        return new ContasModel(contaDTO.getNome(), contaDTO.getBalanco(), usuario);
    }

    // Gastos
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

    // Categoria
    public static CategoriaDTO toCategoriaDTO(CategoriaModel categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public static CategoriaModel toCategoriaModel(CategoriaDTO categoriaDTO) {
        return new CategoriaModel(categoriaDTO.getNome());
    }
}

