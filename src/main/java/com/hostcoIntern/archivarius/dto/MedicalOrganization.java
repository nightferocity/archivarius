package com.hostcoIntern.archivarius.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalOrganization {

    String shortName;
    String codeMo;
    boolean isShown;
}
