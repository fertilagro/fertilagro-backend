package com.fertilagro.fertilagroapp.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.dto.CidadeDTO;
import com.fertilagro.fertilagroapp.dto.FkfieldDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.service.CidadeService;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends SuperController<CidadeVO, CidadeDTO> implements Serializable {

	private static final long serialVersionUID = 1062932981149544270L;
	
	@Autowired
	private CidadeService cidadeService;
	
	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@Override
	protected SuperService<CidadeVO> getSuperControler() {
		return cidadeService;
	}
	
  /*  @PostMapping("/buscarPorFkField")
    public ResponseEntity<List<FkfieldDTO<CidadeVO, CidadeDTO>>> buscarPorFkField(@RequestBody String dados) {
    	List<CidadeVO> cidades = cidadeService.buscarPorFkField(dados); 	
    	List<CidadeDTO> cidadesDTO = new ArrayList<CidadeDTO>();	
    	CidadeDTO DTO = new CidadeDTO();
    	
        ArrayList<FkfieldDTO<CidadeVO, CidadeDTO>> retorno = new ArrayList<FkfieldDTO<CidadeVO, CidadeDTO>>();
    	retorno = new FkfieldDTO<CidadeVO, CidadeDTO>();
        
    	try {
        	DTO.convertListVOparaDTO(cidades, cidadesDTO);
            retorno.add(new FkfieldDTO<CidadeVO, CidadeDTO>((CidadeDTO) cidadesDTO));
            
        //    retorno.add(new FkfieldDTO<T, C>((C) crudDTO));
		} catch (Exception e) {}
    	return new ResponseEntity<>(retorno, HttpStatus.OK);
    }*/
    
}

