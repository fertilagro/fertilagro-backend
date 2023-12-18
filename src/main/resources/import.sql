INSERT INTO cidade (
  id, nome, estado )
VALUES
(
  1,
  'Goiania',
  25
),
(
  15,
  'São Paulo',
  19
),
(
  468,
  'Rio de Janeiro',
  18
),
(
  745,
  'Goianira',
  25
),
(
  998,
  'Santos',
  19
);

CREATE TABLE public.cidade (
	empresa int2 NOT NULL,
	id int2 NOT NULL,
	nome varchar(60) NOT NULL,
	estado int2 NOT NULL
);

ALTER TABLE public.cidade ADD CONSTRAINT cidade_pk PRIMARY KEY (empresa,id);
