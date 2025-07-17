DROP TABLE IF EXISTS responsaveis;
DROP TABLE IF EXISTS pessoas_acampamentos;
DROP TABLE IF EXISTS desafios_insignias_feitas;
DROP TABLE IF EXISTS desafios_especialidades_feitas;
DROP TABLE IF EXISTS desafios_distintivos_feitas;
DROP TABLE IF EXISTS dados_saude;
DROP TABLE IF EXISTS pessoas;
DROP TABLE IF EXISTS tipos_sanguineos;
DROP TABLE IF EXISTS insignias;
DROP TABLE IF EXISTS areas_de_conhecimentos_especialidades;
DROP TABLE IF EXISTS especialidades;
DROP TABLE IF EXISTS distintivos;
DROP TABLE IF EXISTS areas_de_conhecimentos;
DROP TABLE IF EXISTS acampamentos;

create table acampamentos
(
    id_acampamento bigint auto_increment
        primary key,
    data           datetime(6)  not null,
    nome           varchar(255) not null
);

create table areas_de_conhecimentos
(
    id_area_de_conhecimento bigint auto_increment
        primary key,
    nome                    varchar(255) not null
);

create table distintivos
(
    id_distintivo bigint auto_increment
        primary key,
    nome          varchar(255) not null
);

create table especialidades
(
    id_especialidade                             bigint auto_increment
        primary key,
    nome                                         varchar(255) not null,
    area_de_conhecimento_id_area_de_conhecimento bigint       null,
    constraint FKh73kb3gqat6gvecxj8s2vu16e
        foreign key (area_de_conhecimento_id_area_de_conhecimento) references areas_de_conhecimentos (id_area_de_conhecimento)
);

create table areas_de_conhecimentos_especialidades
(
    areas_de_conhecimentos_id_area_de_conhecimento bigint not null,
    especialidades_id_especialidade                bigint not null,
    constraint UKmayo71mbvba8sk4pwmdenblhn
        unique (especialidades_id_especialidade),
    constraint FKbc1d37v4ywkeqxeo3eaim5obk
        foreign key (areas_de_conhecimentos_id_area_de_conhecimento) references areas_de_conhecimentos (id_area_de_conhecimento),
    constraint FKtjvy75e6kx4vyj6fn16hm9wwt
        foreign key (especialidades_id_especialidade) references especialidades (id_especialidade)
);

create table insignias
(
    id_insignia bigint auto_increment
        primary key,
    nome        varchar(255) not null
);

create table tipos_sanguineos
(
    id_tipo_sanguineo bigint auto_increment
        primary key,
    tipo              varchar(45) not null
);

create table pessoas
(
    id_pessoa                        bigint auto_increment
        primary key,
    data_nascimento                  datetime(6)  not null,
    email                            varchar(255) not null,
    nome                             varchar(255) not null,
    telefone                         varchar(45)  not null,
    tipo_sanguineo_id_tipo_sanguineo bigint       null,
    constraint FKavw05flv60f15lmcrxid6y6dd
        foreign key (tipo_sanguineo_id_tipo_sanguineo) references tipos_sanguineos (id_tipo_sanguineo)
);

create table dados_saude
(
    id_dados_saude   bigint auto_increment
        primary key,
    descricao        varchar(255) not null,
    tipo_problema    varchar(255) not null,
    pessoa_id_pessoa bigint       null,
    constraint FK2kln3icls8urdmu305q08vnq8
        foreign key (pessoa_id_pessoa) references pessoas (id_pessoa)
);

create table desafios_distintivos_feitas
(
    id_desafio_distintivo_feita bigint auto_increment
        primary key,
    data_fim                    datetime(6) not null,
    data_inicio                 datetime(6) not null,
    distintivo_id_distintivo    bigint      null,
    pessoa_id_pessoa            bigint      null,
    constraint FK3tstujd70gsf9b7cdojfby6j4
        foreign key (distintivo_id_distintivo) references distintivos (id_distintivo),
    constraint FKkt524fipo29fxia61jenodjq7
        foreign key (pessoa_id_pessoa) references pessoas (id_pessoa)
);

