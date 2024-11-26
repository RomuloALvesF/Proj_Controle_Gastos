package com.romulo.controlegasto.controller;

import com.romulo.controlegasto.converter.Converter;
import com.romulo.controlegasto.dto.GastosDTO;
import com.romulo.controlegasto.model.CategoriaModel;
import com.romulo.controlegasto.model.ContasModel;
import com.romulo.controlegasto.model.GastosModel;
import com.romulo.controlegasto.services.CategoriaService;
import com.romulo.controlegasto.services.ContasService;
import com.romulo.controlegasto.services.GastosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gastos")
public class GastosController {

    private final GastosService gastosService;
    private final CategoriaService categoriaService;
    private final ContasService contasService;

    public GastosController(GastosService gastosService, CategoriaService categoriaService, ContasService contasService) {
        this.gastosService = gastosService;
        this.categoriaService = categoriaService;
        this.contasService = contasService;
    }

    @GetMapping
    public ResponseEntity<List<GastosDTO>> findAll() {
        List<GastosDTO> gastos = gastosService.findAll()
                .stream()
                .map(Converter::toGastosDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(gastos);
    }

    @PostMapping
    public ResponseEntity<GastosDTO> create(@RequestBody GastosDTO gastosDTO) {
        CategoriaModel categoria = categoriaService.findById(gastosDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        ContasModel conta = contasService.findById(gastosDTO.getContaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        GastosModel gasto = gastosService.save(Converter.toGastosModel(gastosDTO, categoria, conta));
        return ResponseEntity.ok(Converter.toGastosDTO(gasto));
    }
}