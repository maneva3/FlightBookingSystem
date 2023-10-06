package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.IdentificationDocument;
import com.flightbookingsystem.dto.CreateIdentificationDocumentDTO;
import com.flightbookingsystem.dto.IdentificationDocumentDTO;
import com.flightbookingsystem.dto.UpdateIdentificationDocumentDTO;
import com.flightbookingsystem.services.IdentificationDocumentService;
import com.flightbookingsystem.web.view.model.CreateIdentificationDocumentViewModel;
import com.flightbookingsystem.web.view.model.IdentificationDocumentViewModel;
import com.flightbookingsystem.web.view.model.UpdateIdentificationDocumentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/identificationDocument")
public class IdentificationDocumentApiController {
    private final IdentificationDocumentService identificationDocumentService;
    private final ModelMapper modelMapper;

    private IdentificationDocumentViewModel convertToIdentificationDocumentViewModel(IdentificationDocumentDTO identificationDocumentDTO) {
        return modelMapper.map(identificationDocumentDTO, IdentificationDocumentViewModel.class);
    }

    @GetMapping("/{identificationNumber}")
    public IdentificationDocumentDTO getIdentificationDocument(@PathVariable("identificationNumber") String identificationNumber){
        return identificationDocumentService.getIdentificationDocument(identificationNumber);
    }

    @PostMapping
    public IdentificationDocument createIdentificationDocument(@RequestBody CreateIdentificationDocumentViewModel identificationDocument) {
        return identificationDocumentService.create(modelMapper.map(identificationDocument, CreateIdentificationDocumentDTO.class));
    }

    @PutMapping("/{identificationNumber}")
    public IdentificationDocument updateIdentificationDocument(@PathVariable("identificationNumber") String identificationNumber,
                                                               @RequestBody UpdateIdentificationDocumentViewModel identificationDocument) {
        return identificationDocumentService.updateIdentificationDocument(identificationNumber, modelMapper.map(identificationDocument, UpdateIdentificationDocumentDTO.class));
    }


    @DeleteMapping("/{identificationNumber}")
    public void deleteIdentificationDocument(@PathVariable("identificationNumber") String identificationNumber) {
        identificationDocumentService.deleteIdentificationDocument(identificationNumber);
    }


}