create table desafios_especialidades_feitas
(
    id_desafio_especialidade_feita bigint auto_increment
        primary key,
    data                           datetime(6)  not null,
    descricao                      varchar(255) not null,
    especialidade_id_especialidade bigint       null,
    pessoa_id_pessoa               bigint       null,
    constraint FKrcxwai3k91h431uclvo1xbe7n
        foreign key (especialidade_id_especialidade) references especialidades (id_especialidade),
    constraint FKtdthq0bc1iiuetgi8tdihadh9
        foreign key (pessoa_id_pessoa) references pessoas (id_pessoa)
);

create table desafios_insignias_feitas
(
    id_desafio_insignia_feita bigint auto_increment
        primary key,
    data                      datetime(6) not null,
    insignia_id_insignia      bigint      null,
    pessoa_id_pessoa          bigint      null,
    constraint FK7ket29x7o20qxy79un3cfeaht
        foreign key (insignia_id_insignia) references insignias (id_insignia),
    constraint FKol9hsfs4ajybm6vp6n8hn09n
        foreign key (pessoa_id_pessoa) references pessoas (id_pessoa)
);

create table pessoas_acampamentos
(
    id_pessoa      bigint not null,
    id_acampamento bigint not null,
    constraint FKmdeuq1hcd0ebu8srpxaw8udgc
        foreign key (id_acampamento) references acampamentos (id_acampamento),
    constraint FKn2pmbxd32hi646v3f7mgw4bv2
        foreign key (id_pessoa) references pessoas (id_pessoa)
);

create table responsaveis
(
    id_responsavel   bigint auto_increment
        primary key,
    email            varchar(255) not null,
    nome             varchar(255) not null,
    telefone         varchar(45)  not null,
    pessoa_id_pessoa bigint       null,
    constraint FK8nefv4gfmdyrygawwibteyv7q
        foreign key (pessoa_id_pessoa) references pessoas (id_pessoa)
);


-- Inserção de tipos sanguíneos
INSERT INTO tipos_sanguineos (tipo) VALUES
('A+'), ('A-'), ('B+'), ('B-'), ('AB+'), ('AB-'), ('O+'), ('O-');

-- Inserção de áreas de conhecimento
INSERT INTO areas_de_conhecimentos (nome) VALUES
('Ciência e Tecnologia'),
('Cultura'),
('Desportos'),
('Habilidades Escoteiras'),
('Serviços');

-- Inserção de especialidades
INSERT INTO especialidades (nome, area_de_conhecimento_id_area_de_conhecimento) VALUES
('Radioamadorismo', 1),
('Criptografia', 1),
('Animais Peçonhentos', 1),
('Astronomia', 1),
('Primeiros Socorros', 4),
('Natação', 3),
('Culinária', 4),
('Música', 2),
('Artesanato', 2),
('Jardinagem', 5);

-- Inserção de distintivos de progressão
INSERT INTO distintivos (nome) VALUES
('Lobo Pata Tenra'),
('Lobo Saltador'),
('Lobo Rastreador'),
('Lobo Caçador'),
('Cruzeiro do Sul');

-- Inserção de insígnias de interesse especial
INSERT INTO insignias (nome) VALUES
('Campeões da Natureza'),
('Reduzir, Reciclar, Reutilizar'),
('Escoteiros Pela Energia Solar'),
('Lusofonia'),
('Ação Comunitária'),
('Conselho'),
('Aprender');

-- Inserção de acampamentos
INSERT INTO acampamentos (data, nome) VALUES
('2024-03-15', 'Acampamento de Integração'),
('2024-06-20', 'Acampamento de Inverno'),
('2024-09-12', 'Acampamento da Primavera'),
('2024-11-01', 'Acampamento Nacional');

