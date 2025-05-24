
CREATE TABLE usuario (
    id_usuario serial PRIMARY KEY,
    nome varchar(100),
    login varchar(30) UNIQUE,
    senha varchar(30)
);

CREATE TABLE cliente (
    id_cliente serial PRIMARY KEY,
    nome varchar(100),
    cpf char(11),
    telefones varchar(50),
    endereco varchar(200),
    link_endereco varchar(100)
);

CREATE TABLE tipo_chocolate (
    id_tipo_chocolate serial PRIMARY KEY,
    descricao varchar(100)
);

CREATE TABLE produto (
    id_produto serial PRIMARY KEY,
    descricao varchar(200),
    vlr_unitario numeric(5,2),
    observacoes varchar(200),
    id_tipo_chocolate integer,
    FOREIGN KEY(id_tipo_chocolate) REFERENCES tipo_chocolate (id_tipo_chocolate)
);

CREATE TABLE metodo_pagto (
    id_metodo_pagto serial PRIMARY KEY,
    descricao varchar(50)
);

CREATE TABLE pedido (
    id_pedido serial PRIMARY KEY,
    dt_hr_pedido timestamp,
    dt_hr_entrega timestamp,
    vlr_total_pedido numeric(6,2),
    desconto numeric(5,2),
    nome_destinatario varchar(100),
    retirada_loja boolean,
    status_pagto char(1),
    status_pedido char(1),
    observacoes varchar(200),
    id_cliente integer,
    id_metodo_pagto integer,
    id_usuario integer,
    FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY(id_metodo_pagto) REFERENCES metodo_pagto (id_metodo_pagto),
    FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE item_pedido (
    id_item_pedido serial PRIMARY KEY,
    qtde integer,
    vlr_total_item numeric(6,2),
    id_pedido integer,
    id_produto integer,
    FOREIGN KEY(id_pedido) REFERENCES pedido (id_pedido),
    FOREIGN KEY(id_produto) REFERENCES produto (id_produto)
);