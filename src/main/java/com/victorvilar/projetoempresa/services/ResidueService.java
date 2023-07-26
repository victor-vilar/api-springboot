package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.dto.residuetype.ResidueCreateDto;
import com.victorvilar.projetoempresa.dto.residuetype.ResidueResponseDto;
import com.victorvilar.projetoempresa.dto.residuetype.ResidueUpdateDto;
import com.victorvilar.projetoempresa.domain.Residue;
import com.victorvilar.projetoempresa.exceptions.ResidueNotFoundException;
import com.victorvilar.projetoempresa.mappers.ResidueMapper;
import com.victorvilar.projetoempresa.repository.ResidueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ResidueService {

    private final ResidueRepository residueRepository;
    private final ResidueMapper mapper;

    @Autowired
    public ResidueService(
            ResidueRepository residueRepository,
            ResidueMapper mapper){
        this.residueRepository = residueRepository;
        this.mapper = mapper;
    }

    /**
     * get all residues
     * @return a list of ResidueResponseDto
     */
    public List<ResidueResponseDto> getAll() {
        return this.mapper.toResidueTypeResponseDtoList(this.residueRepository.findAll());
    }

    /**
     * get Residue from repository and return as
     * ResidueResponseDto
     * @return ResidueResponseDto
     */
    public ResidueResponseDto getById(Long id){
        return this.mapper.toResidueTypeResponseDto(
                this.residueRepository.findById(id)
                        .orElseThrow(() -> new ResidueNotFoundException("Residue Not Found !"))
        );
    }

    /**
     * get Residue from repository
     * @return Residue
     */
    public Residue findResidueById(Long id){
        return this.residueRepository
                .findById(id)
                .orElseThrow(() -> new ResidueNotFoundException("Residue Not Found !"));
    }

    @Transactional
    public ResidueResponseDto save(ResidueCreateDto residueCreateDto){
        Residue residue = this.mapper.toResidue(residueCreateDto);
        return this.mapper.toResidueTypeResponseDto(this.residueRepository.save(residue));
    }

    @Transactional
    public void delete(Long id){
        Residue residue = this.findResidueById(id);
        this.residueRepository.delete(residue);
    }



    @Transactional
    public ResidueResponseDto udpate(ResidueUpdateDto residueCreateDto){
        Residue residue = this.findResidueById(residueCreateDto.getId());
        residue.setType(residueCreateDto.getType());
        residue.setDescription(residueCreateDto.getDescription());
        this.residueRepository.save(residue);
        return this.mapper.toResidueTypeResponseDto(residue);

    }


}
