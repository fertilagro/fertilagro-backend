CREATE TABLE public.sequencia (
	empresa int2 NOT NULL ,
	nometabela varchar(40) NOT NULL,
	id int2 NOT NULL,
	CONSTRAINT sequencia_pk PRIMARY KEY (empresa,nometabela,id)
);


CREATE TABLE public.cidade (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	nome varchar(60) NOT NULL,
	estado int2 NOT NULL,
  CONSTRAINT cidade_pk PRIMARY KEY (empresa,id);
);

