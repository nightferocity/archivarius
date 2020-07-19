package dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data

public class MedicalOrganization {

    String shortName;
    String codeMo;
    boolean isShown;
}
