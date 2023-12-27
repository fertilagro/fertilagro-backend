CREATE TABLE public.sequencia (
	empresa int2 NOT NULL ,
	tabela varchar(60) NOT NULL,
	sequencia int4 NOT NULL,
	CONSTRAINT sequencia_pk PRIMARY KEY (empresa,tabela,sequencia)
);


CREATE TABLE public.cidade (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	nome varchar(60) NOT NULL,
	estado int2 NOT NULL,
  CONSTRAINT cidade_pk PRIMARY KEY (empresa,id);
);


CREATE TABLE public.pessoa (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	razaosocial varchar(60) NOT NULL,
	cnpjcpf varchar(14) NOT NULL,
	telefone varchar(20) NOT NULL,
	email varchar(120) NOT NULL,
	endereco varchar(120) NOT NULL,
	cidade int2 NOT NULL,
	status int2 NULL,
  CONSTRAINT pessoa_pk PRIMARY KEY (empresa,id)
);

