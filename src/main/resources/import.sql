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

INSERT INTO public.sequencia (empresa, tabela, sequencia) VALUES(1, 'CIDADE', 0);



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
INSERT INTO public.sequencia (empresa, tabela, sequencia) VALUES(1, 'PESSOA', 0);



CREATE TABLE public.pedido (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	"data" date NOT NULL,
	pessoa int4 NOT NULL,
	status int2 NULL,
	CONSTRAINT pedido_pk PRIMARY KEY (empresa, id)
);
INSERT INTO public.sequencia (empresa, tabela, sequencia) VALUES(1, 'PEDIDO', 0);



CREATE TABLE public.pedidoamostra (
	empresa int2 NOT NULL,
	pedido int2 NOT NULL,
	id int2 NOT NULL,
	amostra int4 NULL,
	CONSTRAINT pedidoamostra_pk PRIMARY KEY (empresa, pedido, id),
	CONSTRAINT fk_pedidoamostra_pedido FOREIGN KEY (pedido,empresa) REFERENCES pedido (id,empresa),
	CONSTRAINT fk_pedidoamostra_amostra FOREIGN KEY (amostra,empresa) REFERENCES amostra (id,empresa)
);
INSERT INTO public.sequencia (empresa, tabela, sequencia) VALUES(1, 'PEDIDOAMOSTRA', 0);



CREATE TABLE public.amostra (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	propriedade varchar(60) NOT NULL,
	cliente int2 NOT NULL,
	solicitante varchar(60) NOT NULL,
	entrada date NOT NULL,
	saida date NOT NULL,
	descricaoamostra varchar(200) NOT NULL,
	matriz int2 NOT NULL,
	tipoanalise varchar(60) NOT NULL,
	valor numeric(15, 4) NOT NULL,
	observacao varchar(500) NULL,
	status int2 NULL,
	CONSTRAINT amostra_pk PRIMARY KEY (empresa, id),
	CONSTRAINT fk_amostra_pessoa FOREIGN KEY (empresa,cliente) REFERENCES public.pessoa(empresa,id)
);

INSERT INTO public.sequencia (empresa, tabela, sequencia) VALUES(1, 'AMOSTRA', 0);






















