package com.api.juridico.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("REU")
@Entity
public class Reu extends Pessoa{
}
