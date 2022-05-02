
    create table contrato (
       id_contrato  bigserial not null,
        dtfim_contrato date,
        dtinicio_contrato date,
        numero_contrato int8 not null,
        objeto_contrato varchar(255),
        observacao_contrato varchar(255),
        setor_contrato varchar(255),
        situacao_contrato varchar(255),
        tipo_contrato varchar(255),
        vlr_contrato numeric(19, 2),
        empcontratada_id int8 not null,
        empcontratante_id int8 not null,
        primary key (id_contrato)
    );

    create table contrato_arquivo (
       id  bigserial not null,
        arquivo oid,
        descricao varchar(255),
        dt_registro date,
        contrato_id_contrato int8,
        primary key (id)
    );

    create table ocorrencia (
       id  bigserial not null,
        descricao varchar(255),
        dt_registro date,
        processo_id int8,
        primary key (id)
    );

    create table pessoa (
       tipo_pessoa varchar(31) not null,
        id  bigserial not null,
        cpf_cnpj varchar(255),
        nome varchar(255),
        primary key (id)
    );

    create table processo (
       id  bigserial not null,
        dt_inclusao date,
        dt_ultima_mov date,
        local varchar(255),
        numero int4,
        status varchar(255),
        tipo varchar(255),
        vlr_causa numeric(19, 2),
        vlr_despesas numeric(19, 2),
        autor_id int8,
        reu_id int8,
        primary key (id)
    );

    alter table if exists contrato 
       add constraint FKdoy7wqgbu6u0wcifocjo9b4n0 
       foreign key (empcontratada_id) 
       references pessoa;

    alter table if exists contrato 
       add constraint FKhuslufol0yykshahni06fwwq5 
       foreign key (empcontratante_id) 
       references pessoa;

    alter table if exists contrato_arquivo 
       add constraint FKp3lpea6kbdwun7q0yfwcv6cic 
       foreign key (contrato_id_contrato) 
       references contrato;

    alter table if exists ocorrencia 
       add constraint FKl4gxmrw0j9m630sq3cvh28p2s 
       foreign key (processo_id) 
       references processo;

    alter table if exists processo 
       add constraint FK9pbu35ktf8jq0f0ttvym474c7 
       foreign key (autor_id) 
       references pessoa;

    alter table if exists processo 
       add constraint FKctk7olddgdawi47y143r8yn3j 
       foreign key (reu_id) 
       references pessoa;
