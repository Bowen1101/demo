-- Table: public.people

-- DROP TABLE public.people;

CREATE TABLE public.people
(
    id integer NOT NULL DEFAULT nextval('people_id_seq'::regclass),
    full_name character varying(20)[] COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(20)[] COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(20)[] COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    email character varying(40)[] COLLATE pg_catalog."default" NOT NULL,
    address character varying(200)[] COLLATE pg_catalog."default" NOT NULL,
    zipcode integer NOT NULL,
    CONSTRAINT people_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.people
    OWNER to postgres;