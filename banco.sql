--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Debian 15.2-1.pgdg110+1)
-- Dumped by pg_dump version 15.2 (Debian 15.2-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: atendente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atendente (
    id integer NOT NULL,
    cpf character varying(255),
    nome character varying(255)
);


ALTER TABLE public.atendente OWNER TO postgres;

--
-- Name: atendimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atendimento (
    id integer NOT NULL,
    data timestamp without time zone,
    atendente_id integer,
    medico_id integer
);


ALTER TABLE public.atendimento OWNER TO postgres;

--
-- Name: atendimento_paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atendimento_paciente (
    id integer NOT NULL,
    atendimento_id integer,
    paciente_id integer
);


ALTER TABLE public.atendimento_paciente OWNER TO postgres;

--
-- Name: especialidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especialidade (
    id integer NOT NULL,
    tipo character varying(255)
);


ALTER TABLE public.especialidade OWNER TO postgres;

--
-- Name: especialidade_medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especialidade_medico (
    id integer NOT NULL,
    especialidade_id integer,
    medico_id integer
);


ALTER TABLE public.especialidade_medico OWNER TO postgres;

--
-- Name: hospital; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hospital (
    id integer NOT NULL,
    cnpj character varying(255),
    nome character varying(255)
);


ALTER TABLE public.hospital OWNER TO postgres;

--
-- Name: hospital_medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hospital_medico (
    id integer NOT NULL,
    hospital_id integer,
    medico_id integer
);


ALTER TABLE public.hospital_medico OWNER TO postgres;

--
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    id integer NOT NULL,
    crm integer,
    nome character varying(255)
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    cep character varying(255),
    complemento character varying(255),
    cpf character varying(255),
    nome character varying(255),
    plano_id integer
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- Name: pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento (
    id integer NOT NULL,
    valor real,
    atendente_id integer,
    paciente_id integer,
    tipo_pagamento_id integer
);


ALTER TABLE public.pagamento OWNER TO postgres;

--
-- Name: plano; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plano (
    id integer NOT NULL,
    codigo integer
);


ALTER TABLE public.plano OWNER TO postgres;

--
-- Name: seq_atendente_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_atendente_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_atendente_id OWNER TO postgres;

--
-- Name: seq_atendimento_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_atendimento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_atendimento_id OWNER TO postgres;

--
-- Name: seq_atendimento_paciente_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_atendimento_paciente_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_atendimento_paciente_id OWNER TO postgres;

--
-- Name: seq_especialidade_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_especialidade_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_especialidade_id OWNER TO postgres;

--
-- Name: seq_especialidade_medico_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_especialidade_medico_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_especialidade_medico_id OWNER TO postgres;

--
-- Name: seq_hospital_medico_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_hospital_medico_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_hospital_medico_id OWNER TO postgres;

--
-- Name: seq_hosptital_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_hosptital_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_hosptital_id OWNER TO postgres;

--
-- Name: seq_medico_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_medico_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_medico_id OWNER TO postgres;

--
-- Name: seq_paciente_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_paciente_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_paciente_id OWNER TO postgres;

--
-- Name: seq_pagamento_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_pagamento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_pagamento_id OWNER TO postgres;

--
-- Name: seq_plano_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_plano_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_plano_id OWNER TO postgres;

--
-- Name: seq_tipo_pagamento_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_tipo_pagamento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_tipo_pagamento_id OWNER TO postgres;

--
-- Name: tipo_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_pagamento (
    id integer NOT NULL,
    tipo character varying(255)
);


ALTER TABLE public.tipo_pagamento OWNER TO postgres;

--
-- Data for Name: atendente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atendente (id, cpf, nome) FROM stdin;
1	123.456.789-10	Americo Braga
\.


--
-- Data for Name: atendimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atendimento (id, data, atendente_id, medico_id) FROM stdin;
\.


--
-- Data for Name: atendimento_paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atendimento_paciente (id, atendimento_id, paciente_id) FROM stdin;
\.


--
-- Data for Name: especialidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.especialidade (id, tipo) FROM stdin;
\.


--
-- Data for Name: especialidade_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.especialidade_medico (id, especialidade_id, medico_id) FROM stdin;
\.


--
-- Data for Name: hospital; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hospital (id, cnpj, nome) FROM stdin;
\.


--
-- Data for Name: hospital_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hospital_medico (id, hospital_id, medico_id) FROM stdin;
\.


--
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (id, crm, nome) FROM stdin;
\.


--
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente (id, cep, complemento, cpf, nome, plano_id) FROM stdin;
\.


--
-- Data for Name: pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento (id, valor, atendente_id, paciente_id, tipo_pagamento_id) FROM stdin;
\.


--
-- Data for Name: plano; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plano (id, codigo) FROM stdin;
\.


--
-- Data for Name: tipo_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_pagamento (id, tipo) FROM stdin;
\.


--
-- Name: seq_atendente_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_atendente_id', 1, true);


--
-- Name: seq_atendimento_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_atendimento_id', 1, false);


--
-- Name: seq_atendimento_paciente_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_atendimento_paciente_id', 1, false);


--
-- Name: seq_especialidade_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_especialidade_id', 1, false);


--
-- Name: seq_especialidade_medico_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_especialidade_medico_id', 1, false);


--
-- Name: seq_hospital_medico_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_hospital_medico_id', 1, false);


--
-- Name: seq_hosptital_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_hosptital_id', 1, false);


--
-- Name: seq_medico_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_medico_id', 1, false);


--
-- Name: seq_paciente_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_paciente_id', 1, false);


--
-- Name: seq_pagamento_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_pagamento_id', 1, false);


--
-- Name: seq_plano_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_plano_id', 1, false);


--
-- Name: seq_tipo_pagamento_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_tipo_pagamento_id', 1, false);


--
-- Name: atendente atendente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendente
    ADD CONSTRAINT atendente_pkey PRIMARY KEY (id);


--
-- Name: atendimento_paciente atendimento_paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento_paciente
    ADD CONSTRAINT atendimento_paciente_pkey PRIMARY KEY (id);


--
-- Name: atendimento atendimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento
    ADD CONSTRAINT atendimento_pkey PRIMARY KEY (id);


--
-- Name: especialidade_medico especialidade_medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade_medico
    ADD CONSTRAINT especialidade_medico_pkey PRIMARY KEY (id);


--
-- Name: especialidade especialidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade
    ADD CONSTRAINT especialidade_pkey PRIMARY KEY (id);


--
-- Name: hospital_medico hospital_medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospital_medico
    ADD CONSTRAINT hospital_medico_pkey PRIMARY KEY (id);


--
-- Name: hospital hospital_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospital
    ADD CONSTRAINT hospital_pkey PRIMARY KEY (id);


--
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);