-- Inserção de jovens (pessoas)
INSERT INTO pessoas (nome, data_nascimento, email, telefone, tipo_sanguineo_id_tipo_sanguineo) VALUES
('João Silva', '2016-05-10', 'joao.silva@email.com', '(48) 99999-1111', 1),
('Maria Oliveira', '2015-08-15', 'maria.oliveira@email.com', '(48) 99999-2222', 3),
('Pedro Santos', '2016-02-20', 'pedro.santos@email.com', '(48) 99999-3333', 5),
('Ana Costa', '2015-11-05', 'ana.costa@email.com', '(48) 99999-4444', 7),
('Lucas Pereira', '2016-07-30', 'lucas.pereira@email.com', '(48) 99999-5555', 2);

-- Inserção de dados de saúde
INSERT INTO dados_saude (descricao, tipo_problema, pessoa_id_pessoa) VALUES
('Alergia a amendoim', 'Alergia alimentar', 1),
('Asma leve', 'Problema respiratório', 2),
('Nenhum problema conhecido', 'Nenhum', 3),
('Intolerância a lactose', 'Intolerância alimentar', 4),
('Alergia a picada de abelha', 'Alergia', 5);

-- Inserção de responsáveis
INSERT INTO responsaveis (nome, email, telefone, pessoa_id_pessoa) VALUES
('Carlos Silva', 'carlos.silva@email.com', '(48) 98888-1111', 1),
('Sandra Oliveira', 'sandra.oliveira@email.com', '(48) 98888-2222', 2),
('Antônio Santos', 'antonio.santos@email.com', '(48) 98888-3333', 3),
('Juliana Costa', 'juliana.costa@email.com', '(48) 98888-4444', 4),
('Roberto Pereira', 'roberto.pereira@email.com', '(48) 98888-5555', 5);

-- Inserção de participação em acampamentos
INSERT INTO pessoas_acampamentos (id_pessoa, id_acampamento) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 3), (2, 4),
(3, 1), (3, 2),
(4, 1), (4, 4),
(5, 1), (5, 2), (5, 3), (5, 4);

-- Inserção de desafios de especialidades feitas
INSERT INTO desafios_especialidades_feitas (data, descricao, especialidade_id_especialidade, pessoa_id_pessoa) VALUES
('2024-04-10', 'Concluiu 4 requisitos', 1, 1),
('2024-05-15', 'Concluiu 8 requisitos', 1, 1),
('2024-04-20', 'Concluiu 4 requisitos', 2, 2),
('2024-06-05', 'Concluiu 4 requisitos', 3, 3),
('2024-07-12', 'Concluiu 8 requisitos', 5, 4),
('2024-08-20', 'Concluiu todos os requisitos', 6, 5),
('2024-09-01', 'Concluiu 4 requisitos', 7, 1),
('2024-09-15', 'Concluiu 4 requisitos', 8, 2),
('2024-10-05', 'Concluiu 4 requisitos', 9, 3),
('2024-10-20', 'Concluiu 4 requisitos', 10, 4);

-- Inserção de desafios de distintivos feitos
INSERT INTO desafios_distintivos_feitas (data_inicio, data_fim, distintivo_id_distintivo, pessoa_id_pessoa) VALUES
('2024-01-10', '2024-03-15', 1, 1),
('2024-01-15', '2024-04-20', 1, 2),
('2024-02-01', '2024-05-10', 1, 3),
('2024-03-01', '2024-06-15', 2, 1),
('2024-04-01', '2024-07-20', 2, 2),
('2024-05-01', '2024-08-10', 3, 1),
('2024-06-01', '2024-09-15', 3, 5),
('2024-07-01', '2024-10-20', 4, 5);

-- Inserção de desafios de insígnias feitas
INSERT INTO desafios_insignias_feitas (data, insignia_id_insignia, pessoa_id_pessoa) VALUES
('2024-05-20', 1, 1),
('2024-06-10', 2, 2),
('2024-07-05', 3, 3),
('2024-08-15', 4, 4),
('2024-09-20', 5, 5),
('2024-10-10', 7, 1),
('2024-10-15', 7, 5);

-- Relacionamento entre áreas de conhecimento e especialidades
INSERT INTO areas_de_conhecimentos_especialidades (areas_de_conhecimentos_id_area_de_conhecimento, especialidades_id_especialidade) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 8), (2, 9),
(3, 6),
(4, 5), (4, 7),
(5, 10);