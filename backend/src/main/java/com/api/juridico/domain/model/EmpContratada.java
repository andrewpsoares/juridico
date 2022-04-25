package com.api.juridico.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("EMP_CONTRATADA")
@Entity
public class EmpContratada extends Pessoa{
}