--
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- Name: pagamento pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);


--
-- Name: plano plano_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano
    ADD CONSTRAINT plano_pkey PRIMARY KEY (id);


--
-- Name: tipo_pagamento tipo_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_pagamento
    ADD CONSTRAINT tipo_pagamento_pkey PRIMARY KEY (id);


--
-- Name: atendimento_paciente fk262r7b214ciepmyb9utfvjspt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento_paciente
    ADD CONSTRAINT fk262r7b214ciepmyb9utfvjspt FOREIGN KEY (atendimento_id) REFERENCES public.atendimento(id);


--
-- Name: paciente fk80ercf9sf9nb94stdsn7dc5uc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT fk80ercf9sf9nb94stdsn7dc5uc FOREIGN KEY (plano_id) REFERENCES public.plano(id);


--
-- Name: hospital_medico fk9gp6uo0mahdgf2yj7iiqydpq7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospital_medico
    ADD CONSTRAINT fk9gp6uo0mahdgf2yj7iiqydpq7 FOREIGN KEY (hospital_id) REFERENCES public.hospital(id);


--
-- Name: especialidade_medico fka4v9rc6deehilw60d58tads24; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade_medico
    ADD CONSTRAINT fka4v9rc6deehilw60d58tads24 FOREIGN KEY (especialidade_id) REFERENCES public.especialidade(id);


--
-- Name: pagamento fkcff6r4cu65elu1jgvf2tun74t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT fkcff6r4cu65elu1jgvf2tun74t FOREIGN KEY (paciente_id) REFERENCES public.paciente(id);


--
-- Name: especialidade_medico fkcp19wg2cj9fhm54q0lhkcavon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade_medico
    ADD CONSTRAINT fkcp19wg2cj9fhm54q0lhkcavon FOREIGN KEY (medico_id) REFERENCES public.medico(id);


--
-- Name: pagamento fkda44t9l6pmuqrolntvwoi1cuw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT fkda44t9l6pmuqrolntvwoi1cuw FOREIGN KEY (tipo_pagamento_id) REFERENCES public.tipo_pagamento(id);


--
-- Name: atendimento fkg8obynju1xm7vlx8m6jts476y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento
    ADD CONSTRAINT fkg8obynju1xm7vlx8m6jts476y FOREIGN KEY (atendente_id) REFERENCES public.atendente(id);


--
-- Name: atendimento_paciente fkildtygycfpca9n2cd8732mpag; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento_paciente
    ADD CONSTRAINT fkildtygycfpca9n2cd8732mpag FOREIGN KEY (paciente_id) REFERENCES public.paciente(id);


--
-- Name: hospital_medico fkqdlrx2trscy69idw1vluyg3th; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hospital_medico
    ADD CONSTRAINT fkqdlrx2trscy69idw1vluyg3th FOREIGN KEY (medico_id) REFERENCES public.medico(id);


--
-- Name: pagamento fkqe0ntkmb90vcno0xnq6b04mhe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT fkqe0ntkmb90vcno0xnq6b04mhe FOREIGN KEY (atendente_id) REFERENCES public.atendente(id);


--
-- Name: atendimento fkqlaffnrf4fa98heo2bsbt3q2w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendimento
    ADD CONSTRAINT fkqlaffnrf4fa98heo2bsbt3q2w FOREIGN KEY (medico_id) REFERENCES public.medico(id);


--
-- PostgreSQL database dump complete
--

