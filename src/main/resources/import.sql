CREATE TABLE public.sequencia (
	empresa int2 NOT NULL ,
	tabela varchar(60) NOT NULL,
	sequencia int4 NOT NULL,
	CONSTRAINT sequencia_pk PRIMARY KEY (empresa,tabela)
);


CREATE TABLE public.cidade (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	nome varchar(60) NOT NULL,
	estado int2 NOT NULL,
  CONSTRAINT cidade_pk PRIMARY KEY (empresa,id);
);

